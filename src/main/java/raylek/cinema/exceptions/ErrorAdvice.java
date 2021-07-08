package raylek.cinema.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler(TicketPurchasedException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Error handleException(TicketPurchasedException e) {
        Error error = new Error();
        error.setError(e.getMessage());
        return error;
    }

    @ExceptionHandler(CinemaStatisticException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public Error handleException(CinemaStatisticException e) {
        Error error = new Error();
        error.setError(e.getMessage());
        return error;
    }


}
