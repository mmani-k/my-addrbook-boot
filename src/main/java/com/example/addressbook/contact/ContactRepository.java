package com.example.addressbook.contact;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrderByLastNameAscFirstNameAsc(
            String firstName, String lastName, String email);

    List<Contact> findAllByOrderByLastNameAscFirstNameAsc();
}

