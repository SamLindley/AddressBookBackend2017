package addressBook;

import com.psandchill.persistence.AddressBookService;
import org.junit.Before;
import org.junit.Test;

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
}
