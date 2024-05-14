package auroraapp.gui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * 
 */
public class AuroraGUI extends JFrame {

    private TrayIcon trayIcon;

    /**
     * 
     * @param panel
     */
    public AuroraGUI(AuroraGUIPanel panel) {

        setTitle("Aurora Watch");
        ImageIcon windowIcon = new ImageIcon(getClass().getResource("/aw-icon-32.png"));
        setIconImage(windowIcon.getImage());
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        add(panel);
        Dimension windowSize = new Dimension(400, 700);
        setSize(windowSize);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowIconified(WindowEvent e) {
                moveToSystemTray();
            }
            
        });
        
    }


    /**
     * 
     */
    private void moveToSystemTray() {

        // Check if OS has a system tray
        if(  !SystemTray.isSupported()  ) {
            return;
        }

        try {

            SystemTray tray = SystemTray.getSystemTray();

            // Create a system tray popup menu
            PopupMenu popupMenu = new PopupMenu();
            MenuItem exitMenuItem = new MenuItem("Exit");
            exitMenuItem.addActionListener(e -> {
                System.exit(0);
            });
            popupMenu.add(exitMenuItem);

            // Create the icon
            trayIcon = new TrayIcon(new ImageIcon(getClass().getResource("/aw-icon-16.png")).getImage(), "Aurora Watch", popupMenu);

            trayIcon.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(  SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1  ) {
                        setVisible(true);
                        setExtendedState(NORMAL);
                        tray.remove(trayIcon);
                    }
                }
            });

            tray.add(trayIcon);

            setVisible(false);

        } catch (AWTException e) {
            e.printStackTrace();
        }

    }

    /**
     * 
     * @param g
     */
    public void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    }

}
