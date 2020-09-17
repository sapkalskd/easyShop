package com.es.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "es_register_user_details")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "user_id",nullable = false, updatable = false)	
	private Integer id;
	/*
	 * @NotNull(message = "First Name can not be null.")
	 * 
	 * @NotEmpty(message = "First Name can not be empty.")
	 */
	@Column(name = "first_name")
	private String firstName;
	
	/*
	 * @NotNull(message = "Last Name can not be null.")
	 * 
	 * @NotEmpty(message = "Last Name can not be empty.")
	 */
	@Column(name = "last_name")	
	private String lastName;

	/*
	 * @NotNull(message = "E-mail can not be null.")
	 * 
	 * @NotEmpty(message = "E-mail can not be empty.")
	 */
	@Column(name = "user_email",nullable = false, updatable = false)	
	private String email;

	/*
	 * @NotNull(message = "Phone No can not be null.")
	 * 
	 * @Pattern(regexp = "[0-9]", message = "Enter 10 digit mobile no.")
	 * 
	 * @Size(min = 10, max = 10,message = "Enter 10 digit mobile no.")
	 * 
	 * @NotEmpty(message = "Phone No can not be empty.")
	 * 
	 */
	 @Column(name = "phone_no")
	private Long phoneNo;

	/*
	 * @NotNull(message = "Password can not be null.")
	 * 
	 * @NotEmpty(message = "Password can not be empty.")
	 * 
	 * @Pattern(regexp = "[0-9A-Za-z]", message =
	 * "Enter valid password(only '@','$','#' special carectors are allowed)")
	 * 
	 * @Size(min = 8,max = 25,message = "Password must be in 8-25 charector")
	 */
	@Column(name = "password")	
	private String password;
	
	//private int enabled = 1;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(
			name = "es_user_role",
			joinColumns = @JoinColumn(name = "id_join_col"))
	private Set<String> roles = new HashSet<>();
	
}
