package com.crm.crm.model;

import java.util.Collection;

import javax.validation.Valid;
import javax.xml.crypto.URIReferenceException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactsController {

    private ContactRepo contactRepo;

    public ContactsController(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    @GetMapping("/contacts")
    Collection<Contact> contacts() {
        return (Collection<Contact>) contactRepo.findAll();

    }

    @PostMapping("/contacts")
    ResponseEntity<Contact> createContact(@Valid @RequestBody Contact contact) throws URIReferenceException {
        Contact result = contactRepo.save(contact);
        return ResponseEntity.ok().body(result);
    }
}
