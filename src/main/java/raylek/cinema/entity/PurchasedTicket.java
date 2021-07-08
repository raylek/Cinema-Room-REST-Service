package raylek.cinema.entity;


import java.util.Objects;

public class PurchasedTicket {

    private String token;
    private SeatNumber ticket;

    public PurchasedTicket() {
    }

    public PurchasedTicket(String token) {
        this.token = token;
    }

    public PurchasedTicket(String token, SeatNumber ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public SeatNumber getTicket() {
        return ticket;
    }

    public void setTicket(SeatNumber ticket) {
        this.ticket = ticket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchasedTicket that = (PurchasedTicket) o;
        return Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }
}
