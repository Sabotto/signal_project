package com.alerts;

public abstract class AlertDecorator implements Alert{
    protected final Alert wrappedAlert;

    public AlertDecorator(Alert alert) {
        this.wrappedAlert = alert;
    }

    @Override
    public String getPatientId() {
        return wrappedAlert.getPatientId();
    }

    @Override
    public String getCondition() {
        return wrappedAlert.getCondition();
    }

    @Override
    public long getTimestamp() {
        return wrappedAlert.getTimestamp();
    }
}
