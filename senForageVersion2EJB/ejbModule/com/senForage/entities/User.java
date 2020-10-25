package com.senForage.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name="user")

public class User implements Serializable{

	   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String email;
	private String password;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idPersonne", nullable = false)
	private Personne personne;
	@ManyToMany( cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Role> roles = new ArrayList<Role>();

	
	public User() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public void addRole(Role role) {
		if(!this.roles.contains(role)) {
			this.roles.add(role);
		}
	}
	
	public void removeRole(Role role) {
		if(this.roles.contains(role)) {
			this.roles.remove(role);
		}
	}
   
}
