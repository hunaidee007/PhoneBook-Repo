package com.hunaid.phonebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hunaid.phonebook.data.modal.Contact;
import com.hunaid.phonebook.data.modal.Phonebook;
import com.hunaid.phonebook.data.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	public List<Contact> list(Long phonebookId) {
		return contactRepository.findByPhonebookId(phonebookId);
	}

	public Contact findById(Long id, Long phonebookId) {
		return contactRepository.findByIdAndPhonebookId(id, phonebookId);
	}
	
	public List<Contact> findByIdAndName(Long phonebookId, String name) {
		return contactRepository.findByNameStartsWith(name);
	}
	
	

	public Contact save(Contact contact) {
		return contactRepository.save(contact);
	}
	
	public void delete(Contact contact) {
		contactRepository.delete(contact);
	}

}
