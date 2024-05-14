package auroraapp;


/**
 * 
 */
public class AlertStatus {

    private StatusColor currentStatus;
    private static final AlertStatus alertStatus = new AlertStatus();

    /**
     * 
     */
    public AlertStatus() {

        currentStatus = StatusParser.getCurrentStatusColor();

    }

    /**
     * 
     * @return
     */
    public static AlertStatus getInstance() {
        return alertStatus;
    }


    /**
     * 
     */
    public StatusColor getAlertStatus() {
        return currentStatus;
    }

    /**
     * 
     * @param status
     */
    public void setAlertStatus(StatusColor status) {
        currentStatus = status;
    }

    /**
     * 
     */
    public void updateStatusColor() {
        setAlertStatus(StatusParser.getCurrentStatusColor());
    }

}
