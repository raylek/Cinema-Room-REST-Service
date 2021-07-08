package raylek.cinema.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TicketPurchasedException extends RuntimeException{


    public TicketPurchasedException(String message) {
        super(message);
    }


    TicketPurchasedException() {super();}

}
