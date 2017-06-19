package hello_rest_service.util_logic;

import hello_rest_service.dto.ContactDTO;
import hello_rest_service.model.Contact;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

public class Transformer {

    public static List<ContactDTO> transformContactToContactDTO(List<Contact> contactList) {

        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();

        List contactDTOList = new ArrayList(
                contactList.size());
        for (Contact contact : contactList) {
            contactDTOList.add(mapper.map(contact, ContactDTO.class));
        }

        return contactDTOList;

    }

    public static List<Contact> transformContactDtotoContact(List<ContactDTO> contactDTOList) {

        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();

        List contactList = new ArrayList(
                contactDTOList.size());
        for (ContactDTO contactDTO : contactDTOList) {
            contactList.add(mapper.map(contactDTO, Contact.class));
        }

        return contactList;

    }

}
