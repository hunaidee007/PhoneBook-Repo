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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hunaid.phonebook.data.modal.Phonebook;
import com.hunaid.phonebook.service.PhoneBookService;

@RestController()

public class PhoneBookController {
	
	@Autowired
    private PhoneBookService phoneBookService;

	@GetMapping("phonebooks")
	public List<Phonebook> getAllphonebooks() {
		List<Phonebook> phonebooks = phoneBookService.list();
		return phonebooks;
		
	}

	@GetMapping("phonebooks/{phoneBookId}")
	public Phonebook getPhoneBookById(@PathVariable String phoneBookId) {
		return phoneBookService.findById(Long.parseLong(phoneBookId));
	}
	
	@PostMapping("/phonebooks")
    public Phonebook createPost(@Valid @RequestBody Phonebook phonebook) {
		System.out.println(phonebook.getId() + " :: " + phonebook.getName());
        return phoneBookService.save(phonebook);
    }
	
	@DeleteMapping("phonebooks/{phoneBookId}")
    public ResponseEntity<?> deletePost(@PathVariable Long phoneBookId) {
        Phonebook phonebook = phoneBookService.findById(phoneBookId);
        phoneBookService.delete(phonebook);
        return ResponseEntity.ok().build();
    }
}
