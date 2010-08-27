package com.loiane.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.loiane.model.Contact;
import com.loiane.util.Util;

/**
 * Contact DAO class.
 * It does not connect to a database.
 * The database is a static List of Objects.
 * It was implemented this way so anyone can run this application
 * on any platform and does not need to have a database
 * installed on the computer.
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
@Repository
public class ContactDAO {
	
	/**
	 * "Fake database"
	 */
	private static List<Contact> contacts;
	
	/**
	 * Sequence control
	 */
	private static int contactNextId = 11;
	
	private Util util;
	
	
	public ContactDAO(){
		getInitContacts();
	}
	
	/**
	 * Get List of contacts
	 * @return list of all contacts
	 */
	public List<Contact> getContacts() {
		return contacts;
	}

	/**
	 * Delete a contact with the id passed as parameter
	 * @param id
	 */
	public void deleteContact(int id){
		Contact contact = findContact(id);
		contacts.remove(contact);
	}
	
	/**
	 * Create a new Contact on the list/"database"
	 * @param newContact
	 * @return contact added to DB
	 * @throws ParseException 
	 */
	public Contact addContact(Contact newContact) throws ParseException{
		newContact.setId(contactNextId++);
		newContact.setBirthday(util.getFormatedString(newContact.getBirthday()));
		contacts.add(newContact);
		return newContact;
	}
	
	
	/**
	 * Update a current Contact on the list/"database".
	 * There are only updated fields in the request (because of 
	 * writeAllFields: false in Writer object in ExtJS). When it transforms
	 * JSON data to a Contact Bean, the non updated fields remains null, that
	 * is why we have to verify which fields are not null.
	 * If you do not want it, you can set writeAllFields to true and
	 * overwrite the current object info with the new/updated info.
	 * @param updatedContact
	 * @return updated contact
	 * @throws ParseException 
	 */
	public Contact updateContact(Contact updatedContact) throws ParseException{
		
		Contact listContact = findContact(updatedContact.getId());
		
		if (updatedContact.getName() != null){
			listContact.setName(updatedContact.getName());
		}
		
		if (updatedContact.getPhone() != null){
			listContact.setPhone(updatedContact.getPhone());
		}
		
		if (updatedContact.getEmail() != null){
			listContact.setEmail(updatedContact.getEmail());
		}
		
		if (updatedContact.getBirthday() != null){
			listContact.setBirthday(util.getFormatedString(updatedContact.getBirthday()));
		}
		
		return listContact;
	}
	
	/**
	 * Find a contact by id in contacts list
	 * @param id contact id
	 * @return contact if found; null otherwise
	 */
	private Contact findContact(int id){
		for (Contact contact : contacts){
			if (contact.getId() == id){
				return contact;
			}
		}
		return null;
	}


	/**
	 * Generates 10 Contacts to populate the grid initially
	 */
	private void getInitContacts(){

		contacts = new ArrayList<Contact>(10);

		for (int i=0; i<10; i++){
			contacts.add(geratesContact(i));
		}
	}
	
	/**
	 * Generates a Contact with dummy info
	 * @param i index
	 * @return
	 */
	private Contact geratesContact(int i){
		Contact contact = new Contact();
		contact.setId(i);
		String name = "Contact" + i;
		contact.setName(name);
		contact.setEmail(name+"@asdfg.com");
		contact.setBirthday("01/01/2000");
		contact.setPhone("(000) 000-0000");
		return contact;
	}
	
	/**
	 * Spring use - DI
	 * @param util
	 */
	@Autowired
	public void setUtil(Util util) {
		this.util = util;
	}

}
