package hello_rest_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Error regular expression")
public class ErrorRegExpException extends Exception {

    public ErrorRegExpException(String message) {
        super(message);
    }

}