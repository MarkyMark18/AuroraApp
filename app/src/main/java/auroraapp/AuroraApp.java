package auroraapp;

import auroraapp.gui.AuroraGUI;
import auroraapp.gui.AuroraGUIPanel;

public class AuroraApp {

    public void startGUI() {

        AuroraGUIPanel auroraGUIPanel = new AuroraGUIPanel();
        AuroraGUI auroraGUI = new AuroraGUI(auroraGUIPanel);
        auroraGUI.setVisible(true);

    }

    public static void main(String[] args) {
        
        AuroraApp auroraApp = new AuroraApp();
        AppSettings.getInstance();
        AlertStatus.getInstance();
        auroraApp.startGUI();

    }
}
