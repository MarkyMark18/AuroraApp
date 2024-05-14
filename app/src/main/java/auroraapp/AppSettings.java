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
    private static final AppSettings instance = new AppSettings();

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
    public static AppSettings getInstance() {
        return instance;
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
    private void createSettingsProperties() {

        // Defaults to RED when program is first run or settings file has been deleted
        setNotifyAlertLevel(StatusColor.RED);

    }


    /**
     * 
     */
    private void loadSettingsFromFile() {

        try {

            properties.load(new FileInputStream(settingsDirectoryPath + "/settings.prop"));

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
    public StatusColor getNotifyAlertLevel() {

        return StatusColor.valueOf(properties.getProperty("notifyAlertLevel"));

    }


    /**
     * 
     */
    public void setNotifyAlertLevel(StatusColor color) {

        System.out.println("Setting alert notification level to: " + color.name());
        properties.setProperty("notifyAlertLevel", color.name());

    }

}
