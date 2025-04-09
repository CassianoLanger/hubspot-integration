package com.cassiano.hubspot.integration.controller;

import com.cassiano.hubspot.integration.controller.response.ContactsResponse;
import com.cassiano.hubspot.integration.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/contacts")
public class ContactController {

    private ContactService contacService;

    public ContactController(ContactService contacService) {
        this.contacService = contacService;
    }

    @GetMapping("")
    public ResponseEntity< List<ContactsResponse>> createContact(){

        List<ContactsResponse> contactsResponse = contacService.getAllContacts();
        return ResponseEntity.ok(contactsResponse);
    }
}
