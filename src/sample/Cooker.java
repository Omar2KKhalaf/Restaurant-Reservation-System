package sample;

public class Cooker extends Users{
    public Cooker(String s,String y,String x) {
        super.setName(s);
        super.setUsername(x);
        super.setRole("Cooker");
        super.setPasswordname(y);
    }
}
