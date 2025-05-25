package com.alerts;

public class OxygenSaturationStrategy implements AlertStrategy{
    @Override
    public Alert checkAlert(String patientId, double value, long timestamp)
    {
        // TODO: research what is abnormal oxygen saturation drop
        if(value<=10 || value>=20)
            return new ECGAlert(patientId, "Abnormal drop in oxygen level: " + value, timestamp);
        return null;
    }
}

