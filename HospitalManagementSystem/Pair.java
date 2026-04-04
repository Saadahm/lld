package HospitalManagementSystem;

public class Pair {
    private int val;
    private String id;
    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Pair(int val, String id){
        this.id=id;
        this.val=val;
    }
}
