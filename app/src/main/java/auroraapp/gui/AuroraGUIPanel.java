package auroraapp.gui;

import javax.swing.*;
import java.awt.*;


public class AuroraGUIPanel extends JPanel {

    public AuroraGUIPanel() {

        setPreferredSize(new Dimension(400, 700));
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        // Create the header panel and add the title image
        JPanel headerPanel = new JPanel();
        headerPanel.setPreferredSize(new Dimension(400, 200));
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/AuroraWatchTitle.jpg"));
        JLabel heading = new JLabel(imageIcon);
        headerPanel.add(heading);
        add(headerPanel, BorderLayout.NORTH);

        JPanel footerPanel = new JPanel();
        footerPanel.setPreferredSize(new Dimension(400, 50));
        footerPanel.setBackground(Color.BLACK);
        JLabel footerText = new JLabel("\u00A9 Mark Harrison 2024");
        footerText.setForeground(Color.WHITE);
        footerText.setBackground(Color.BLACK);
        footerPanel.add(footerText);
        add(footerPanel, BorderLayout.SOUTH);
        
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);



    }

}
