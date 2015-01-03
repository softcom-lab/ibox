package edu.csupomona.cs585.ibox;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import edu.csupomona.cs585.ibox.sync.FileSyncManager;
import edu.csupomona.cs585.ibox.sync.GoogleDriveFileSyncManager;
import edu.csupomona.cs585.ibox.sync.GoogleDriveServiceProvider;

/**
 * App entry
 *
 */
public class App {

    static void usage() {
        System.err.println("usage: java WatchDir dir");
        System.exit(-1);
    }

    public static void main(String[] args) throws IOException {
        // parse arguments
        if (args.length < 1) {
            usage();
        }

        // get file sync manager
        FileSyncManager fileSyncManager = new GoogleDriveFileSyncManager(
        		GoogleDriveServiceProvider.get().getGoogleDriveClient());

        // register directory and process its events
        Path dir = Paths.get(args[0]);
        new WatchDir(dir, fileSyncManager).processEvents();
    }
}
