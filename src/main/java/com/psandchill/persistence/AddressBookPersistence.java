package com.psandchill.persistence;

import com.psandchill.models.Contact;

import java.util.ArrayList;
import java.util.Collection;

public interface AddressBookPersistence {
    Contact getContact(int id);

    void addContact(Contact contact);

    Collection<Contact> getContacts();

    void saveContact(Contact createdContact);

    Collection<Contact> findContacts(String searchTerm);
}
