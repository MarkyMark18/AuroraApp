package auroraapp;

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
