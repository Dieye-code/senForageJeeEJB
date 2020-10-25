package com.senForage.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Abonnement
 *
 */
@Entity
@Table(name="abonnement")
public class Abonnement implements Serializable{

	   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String dateAbonnement;
	private String description;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Client client = new Client();
	private boolean etat;

	public Abonnement() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getDateAbonnement() {
		return this.dateAbonnement;
	}

	public void setDateAbonnement(String dateAbonnement) {
		this.dateAbonnement = dateAbonnement;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}
	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	/**
	 * @return the etat
	 */
	public boolean isEtat() {
		return etat;
	}
	/**
	 * @param etat the etat to set
	 */
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
   
	
}
