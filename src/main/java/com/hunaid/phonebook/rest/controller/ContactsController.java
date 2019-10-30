package com.hunaid.phonebook.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hunaid.phonebook.data.modal.Contact;
import com.hunaid.phonebook.data.modal.Phonebook;
import com.hunaid.phonebook.service.ContactService;
import com.hunaid.phonebook.service.PhoneBookService;

@RestController()
public class ContactsController {

	@Autowired
	private ContactService contactService;

	@Autowired
	private PhoneBookService phoneBookService;

	@GetMapping("/phonebooks/{phonebookId}/contacts")
	public List<Contact> getAllContactsByPhoneBookId(@PathVariable(value = "phonebookId") Long phonebookId) {
		return contactService.list(phonebookId);
	}

	@PostMapping("/phonebooks/{phonebookId}/contacts")
	public Contact createContact(@PathVariable(value = "phonebookId") Long phonebookId,
			@Valid @RequestBody Contact contact) {
		System.out.println("Phone book id : " + phonebookId);
		Phonebook phonebook = phoneBookService.findById(phonebookId);
		System.out.println("Phone book found : " + phonebook.getName());
		contact.setPhonebook(phonebook);
		
		System.out.println("Contact: " + contact.getId() + " : " + contact.getName());
		
		return contactService.save(contact);

	}

	@GetMapping("/phonebooks/{phonebookId}/contacts/{name}")
	public List<Contact> getContactByPhoneBookId(@PathVariable(value = "phonebookId") Long phonebookId,
			@PathVariable(value = "name") String name) {
		return contactService.findByIdAndName(phonebookId, name);
	}
	
	
	
	@DeleteMapping("/phonebooks/{phonebookId}/contacts/{contactId}")
    public ResponseEntity<?> deleteComment(@PathVariable (value = "phonebookId") Long phonebookId,
                              @PathVariable (value = "contactId") Long contactId) {
		Contact contact = contactService.findById(contactId, phonebookId);
		contactService.delete(contact);
		return ResponseEntity.ok().build();
    }
}
