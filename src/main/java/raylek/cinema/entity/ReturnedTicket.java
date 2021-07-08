package raylek.cinema.entity;

public class ReturnedTicket {
    SeatNumber returned_ticket;

    public ReturnedTicket() {
    }

    public ReturnedTicket(SeatNumber returned_ticket) {
        this.returned_ticket = returned_ticket;
    }

    public SeatNumber getReturned_ticket() {
        return returned_ticket;
    }

    public void setReturned_ticket(SeatNumber returned_ticket) {
        this.returned_ticket = returned_ticket;
    }
}
