package com.example.addressbook.contact;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contacts")
class ContactController {

    private final ContactService service;

    ContactController(ContactService service) {
        this.service = service;
    }

    @GetMapping
    List<Contact> findAll(@RequestParam(required = false) String search) {
        return service.findAll(search);
    }

    @GetMapping("/{id}")
    Contact findById(@PathVariable long id) {
        return service.findById(id);
    }

    @PostMapping
    ResponseEntity<Contact> create(@Valid @RequestBody ContactRequest request) {
        Contact contact = service.create(request);
        return ResponseEntity.created(URI.create("/api/contacts/" + contact.getId())).body(contact);
    }

    @PutMapping("/{id}")
    Contact update(@PathVariable long id, @Valid @RequestBody ContactRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

