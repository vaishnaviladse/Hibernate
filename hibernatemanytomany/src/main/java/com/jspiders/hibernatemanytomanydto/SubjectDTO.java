package com.jspiders.hibernatemanytomanydto;


import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.Data;
@Entity
@Data
public class SubjectDTO {
	@Id
private int id;
private String name;
private int dueration;
}
