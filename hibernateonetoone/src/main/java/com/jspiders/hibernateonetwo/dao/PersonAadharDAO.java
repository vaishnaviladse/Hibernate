package com.jspiders.hibernateonetwo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernateonetwo.dto.AadharDTO;
import com.jspiders.hibernateonetwo.dto.PersonDTO;


public class PersonAadharDAO {
private static EntityManagerFactory factory;
private static EntityManager  manager;
private static EntityTransaction transaction;

private static void openConnection() {
	factory=Persistence.createEntityManagerFactory("OneToOne");
	manager=factory.createEntityManager();
	transaction=manager.getTransaction();
	
}

private static void closeConnection() {
	if(factory!=null) {
		factory.close();
	}
	if(manager!=null) {
		manager.close();
	}
	if(transaction.isActive()) {
		transaction.rollback();
	}
}
public static void main(String[] args) {
	try {
	openConnection();
	transaction.begin();
	AadharDTO aadhar1=new AadharDTO();
	aadhar1.setId(1);
	aadhar1.setAadhar_no(7858458696l);
	aadhar1.setDoi("01-02-2001");
	
	manager.persist(aadhar1);
	
	PersonDTO person1=new PersonDTO ();
	
	person1.setId(1);
	person1.setName("prajwal");
	person1.setContact(7845128254l);
	person1.setAddress("pune");
	person1.setAadharDTO(aadhar1);
	
	manager.persist(person1);
	transaction.commit();
}finally{
	closeConnection();
}
}
}
