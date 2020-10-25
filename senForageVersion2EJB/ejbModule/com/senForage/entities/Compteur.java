package com.senForage.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Compteur
 *
 */
@Entity
@Table(name="compteur")

public class Compteur implements Serializable{

	   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description;
	private String dateAttribution;
	private boolean etat;
	@OneToOne
	@JoinColumn(nullable = false)
	private Abonnement abonnement = new Abonnement();
	@OneToMany(mappedBy = "compteur")
	private List<Facture> factures = new ArrayList<Facture>();

	public Compteur() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getDescription() {
		return this.description;
	}
	

	/**
	 * @return the dateAttribution
	 */
	public String getDateAttribution() {
		return dateAttribution;
	}
	/**
	 * @param dateAttribution the dateAttribution to set
	 */
	public void setDateAttribution(String dateAttribution) {
		this.dateAttribution = dateAttribution;
	}
	public void setDescription(String description) {
		this.description = description;
	}   
	public boolean getEtat() {
		return this.etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	/**
	 * @return the abonnement
	 */
	public Abonnement getAbonnement() {
		return abonnement;
	}
	/**
	 * @param abonnement the abonnement to set
	 */
	public void setAbonnement(Abonnement abonnement) {
		this.abonnement = abonnement;
	}
	/**
	 * @return the factures
	 */
	public List<Facture> getFactures() {
		return factures;
	}
	/**
	 * @param factures the factures to set
	 */
	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}
	
	
   
}
