package auroraapp;

import javax.swing.*;
import java.awt.*;

public class StatusNotifier {

    public StatusNotifier() {

    }

    public static void sendNotification(Component parentComponent, String message) {
        JOptionPane.showMessageDialog(parentComponent, message);
    }

}
