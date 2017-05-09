package com.psandchill.controllers;

import com.psandchill.models.Contact;
import com.psandchill.persistence.AddressBookRepoStub;
import com.psandchill.persistence.AddressBookService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.*;


@ManagedBean(name = "controller")
public class AddressBookController {

    private Collection<Contact> contacts;
    private Contact selectedContact = new Contact();
    private int deleteId;
    private Contact createdContact = new Contact();
    private String searchTerm;
    private Collection<Contact> filteredContacts;
    
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

    public void createContact(){
        service.addContact(createdContact);
        //return "index.xhtml";
    }

    public void deleteContact(){
        service.deleteContact(deleteId);
        contacts = service.getContacts();
        //return "index.xhtml";
    }
    
    public void findContact(){
        filteredContacts = service.findContacts(searchTerm);

        //return "results.xhtml";
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

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public Collection<Contact> getFilteredContacts() {
        return filteredContacts;
    }

    public void setFilteredContacts(Collection<Contact> filteredContacts) {
        this.filteredContacts = filteredContacts;
    }
}
