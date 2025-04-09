package com.cassiano.hubspot.integration.controller;

import com.cassiano.hubspot.integration.controller.response.ContactsResponse;
import com.cassiano.hubspot.integration.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contacService;

    @GetMapping("")
    public ResponseEntity< List<ContactsResponse>> getAllContact(@RequestHeader("Authorization") String authorization){

        List<ContactsResponse> contactsResponse = contacService.getAllContacts(authorization);
        return ResponseEntity.ok(contactsResponse);
    }

    @PostMapping//add requestBody
    public ResponseEntity< List<ContactsResponse>> createContact(@RequestHeader("Authorization") String authorization){

        List<ContactsResponse> contactsResponse = contacService.getAllContacts(authorization);
        return ResponseEntity.ok(contactsResponse);
    }
}
