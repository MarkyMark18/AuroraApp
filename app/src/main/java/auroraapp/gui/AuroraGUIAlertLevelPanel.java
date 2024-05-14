package auroraapp.gui;

import javax.swing.*;

import auroraapp.AlertStatus;

import java.awt.*;

/**
 * 
 */
public class AuroraGUIAlertLevelPanel extends JPanel {

    private Dimension panelSize = new Dimension(400, 250);
    private AlertStatus currentStatus;

    public AuroraGUIAlertLevelPanel() {

        setBackground(Color.BLACK);
        setPreferredSize(panelSize);
        setLayout(new GridLayout(4,0));

        currentStatus = AlertStatus.getInstance();

        JLabel colorHeading = new JLabel("The current status color is:", JLabel.CENTER);
        colorHeading.setForeground(Color.WHITE);
        JLabel dateTimeHeading = new JLabel("at:", JLabel.CENTER);
        dateTimeHeading.setForeground(Color.WHITE);
        JLabel statusColor = new JLabel(currentStatus.getAlertStatus().toString(), JLabel.CENTER);
        statusColor.setForeground(Color.WHITE);
        JLabel statusDateTime = new JLabel(currentStatus.getAlertDateTime().toString(), JLabel.CENTER);
        statusDateTime.setForeground(Color.WHITE);
        add(colorHeading);
        add(statusColor);
        add(dateTimeHeading);
        add(statusDateTime);


    }

}
