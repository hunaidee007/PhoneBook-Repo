package com.hunaid.phonebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hunaid.phonebook.data.modal.Phonebook;
import com.hunaid.phonebook.data.repository.PhoneBookRepository;

@Service
public class PhoneBookService {
	
	@Autowired
	private PhoneBookRepository phoneBookRepository;
	
	public List<Phonebook> list(){
		return phoneBookRepository.findAll();
	}
	
	public Phonebook findById(Long id) {
		return phoneBookRepository.findById(id).get();
	}
	
	public Phonebook save(Phonebook phonebook) {
		return phoneBookRepository.save(phonebook);
	}
	
	public void delete(Phonebook phonebook) {
		phoneBookRepository.delete(phonebook);
	}

}
