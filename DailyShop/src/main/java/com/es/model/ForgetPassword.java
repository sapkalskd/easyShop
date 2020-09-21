package com.es.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name ="es_forget_password")
public class ForgetPassword {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String email;
	private long oneTimePassword;
	
	
}
