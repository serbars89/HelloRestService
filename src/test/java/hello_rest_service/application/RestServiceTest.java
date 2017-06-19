package hello_rest_service.application;

import hello_rest_service.dto.ContactDTO;
import hello_rest_service.service.ContactServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class RestServiceTest extends MainControllerTest {

    @Autowired
    private ContactServiceImpl contactService;


    @Test
    public void testGetContactsBySqlRestrictionNotContain() {

        List<ContactDTO> contactList = contactService.findContactsByRegExp("^A.$");
        Assert.assertFalse(contactList.contains("Alexandra"));

    }

    @Test
    public void testGetContactsByRegExNotContain() {

        List<ContactDTO> contactList = contactService.findContactsByRegExp("^A.$");
        Assert.assertFalse(contactList.contains("Alexandra"));

    }

    @Test
    public void testGetContactsBySqlRestrictionContain() {

        List<ContactDTO> contactList = contactService.findContactsByRegExp("A.$");
        Assert.assertFalse(contactList.contains("Alexandra"));

    }

    @Test
    public void testGetContactsByRegExContain() {

        List<ContactDTO> contactList = contactService.findContactsByRegExp("^.*[aeio].*$");
        Assert.assertFalse(contactList.contains("Dolf"));

    }

}
