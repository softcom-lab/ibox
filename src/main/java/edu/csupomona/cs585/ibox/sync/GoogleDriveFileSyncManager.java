package edu.csupomona.cs585.ibox.sync;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.google.api.client.http.FileContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.Drive.Files.List;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;


public class GoogleDriveFileSyncManager implements FileSyncManager {

	//Google Drive service
	public Drive service;

	public GoogleDriveFileSyncManager(Drive service) {
		this.service = service;
	}

	@Override
	public void addFile(java.io.File localFile) throws IOException {
		//Insert a file
		File body = new File();
		body.setTitle(localFile.getName());
		FileContent mediaContent = new FileContent("*/*", localFile);
		File file = service.files().insert(body, mediaContent).execute();
		System.out.println("File ID: " + file.getId());
	}

	@Override
	public void updateFile(java.io.File localFile) throws IOException {
		String fileId = getFileId(localFile.getName());
		if (fileId == null) {
			addFile(localFile);
		} else {
			File body = new File();
			body.setTitle(localFile.getName());
			FileContent mediaContent = new FileContent("*/*", localFile);
			File file = service.files().update(fileId, body, mediaContent).execute();
			System.out.println("File ID: " + file.getId());
		}
	}

	@Override
	public void deleteFile(java.io.File localFile) throws IOException {
		String fileId = getFileId(localFile.getName());
		if (fileId == null) {
			throw new FileNotFoundException();
		} else {
			service.files().delete(fileId).execute();
		}
	}

	public String getFileId(String fileName) {
		try {
			List request = service.files().list();
			FileList files = request.execute();
			for(File file : files.getItems()) {
				if (file.getTitle().equals(fileName)) {
					return file.getId();
				}
			}
		} catch (IOException e) {
			System.out.println("An error occurred: " + e);
		}
		return null;
	}

}