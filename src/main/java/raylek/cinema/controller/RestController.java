package raylek.cinema.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import raylek.cinema.entity.*;
import raylek.cinema.exceptions.CinemaStatisticException;
import raylek.cinema.exceptions.TicketPurchasedException;

import java.util.ArrayList;
import java.util.UUID;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    Cinema seats = new Cinema(9, 9);
    ArrayList<PurchasedTicket> purchasedTickets = new ArrayList<>();
    Statistic statistic = new Statistic();

//    return list of free seats
    @GetMapping("/seats")
    public Cinema getSeats() {
        return seats;
    }

//    purchase of a ticket with the specified seat
    @PostMapping("/purchase")
    public PurchasedTicket bookSeat(@RequestBody SeatNumber requestedSeat) {

        if(requestedSeat.getRow() > 9 || requestedSeat.getRow() < 1){
            throw new TicketPurchasedException("The number of a row or a column is out of bounds!");
        }else if(requestedSeat.getColumn() > 9 || requestedSeat.getColumn() < 1){
            throw new TicketPurchasedException("The number of a row or a column is out of bounds!");
        }else if(seats.getAvailable_seats().contains(requestedSeat)) {
            int index = seats.getAvailable_seats().indexOf(requestedSeat);
            ArrayList<SeatNumber> midSeat = seats.getAvailable_seats();
            PurchasedTicket purchasedTicket = new PurchasedTicket(UUID.randomUUID().toString(), midSeat.get(index));
            purchasedTickets.add(purchasedTicket);
            statistic.ticketSold(midSeat.get(index));
            midSeat.remove(index);
            seats.setAvailable_seats(midSeat);
            return purchasedTicket;
        } else {
            throw new TicketPurchasedException("The ticket has been already purchased!");
        }
    }

//    return ticket with specified token from purchasing
    @PostMapping("/return")
    public ReturnedTicket returnTicket(@RequestBody PurchasedTicket purchasedTicket) {

        if(purchasedTickets.contains(purchasedTicket)) {
            int index = purchasedTickets.indexOf(purchasedTicket);
            SeatNumber seatNumber = purchasedTickets.get(index).getTicket();
            purchasedTickets.remove(index);
            ArrayList<SeatNumber> midSeat = seats.getAvailable_seats();
            midSeat.add(seatNumber);
            statistic.ticketReturned(seatNumber);
            seats.setAvailable_seats(midSeat);
            return new ReturnedTicket(seatNumber);
        } else
            throw new TicketPurchasedException("Wrong token!");
    }


//    return statistic
    @PostMapping("/stats")
    public Statistic statistic(@RequestParam(required = false) String password) {

        if(password == null) {
            throw new CinemaStatisticException("The password is wrong!");
        }else if(password.equals("super_secret")) {
            return statistic;
        } else {
            throw new TicketPurchasedException("The password is wrong!");
        }
    }
}
