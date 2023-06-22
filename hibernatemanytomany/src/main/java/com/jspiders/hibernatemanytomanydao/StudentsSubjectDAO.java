package com.jspiders.hibernatemanytomanydao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernatemanytomanydto.StudentsDTO;
import com.jspiders.hibernatemanytomanydto.SubjectDTO;

public class StudentsSubjectDAO {
private static EntityManagerFactory factory;
private static EntityManager manager;
private static EntityTransaction transaction;

private static void openConnection() {
	factory=Persistence.createEntityManagerFactory("ManyToMany");
	manager=factory.createEntityManager();
	transaction=manager.getTransaction();
	
}
private static void closeConnection() {
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
		
		
		SubjectDTO subject1=new SubjectDTO();
		subject1.setId(1);
		subject1.setName("Core-java");
		subject1.setDueration(3);
		manager.persist(subject1);
		SubjectDTO subject2=new SubjectDTO();
		subject2.setId(2);
		subject2.setName("Advance java");
		subject2.setDueration(3);
		
		manager.persist(subject2);
		
		
		List<SubjectDTO> subjects=Arrays.asList(subject1,subject2);
		
		
		StudentsDTO student1=new StudentsDTO();
		student1.setId(1);
		student1.setName("kunal");
		student1.setEmail("kunal@123");
		student1.setAddress("pune");
		student1.setSuubject(subjects);
		manager.persist(student1);
		
		
		StudentsDTO student2=new StudentsDTO();
		student2.setId(2);
		student2.setName("mrunal");
		student2.setEmail("mrunal@123");
		student2.setAddress("Amravati");
		student2.setSuubject(subjects);
		manager.persist(student2);
			
		
		transaction.commit();
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		closeConnection();
	}
	
}
}
