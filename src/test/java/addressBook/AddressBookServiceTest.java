package addressBook;

import com.psandchill.models.Contact;
import com.psandchill.persistence.AddressBookService;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class AddressBookServiceTest {
    private AddressBookService service;

    @Before
    public void init(){
        service = new AddressBookService(0);
    }

    @Test
    public void getContactsInitialState(){
        assert(service.getContacts().isEmpty());
    }

    @Test
    public void findContacts(){
        service.addContact(new Contact("1", "1", "1", "1", "1"));
        service.addContact(new Contact("2", "2", "2", "2", "2"));
        Collection<Contact> test = service.findContacts("me");
        assert test.size() == 0;
        test = service.findContacts("1");
        assert test.size() == 1;
    }
}
