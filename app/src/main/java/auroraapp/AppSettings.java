package auroraapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 */
public class AppSettings {

    private Properties properties;
    private final String settingsDirectoryPath = System.getProperty("user.home") + "/auroraapp/settings";
    private File settingsFile;
    private StatusColor notifyAlertLevel;

    /**
     * 
     */
    public AppSettings() {

        this.properties = new Properties();        
        loadSettingsFromFile();

    }

    /**
     * 
     */
    private void createSettingsDirectory() {

        File settingsDirectory = new File(settingsDirectoryPath);

        if (  !settingsDirectory.exists()  ) {

            if (  settingsDirectory.mkdirs()  ) {
                System.out.println("Settings directory created");
            }
            else {
                System.out.println("Settings directory unable to be created");
            }

        }

    }


    /**
     * 
     */
    private void createSettingsFile() {

        settingsFile = new File(settingsDirectoryPath, "settings.prop");

        try {
            
            settingsFile.createNewFile();
            createSettingsProperties();
            saveSettingsToFile();

        } catch (IOException e) {
            System.out.println("Settings file unable to be created");
            e.printStackTrace();
        }
        
    }


    /**
     * 
     */
    public void loadSettingsFromFile() {

        try {

            properties.load(new FileInputStream(settingsDirectoryPath + "/settings.prop"));
            System.out.println(properties.getProperty("notifyAlertLevel").toString());

        } catch (IOException e) {

            System.out.println("Settings file not found, creating a new one...");
            createSettingsDirectory();
            createSettingsFile();

        }

    }


    /**
     * 
     */
    public void saveSettingsToFile() {

        try {

            properties.store(new FileOutputStream(settingsFile.getAbsolutePath()), "Saved settings to file");

        } catch (IOException e) {

            System.out.println("Settings file unable to be saved");
            e.printStackTrace();

        }

    }

    /**
     * 
     */
    public void createSettingsProperties() {

        properties.setProperty("notifyAlertLevel", notifyAlertLevel.toString());

    }

}
