package com.hunaid.phonebook.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hunaid.phonebook.data.modal.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

	List<Contact> findByPhonebookId(Long phonebookId);

	Contact findByIdAndPhonebookId(Long id, Long phonebookId);

	Contact findByPhonebookIdAndName(Long phonebookId, String name);

	//@Query("select u from CONTACT u where u.name like %?1")
	List<Contact> findByNameStartsWith(String name);
}
