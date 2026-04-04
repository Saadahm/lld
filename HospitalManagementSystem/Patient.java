package HospitalManagementSystem;

import java.util.UUID;

public class Patient {
    private String id;
    private String disease;

    public PriorityLevel getPriorityLevel() {
        return priorityLevel;
    }

    private PriorityLevel priorityLevel;
    public Patient(String disease)
    {
        this.id= UUID.randomUUID().toString();
        this.disease=disease;
    }

    public void setPriorityLevel(PriorityLevel priorityLevel) {
        this.priorityLevel = priorityLevel;
    }
    public String getId() {
        return id;
    }

}
