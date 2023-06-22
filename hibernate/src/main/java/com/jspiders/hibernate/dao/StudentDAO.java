package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.jspiders.hibernate.dto.StudentDTO;

public class StudentDAO {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("hibernate");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	
	entityTransaction.begin();
	StudentDTO studentDTO=new StudentDTO();
    studentDTO.setSid(2);
    studentDTO.setSname("kunal pandya");
    studentDTO.setSemail("pandya@gmail.com");
    studentDTO.setSmark(80);
    studentDTO.setSadd("pune");
    entityManager.persist(studentDTO);
    entityTransaction.commit();	
   if (entityManagerFactory!=null) {
	entityManagerFactory.close();
}
   if (entityManager!=null) {
	entityManager.close();
}
   if (entityTransaction.isActive()) {
	entityTransaction.rollback();
}
}
}
