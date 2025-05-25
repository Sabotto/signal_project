package com.alerts;

public class BloodPressureStrategy implements AlertStrategy{
    @Override
    public Alert checkAlert(String patientId, double value, long timestamp)
    {
        if(value<=70 || value>=120)
            return new BloodPressureAlert(patientId, "Abnormal blood pressure: " + value, timestamp);
        return null;
    }
}
