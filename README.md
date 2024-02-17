Requirements
JDK 17 or later: Ensure that you have Java Development Kit (JDK) version 17 or later installed on your system. You can download it from here.

Latest SceneBuilder: The project uses JavaFX for the user interface. You will need the latest version of SceneBuilder to design and edit the user interface. You can download SceneBuilder from here.

OpenJFX SDK: Download OpenJFX SDK from here and extract it.

Setup Steps
If you encounter any issues or errors while setting up or running the project, follow these steps:

Check JDK Configuration: Ensure that your IDE is configured to use JDK 17. You may need to update the JDK configuration in your IDE settings.

Download Latest SceneBuilder: Make sure you have the latest version of SceneBuilder installed. Sometimes compatibility issues arise with older versions.

Modify Run Configuration:

Open the run configuration in your IDE by navigating to Run > Edit Configurations.
In the Modify options section in the Build and Run section on the top right, add VM options.
Add the path to the lib folder from the extracted OpenJFX SDK. This is necessary for JavaFX to run properly.
Use Provided Settings (Optional):

If you're still experiencing issues, you can use the provided settings file to configure your IDE:
Step 1: Export your current IDE settings by navigating to File > Manage IDE Settings > Export Settings.
Step 2: Import the provided settings file by navigating to File > Manage IDE Settings > Import Settings.
Remember to always ensure compatibility with the latest versions of JDK, SceneBuilder, and any other dependencies to avoid potential issues.
