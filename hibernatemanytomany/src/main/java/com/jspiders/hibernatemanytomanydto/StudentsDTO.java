package com.jspiders.hibernatemanytomanydto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
@Entity
@Data
public class StudentsDTO {
	@Id
private int id;
private String name;
private String email;
private String address;
@ManyToMany
List<SubjectDTO> suubject;
}
