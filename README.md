Overview
--------

A simple version of the Google Drive client written in Java.

It applies the Google Drive Java API (https://developers.google.com/drive/v3/web/quickstart/java).

Environment Setup
-----------------

1. Install the Eclipse 4+ (`http://www.eclipse.org/`), and make sure Maven plugin is available.
2. (Optional) The Maven plugin is not availble in your Eclipse, install it using the update site (`http://www.eclipse.org/m2e/download/`).
3. Install the latest Maven command-line tool (`http://maven.apache.org/download.cgi`)

Importing the Project into Eclipse
----------------------------------------

1. File->Import->Maven->Existing Maven Projects
2. Select the directory containing the pom.xml file
3. Finish

Building the Project for the First Time
----------------------------------------
1. Right-click on the project root folder->Maven->Update Project

Configure Google Drive API Credential
----------------------------------------

1. Please follow the instructions to setup the Google account credential at: `https://developers.google.com/drive/v3/web/quickstart/java#step_1_turn_on_the_api_name`
2. When creating the Client ID, choose: "OAuth Create new Client Id" -> "Installed application" (Other)
3. Copy and paste the CLIENT ID and CLIENT SECRET in `GoogleDriveServiceProvider.java`

Running the Project Locally
----------------------------------------
1. Locate the App.java in src/main/java source folder and right-click on it->Run As->Run Configurations, and fill a folder name in Program Parameters, such as "/mydrive/" or "C:\doc\".
2. When the program is running, you can copy/modify/delete files in that folder and check if the changes have been synced to your Google Drive account.

Note
----------------------------------------
1. In order to simplify the function, all the files will be sync-ed to the root folder in your Google Drive.
2. Only the first-level files will be monitored in your local folder. Sub-directories will not be monitored.
3. The project has been configured to use JDK 7. If you use other versions installed, please modify the pom.xml file. However, JDK 7+ (or 8) is recommended.

Resources
----------------------------------------
To learn the core techniques used in this program, please read:

1. Watching a Directory for Changes. http://docs.oracle.com/javase/tutorial/essential/io/notification.html
2. Quickstart: Run a Drive App in Java. https://developers.google.com/drive/web/quickstart/quickstart-java
