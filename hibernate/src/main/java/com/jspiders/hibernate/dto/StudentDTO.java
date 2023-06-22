package com.jspiders.hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class StudentDTO {
	@Id
private int sid;
private String Sname;
private String Semail;
private int Smark;
private String Sadd;

}
