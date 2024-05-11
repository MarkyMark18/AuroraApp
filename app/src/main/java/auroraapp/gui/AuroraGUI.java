package auroraapp.gui;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;

public class AuroraGUI extends JFrame {

    public AuroraGUI(AuroraGUIPanel panel) {

        setTitle("Aurora Watch");
        setLayout(new BorderLayout());
        add(panel);
        Dimension windowSize = new Dimension(400, 700);
        setSize(windowSize);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
    }

}
