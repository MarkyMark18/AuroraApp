package auroraapp.gui;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;

public class AuroraGUI extends JFrame {

    public AuroraGUI(AuroraGUIPanel panel) {

        setTitle("Aurora Watch");
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        add(panel);
        Dimension windowSize = new Dimension(400, 700);
        setSize(windowSize);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
    }

    public void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    }

}
