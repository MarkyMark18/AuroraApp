package auroraapp.gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;


public class AuroraGUIPanel extends JPanel {

    public AuroraGUIPanel() {

        setBackground(Color.BLACK);
        JPanel headerPanel = new JPanel();
        headerPanel.setPreferredSize(new Dimension(400, 200));
        add(headerPanel, BorderLayout.NORTH);   
        
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);



    }

}
