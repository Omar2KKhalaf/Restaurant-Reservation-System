package sample;

import java.util.ArrayList;

public class Client extends  Users{
    private double totalPrice;
    private int tableId;
    private ArrayList<String> dishesClient=new ArrayList<>();



    public Client(String s,String y,String x) {
        super.setName(s);
        super.setPasswordname(y);
        super.setUsername(x);
        super.setRole("Client");
    }
    public Client(){

    }
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }


    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }
    public ArrayList<String> getDishesClient() {
        return dishesClient;
    }

    public void setDishesClient(ArrayList<String> x) {
        dishesClient= x;
    }

}
