package hello_rest_service.service;

import hello_rest_service.dao.ContactDao;
import hello_rest_service.dto.ContactDTO;
import hello_rest_service.model.Contact;
import hello_rest_service.util_logic.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactDao contactDao;

    public ContactServiceImpl() {
    }

    @Override
    public List<ContactDTO> findContactsByRegExp(String range) {

        List<Contact> contactList = contactDao.findAll();

        List<ContactDTO> contactsDTOList = Transformer.transformContactToContactDTO(contactList);

        return filterListByRegExp(contactsDTOList, range);

    }

    @Override
    public List<ContactDTO> findAll() {

        List<Contact> contactList = contactDao.findAll();

        return Transformer.transformContactToContactDTO(contactList);

    }

    private List<ContactDTO> filterListByRegExp(List<ContactDTO> list, String regex) {

        return list.parallelStream().filter(s ->
                !s.getName().matches(regex)).collect(Collectors.toList());

    }

}
