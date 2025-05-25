package com.alerts;

public class BloodOxygenStrategy implements AlertStrategy{
    @Override
    public Alert checkAlert(String patientId, double value, long timestamp)
    {
        // TODO: research which oxygen levels are abnormal
        if(value<=10 || value>=20)
            return new BloodOxygenAlert(patientId, "Abnormal oxygen level in blood: " + value, timestamp);
        return null;
    }
}

