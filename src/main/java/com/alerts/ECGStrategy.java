package com.alerts;

public class ECGStrategy implements AlertStrategy{
    @Override
    public Alert checkAlert(String patientId, double value, long timestamp)
    {
        // TODO: research what is ECG
        if(value<=10 || value>=20)
            return new BloodOxygenAlert(patientId, "Abnormal ECG level: " + value, timestamp);
        return null;
    }
}

