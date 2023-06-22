package com.jspiders.hibernateOneToMany.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernateOneToMany.dto.CompanyDTO;
import com.jspiders.hibernateOneToMany.dto.EmployeeDTO;

public class CompanyEmployeeDAO {
private static EntityManagerFactory factory;
private static EntityManager manager;
private static EntityTransaction transaction;


public static void openConnection() {
	factory=Persistence.createEntityManagerFactory("OneToMany");
	manager=factory.createEntityManager();
	transaction=manager.getTransaction();
}

public static void closeConnection() {
	if (factory!=null) {
		factory.close();
	}
	if (manager!=null) {
		manager.close();
	}
	if (transaction.isActive()) {
		transaction.rollback();
	}
}
public static void main(String[] args) {
	try {
		openConnection();
		transaction.begin();
		
		EmployeeDTO employee1=new EmployeeDTO();
		employee1.setId(1);
		employee1.setName("Prajwal");
		employee1.setEmail("prajwal@123");
		employee1.setDesignation("ahirwada");
	employee1.setSalary(27000);
	manager.persist(employee1);
	
	EmployeeDTO employee2=new EmployeeDTO();
	employee2.setId(2);
	employee2.setName("Ranjit");
	employee2.setEmail("Ranjit@123");
	employee2.setDesignation("Developer");
	employee2.setSalary(30000);
	manager.persist(employee2);
	
	EmployeeDTO employee3=new EmployeeDTO();
	employee3.setId(3);
	employee3.setName("Praful");
	employee3.setEmail("praful@123");
	employee3.setDesignation("manager");
	employee3.setSalary(250000);
	manager.persist(employee3);
	
	List<EmployeeDTO>empolyees=Arrays.asList(employee1,employee2,employee3);
	
	CompanyDTO companyDTO=new CompanyDTO();
	companyDTO.setId(1);
	companyDTO.setName("TCS");
	companyDTO.setDoe("01-10-1990");
	companyDTO.setAddress("pune");
	companyDTO.setEmployees(empolyees);
	manager.persist(companyDTO);
	
	transaction.commit();
		
	} finally {
		closeConnection();
	}
}
}
