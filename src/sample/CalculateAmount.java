package sample;

public class CalculateAmount {
    private static double totalDay;
    private double totalMainCourse;
    private double totalAppetizers;
    private double totalDesert;
    public static double getTotalDay() {
        return totalDay;
    }

    public static void setTotalDay(double totalDay) {
        CalculateAmount.totalDay += totalDay;
    }



    public double getTotalMainCourse() {
        return totalMainCourse*1.15;
    }

    public void setTotalMainCourse(int totalMainCourse) {
        this.totalMainCourse+= totalMainCourse;
    }

    public double getTotalAppetizers() {
        return totalAppetizers*1.10;
    }

    public void setTotalAppetizers(int totalAppetizers) {
        this.totalAppetizers += totalAppetizers;
    }

    public double getTotalDesert() {
        return totalDesert*1.20;
    }

    public void setTotalDesert(int totalDesert) {
        this.totalDesert += totalDesert;
    }
    public double getTotal(){
        return totalMainCourse+totalAppetizers+totalDesert;
    }



}
