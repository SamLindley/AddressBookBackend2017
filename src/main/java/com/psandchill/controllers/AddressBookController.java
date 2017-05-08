package com.psandchill.controllers;

import com.psandchill.models.Contact;
import com.psandchill.persistence.AddressBookPersistence;
import com.psandchill.persistence.AddressBookRepoStub;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.List;


@ManagedBean(name = "controller")
public class AddressBookController {

    private List<Contact> contacts;
    private Contact selectedContact;

    @ManagedProperty("#{addressRepo}")
    private AddressBookRepoStub repo;

    public void setRepo(AddressBookRepoStub repo){
        this.repo = repo;
    }

    @PostConstruct
    public void init(){
        contacts = repo.getContacts();
    }

    public List<Contact> getContacts(){
        return contacts;
    }
}
