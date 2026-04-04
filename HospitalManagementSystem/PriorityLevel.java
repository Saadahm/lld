package HospitalManagementSystem;

public enum PriorityLevel {
    Low(0), High(2), Medium(1), Critical(3);
    private final int val;
    PriorityLevel(int val)
    {
        this.val=val;
    }

    public int getVal() {
        return val;
    }
}
