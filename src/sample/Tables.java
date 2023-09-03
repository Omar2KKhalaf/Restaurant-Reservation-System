package sample;

public class Tables {
    private int tableId;
    private int numberOfSeats;
    private boolean reservationTable=false;
    private boolean area;

    public Tables(int tableId, int numberOfSeats, boolean area) {
        this.tableId = tableId;
        this.numberOfSeats = numberOfSeats;
        this.area = area;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public boolean isReservationTable() {
        return reservationTable;
    }

    public void setReservationTable(boolean reservationTable) {
        this.reservationTable = reservationTable;
    }

    public boolean isArea() {
        return area;
    }

    public void setArea(boolean area) {
        this.area = area;
    }






}
