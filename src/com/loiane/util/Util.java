package com.loiane.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.loiane.model.Contact;

/**
 * Util class. Contains some common methods that can be used
 * for any class
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
@Component
public class Util {
	
	private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	
	private static DateFormat dfString = new SimpleDateFormat("MM/dd/yyyy");

	/**
	 * Get list of Contacts from request.
	 * @param data - json data from request 
	 * @return list of Contacts
	 */
	public List<Contact> getContactsFromRequest(Object data){

		List<Contact> list;

		//it is an array - have to cast to array object
		if (data.toString().indexOf('[') > -1){

			list = getListContactsFromJSON(data);

		} else { //it is only one object - cast to object/bean

			Contact contact = getContactFromJSON(data);

			list = new ArrayList<Contact>();
			list.add(contact);
		}

		return list;
	}

	/**
	 * Transform json data format into Contact object
	 * @param data - json data from request
	 * @return 
	 */
	public Contact getContactFromJSON(Object data){
		JSONObject jsonObject = JSONObject.fromObject(data);
		Contact newContact = (Contact) JSONObject.toBean(jsonObject, Contact.class);
		return newContact;
	}

	/**
	 * Transform json data format into list of Contact objects
	 * @param data - json data from request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Contact> getListContactsFromJSON(Object data){
		JSONArray jsonArray = JSONArray.fromObject(data);
		List<Contact> newContacts = (List<Contact>) JSONArray.toCollection(jsonArray,Contact.class);
		return newContacts;
	}

	/**
	 * Tranform array of numbers in json data format into
	 * list of Integer
	 * @param data - json data from request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Integer> getListIdFromJSON(Object data){
		JSONArray jsonArray = JSONArray.fromObject(data);
		List<Integer> idContacts = (List<Integer>) JSONArray.toCollection(jsonArray,Integer.class);
		return idContacts;
	}
	
	/**
	 * Format a yyyy-MM-dd'T'HH:mm:ss string to MM/dd/yyyy string
	 * JSON date has the following format: yyyy-MM-dd'T'HH:mm:ss
	 * @param jsonDate
	 * @return MM/dd/yyyy string date
	 * @throws ParseException
	 */
	public String getFormatedString(String jsonDate) throws ParseException{
		Date date = df.parse(jsonDate);
		return dfString.format(date);
	}
}
