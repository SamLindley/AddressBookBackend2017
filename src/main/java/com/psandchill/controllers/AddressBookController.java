package com.psandchill.controllers;

import com.psandchill.models.Contact;
import com.psandchill.persistence.AddressBookRepoStub;
import com.psandchill.persistence.AddressBookService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


@ManagedBean(name = "controller")
public class AddressBookController {

    private Collection<Contact> contacts;
    private Contact selectedContact = new Contact();
    private int deleteId;
    private Contact createdContact = new Contact();

    @ManagedProperty("#{service}")
    private AddressBookService service;

    public void setService(AddressBookService service){
        this.service = service;
    }

    @PostConstruct
    public void init(){
        contacts = service.getContacts();
    }

    public Collection<Contact> getContacts(){
        return contacts;
    }

    public String createContact(){
        service.addContact(createdContact);
        return "index.xhtml";
    }

    public String deleteContact(){
        service.deleteContact(deleteId);
        return "index.xhtml";
    }

    public Contact getCreatedContact() {
        return createdContact;
    }

    public void setCreatedContact(Contact createdContact) {
        this.createdContact = createdContact;
    }

    public int getDeleteId() {
        return deleteId;
    }

    public void setDeleteId(int deleteId) {
        this.deleteId = deleteId;
    }
}
