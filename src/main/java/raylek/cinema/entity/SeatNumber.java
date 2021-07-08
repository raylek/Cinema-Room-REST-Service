package raylek.cinema.entity;




import java.util.Objects;


public class SeatNumber {

    private int row;
    private int column;
    private int price;

    public SeatNumber(int row, int column) {
        this.row = row;
        this.column = column;
        if(row < 5) {
            this.price = 10;
        } else {
            this.price = 8;
        }
    }

    public SeatNumber() {}

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeatNumber that = (SeatNumber) o;
        return row == that.row && column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
