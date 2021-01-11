package test.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class TruckNumberException extends RuntimeException {

    public  TruckNumberException() {}
    public TruckNumberException(String s) {
        super(s);
    }

    public TruckNumberException(String s, Throwable cause) {
        super(s, cause);
    }
}
