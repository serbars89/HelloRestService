package hello_rest_service.dao;

import hello_rest_service.model.Contact;

import java.util.List;

public interface ContactDao {

    List<Contact> findAll();

}
