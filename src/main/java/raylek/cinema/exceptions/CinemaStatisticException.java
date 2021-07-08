package raylek.cinema.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class CinemaStatisticException extends RuntimeException {

    public CinemaStatisticException(String message) {super(message);}

    CinemaStatisticException() {super();}
}
