package sample;

public class Manager extends Users {
    public Manager(String s,String y,String x) {
        super.setName(s);
        super.setUsername(x);
        super.setRole("Manager");
        super.setPasswordname(y);
    }
}
