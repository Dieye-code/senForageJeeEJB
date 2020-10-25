package com.senForage.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Client
 *
 */
@Entity
@Table(name="client")

public class Client implements Serializable{

	   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(nullable = false)
	private Personne personne = new Personne();
	@ManyToOne
	@JoinColumn(nullable = true)
	private Village village = new Village();
	@OneToMany(mappedBy = "client")
	private List<Abonnement> abonnements = new ArrayList<Abonnement>();
	
	public Client() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the personne
	 */
	public Personne getPersonne() {
		return personne;
	}
	/**
	 * @param personne the personne to set
	 */
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	/**
	 * @return the village
	 */
	public Village getVillage() {
		return village;
	}
	/**
	 * @param village the village to set
	 */
	public void setVillage(Village village) {
		this.village = village;
	}
	/**
	 * @return the abonnements
	 */
	public List<Abonnement> getAbonnements() {
		return abonnements;
	}
	/**
	 * @param abonnements the abonnements to set
	 */
	public void setAbonnements(List<Abonnement> abonnements) {
		this.abonnements = abonnements;
	}
		
	
}
