package com.alerts;

public interface AlertStrategy {
    public Alert checkAlert(String patientId, double value, long timestamp);
}
