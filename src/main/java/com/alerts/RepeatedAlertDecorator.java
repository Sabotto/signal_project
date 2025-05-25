package com.alerts;

public class RepeatedAlertDecorator extends AlertDecorator{
    private final int repeatTime;
    private final String patientId;
    private final String condition;
    private final long timestamp;

    public RepeatedAlertDecorator(Alert alert, int repeatTime, String patientId, String condition, long timestamp) {
        super(alert);
        this.repeatTime = repeatTime;
        this.patientId = patientId;
        this.condition = condition;
        this.timestamp = timestamp;
    }

    public int getRepeatTime() {
        return repeatTime;
    }

    @Override
    public String getCondition() {
        return super.getCondition() + ", Rechecking time: " + repeatTime;
    }

    public Alert recheck()
    {
        // Rechecks alert conditions infinitely every specified interval of time.
        // TODO: make cases of whichever type of alert user wants to get rechecked then the conditions change to this specific alert conditions.
        while(true)
        {
            double value = Double.parseDouble(condition);
            OxygenSaturationStrategy strategy = new OxygenSaturationStrategy();
            Alert checkedAlert = strategy.checkAlert(patientId, value, timestamp);

            if(checkedAlert != null)
                return checkedAlert;

            try {
                Thread.sleep(repeatTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        return null;
    }
}
