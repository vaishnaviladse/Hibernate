package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



public class EmployeeDeleteDAO {
private static EntityManagerFactory factory;
private static EntityManager manager;
private static EntityTransaction transaction;

private static void openConnection() {
	factory=Persistence.createEntityManagerFactory("hibernate");
    manager=factory.createEntityManager();
    transaction=manager.getTransaction();
    
    
}
private static void closeConnection() {
	if(factory!=null) {
		factory.close();
	}
	if (manager!=null) {
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
		EmployeeDeleteDAO empolyee=manager.find(EmployeeDeleteDAO.class, 2);
		manager.remove(empolyee);
		transaction.commit();
	} finally {
		closeConnection();
	}
}
}

