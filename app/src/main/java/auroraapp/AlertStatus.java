package auroraapp;

import java.awt.*;
import java.time.LocalDateTime;

/**
 * 
 */
public class AlertStatus {

    private LocalDateTime statusDateTime;
    private StatusColor statusColor;
    private static AlertStatus alertStatus;

    /**
     * 
     */
    private AlertStatus() {

    }

    /**
     *
     */
    public static void compareStatus(StatusColor setting, StatusColor status, Component parentComponent) {

        int settingAsInt = StatusColor.statusAsInt(setting);
        int statusAsInt = StatusColor.statusAsInt(status);

        if (  statusAsInt >= settingAsInt  ) {
            String message = "ALERT! Status is currently " + status;
            StatusNotifier.sendNotification(parentComponent, message);
        }

    }


    /**
     * 
     * @return
     */
    public static AlertStatus getInstance() {
        
        if (  alertStatus == null  ) {
            alertStatus = new AlertStatus();
            alertStatus = StatusParser.retrieveCurrentStatus();
        }

        return alertStatus;
    }

    /**
     * 
     */
    public LocalDateTime getAlertDateTime() {
        return alertStatus.statusDateTime;
    }


    /**
     * 
     */
    public StatusColor getAlertStatus() {
        return alertStatus.statusColor;
    }


    /**
     * 
     * @param status
     */
    public void setAlertDateTime(LocalDateTime status) {
        alertStatus.statusDateTime = status;
    }


    /**
     * 
     * @param status
     */
    public void setAlertStatus(StatusColor status) {
        alertStatus.statusColor = status;
    }

}
