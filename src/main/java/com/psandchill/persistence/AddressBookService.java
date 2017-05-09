package com.psandchill.persistence;


import com.psandchill.models.Contact;


import javax.ejb.Singleton;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Singleton
@ApplicationScoped
@ManagedBean(name = "service")
public class AddressBookService implements AddressBookPersistence{
    private Map<Integer, Contact> contacts = new HashMap<>();
    private int currentID = 1;

    public AddressBookService(){
        populateData(20);
    }

    public AddressBookService(int x){
        populateData(x);
    }

    @Override
    public Contact getContact(int id) {
        return null;
    }

    @Override
    public void addContact(Contact contact) {
        contact.setId(currentID ++);
        contacts.put(contact.getId(), contact);
    }

    @Override
    public Collection<Contact> getContacts() {
        return contacts.values();
    }

    @Override
    public void saveContact(Contact createdContact) {
        createdContact.setId(currentID++);
        contacts.put(createdContact.getId(), createdContact);
        for (Contact c :
                contacts.values()) {
            System.out.println(c.getId());
        }
    }

    @Override
    public Collection<Contact> findContacts(String searchTerm) {
        Map<Integer, Contact> foundContacts =
                contacts.entrySet()
                        .stream()
                        .filter(p -> p.getValue().getFirstName().contains(searchTerm) ||
                                p.getValue().getLastName().contains(searchTerm) ||
                                p.getValue().getEmail().contains(searchTerm) ||
                                p.getValue().getCity().contains(searchTerm))

                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return foundContacts.values();
    }

    public void deleteContact(int id){
        contacts.remove(id);
    }

    private void populateData(int x){
        for (int i=0; i<x; i++){
            addContact(new Contact(Integer.toString(i), Integer.toString(i),Integer.toString(i),
                    Integer.toString(i),Integer.toString(i)));
        }
    }
}
