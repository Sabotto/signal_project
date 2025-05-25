package com.alerts;

public class PriorityAlertDecorator extends AlertDecorator {
    private final String priorityLevel;

    public PriorityAlertDecorator(Alert alert, String priorityLevel) {
        super(alert);
        this.priorityLevel = priorityLevel;
    }

    public String getPriorityLevel() {
        return priorityLevel;
    }

    //No need to add any more methods, the class itself gives priority that can be checked and used outside the method
    @Override
    public String getCondition() {
        return super.getCondition() + ", contidion priority: " + priorityLevel;
    }
}