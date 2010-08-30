package com.loiane.dao;

import java.util.List;

import com.loiane.model.Contact;

public interface IContactDAO {

	List<Contact> getContacts();
	
	void deleteContact(int id);
	
	Contact saveContact(Contact contact);
	
}
