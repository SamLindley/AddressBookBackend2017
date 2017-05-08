package com.psandchill.persistence;

import com.psandchill.models.Contact;

import java.util.ArrayList;

public interface AddressBookPersistence {
    Contact getContact(int id);

    void postContact(Contact contact);

    ArrayList<Contact> getContacts();
}
