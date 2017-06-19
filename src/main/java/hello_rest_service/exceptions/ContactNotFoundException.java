package hello_rest_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NO_CONTENT, reason="Contacts Not Found")
public class ContactNotFoundException extends Exception{

    public ContactNotFoundException(String message) {
        super(message);
    }
}
