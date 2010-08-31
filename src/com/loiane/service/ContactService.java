package com.loiane.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loiane.dao.ContactDAO;
import com.loiane.model.Contact;
import com.loiane.util.Util;

/**
 * Contact Service
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
@Service
public class ContactService {
	
	private ContactDAO contactDAO;
	private Util util;

	/**
	 * Get all contacts
	 * @return
	 */
	@Transactional(readOnly=true)
	public List<Contact> getContactList(){

		return contactDAO.getContacts();
	}
	
	/**
	 * Create new Contact/Contacts
	 * @param data - json data from request
	 * @return created contacts
	 */
	@Transactional
	public List<Contact> create(Object data){
		
        List<Contact> newContacts = new ArrayList<Contact>();
		
		List<Contact> list = util.getContactsFromRequest(data);
		
		for (Contact contact : list){
			newContacts.add(contactDAO.saveContact(contact));
		}
		
		return newContacts;
	}
	
	
	/**
	 * Update contact/contacts
	 * @param data - json data from request
	 * @return updated contacts
	 */
	@Transactional
	public List<Contact> update(Object data){
		
		List<Contact> returnContacts = new ArrayList<Contact>();
		
		List<Contact> updatedContacts = util.getContactsFromRequest(data);
		
		for (Contact contact : updatedContacts){
			returnContacts.add(contactDAO.saveContact(contact));
		}
		
		return returnContacts;
	}
	
	/**
	 * Delete contact/contacts
	 * @param data - json data from request
	 */
	@Transactional
	public void delete(Object data){
		
		//it is an array - have to cast to array object
		if (data.toString().indexOf('[') > -1){
			
			List<Integer> deleteContacts = util.getListIdFromJSON(data);
			
			for (Integer id : deleteContacts){
				contactDAO.deleteContact(id);
			}
			
		} else { //it is only one object - cast to object/bean
			
			Integer id = Integer.parseInt(data.toString());
			
			contactDAO.deleteContact(id);
		}
	}
	

	/**
	 * Spring use - DI
	 * @param contactDAO
	 */
	@Autowired
	public void setContactDAO(ContactDAO contactDAO) {
		this.contactDAO = contactDAO;
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
