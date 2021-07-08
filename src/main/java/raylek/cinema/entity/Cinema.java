package raylek.cinema.entity;

import java.util.ArrayList;

public class Cinema {

    private int total_rows;
    private int total_columns;
    private ArrayList<SeatNumber> available_seats;



    public Cinema() {}

    public Cinema(int total_rows, int total_columns) {
        this.total_rows = total_rows;
        this.total_columns = total_columns;
        this.available_seats = new ArrayList<>();

        for(int i = 0; i < total_rows; i++) {
            for (int j = 0; j < total_columns; j++) {
                this.available_seats.add(new SeatNumber(i+1, j+1));
            }
        }
    }

    public int getTotal_rows() {
        return total_rows;
    }

    public void setTotal_rows(int total_rows) {
        this.total_rows = total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public void setTotal_columns(int total_columns) {
        this.total_columns = total_columns;
    }

    public ArrayList<SeatNumber> getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(ArrayList<SeatNumber> available_seats) {
        this.available_seats = available_seats;
    }
}
