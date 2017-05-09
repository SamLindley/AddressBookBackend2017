package com.psandchill.persistence;

import com.psandchill.models.Contact;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.Collection;

@ManagedBean(name = "addressRepo", eager = true)
@ApplicationScoped
public class AddressBookRepoStub implements AddressBookPersistence {




    @Override
    public Contact getContact(int id){
        return null;
    }

    @Override
    public void addContact(Contact contact){

    }

    @Override
    public ArrayList<Contact> getContacts(){
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("sam", "sam", "sam", "sam", "sam"));
        contacts.add(new Contact("sam", "sam", "sam", "2", "2"));

        return contacts;
    }

    @Override
    public void saveContact(Contact createdContact) {
        System.out.println(createdContact.getFirstName());
    }

    @Override
    public Collection<Contact> findContacts(String searchTerm) {
        return null;
    }
}
