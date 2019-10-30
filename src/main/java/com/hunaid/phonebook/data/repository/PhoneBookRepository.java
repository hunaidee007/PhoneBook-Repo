package com.hunaid.phonebook.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hunaid.phonebook.data.modal.Phonebook;

@Repository
public interface PhoneBookRepository extends JpaRepository<Phonebook, Long>{

	
}
