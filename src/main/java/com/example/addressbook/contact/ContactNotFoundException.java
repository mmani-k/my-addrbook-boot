package com.example.addressbook.contact;

class ContactNotFoundException extends RuntimeException {

    ContactNotFoundException(long id) {
        super("Contact " + id + " was not found");
    }
}

