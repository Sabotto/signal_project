package com.alerts;

public class ECGAlert implements Alert{
    private final String patientId;
    private final String condition;
    private final long timestamp;

    public ECGAlert(String patientId, String condition, long timestamp) {
        this.patientId = patientId;
        this.condition = condition;
        this.timestamp = timestamp;
    }

    @Override
    public String getPatientId() {
        return patientId;
    }

    @Override
    public String getCondition() {
        return condition;
    }

    @Override
    public long getTimestamp() {
        return timestamp;
    }
}
