package com.example.addressbook.contact;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
class ContactService {

    private final ContactRepository repository;

    ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    List<Contact> findAll(String search) {
        if (search == null || search.isBlank()) {
            return repository.findAllByOrderByLastNameAscFirstNameAsc();
        }
        String query = search.trim();
        return repository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrderByLastNameAscFirstNameAsc(
                query, query, query);
    }

    Contact findById(long id) {
        return repository.findById(id).orElseThrow(() -> new ContactNotFoundException(id));
    }

    @Transactional
    Contact create(ContactRequest request) {
        return repository.save(new Contact(
                request.firstName(), request.lastName(), request.email(), request.phone()));
    }

    @Transactional
    Contact update(long id, ContactRequest request) {
        Contact contact = findById(id);
        contact.update(request.firstName(), request.lastName(), request.email(), request.phone());
        return contact;
    }

    @Transactional
    void delete(long id) {
        repository.delete(findById(id));
    }
}

