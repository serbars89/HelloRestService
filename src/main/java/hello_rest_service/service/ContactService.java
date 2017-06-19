package hello_rest_service.service;

import hello_rest_service.dto.ContactDTO;

import java.util.List;

public interface ContactService {

    List<ContactDTO> findContactsByRegExp(String range);
    List<ContactDTO> findAll();

}
