package auroraapp.gui;

import auroraapp.*;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.*;
import java.awt.event.*;

/**
 * 
 */
public class AuroraGUISettingsPanel extends JPanel {

    private Dimension panelSize = new Dimension(400, 200);
    private AppSettings settings = AppSettings.getInstance();
    StatusColor notifyAlertLevel = settings.getNotifyAlertLevel();
    JRadioButton greenNotifyRadioButton, yellowNotifyRadioButton, amberNotifyRadioButton, redNotifyRadioButton;

    /**
     * 
     */
    public AuroraGUISettingsPanel() {

        setBackground(Color.BLACK);
        setPreferredSize(panelSize);
        setLayout(new BorderLayout());

        // Create the label for the notification setting
        JLabel notifyAlertLevelLabel = new JLabel("Select alert level for notifications:", JLabel.CENTER);
        notifyAlertLevelLabel.setPreferredSize(new Dimension((int) (panelSize.getWidth()), 100));
        notifyAlertLevelLabel.setForeground(Color.WHITE);
        notifyAlertLevelLabel.setAlignmentX(200);
        add(notifyAlertLevelLabel, BorderLayout.NORTH);

        // Create panel for radio buttons
        JPanel radioButtonPanel = new JPanel();
        radioButtonPanel.setLayout(new GridLayout(0, 4));
        radioButtonPanel.setBackground(Color.BLACK);
        
        // Create the radio buttons for the notification setting
        ButtonGroup notifySettingGroup = new ButtonGroup();
        greenNotifyRadioButton = new JRadioButton("Green");
        greenNotifyRadioButton.setForeground(Color.WHITE);
        greenNotifyRadioButton.setBackground(Color.BLACK);
        notifySettingGroup.add(greenNotifyRadioButton);
        yellowNotifyRadioButton = new JRadioButton("Yellow");
        yellowNotifyRadioButton.setForeground(Color.WHITE);
        yellowNotifyRadioButton.setBackground(Color.BLACK);
        notifySettingGroup.add(yellowNotifyRadioButton);
        amberNotifyRadioButton = new JRadioButton("Amber");
        amberNotifyRadioButton.setForeground(Color.WHITE);
        amberNotifyRadioButton.setBackground(Color.BLACK);
        notifySettingGroup.add(amberNotifyRadioButton);
        redNotifyRadioButton = new JRadioButton("Red");
        redNotifyRadioButton.setForeground(Color.WHITE);
        redNotifyRadioButton.setBackground(Color.BLACK);
        notifySettingGroup.add(redNotifyRadioButton);
        radioButtonPanel.add(greenNotifyRadioButton);
        radioButtonPanel.add(yellowNotifyRadioButton);
        radioButtonPanel.add(amberNotifyRadioButton);
        radioButtonPanel.add(redNotifyRadioButton);

        add(radioButtonPanel);

        addListeners();

    }


    /**
     * 
     */
    public void addListeners() {

        greenNotifyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setNotifyAlertLevel(StatusColor.GREEN);
            }
        });

        yellowNotifyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setNotifyAlertLevel(StatusColor.YELLOW);
            }
        });

        amberNotifyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setNotifyAlertLevel(StatusColor.AMBER);                
            }
        });

        redNotifyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setNotifyAlertLevel(StatusColor.RED);
            }
        });

    }

}
