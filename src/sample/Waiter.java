package sample;

public class Waiter extends Users{
    public Waiter(String s,String y,String x) {
        super.setName(s);
        super.setUsername(x);
        super.setRole("Waiter");
        super.setPasswordname(y);
    }
}
