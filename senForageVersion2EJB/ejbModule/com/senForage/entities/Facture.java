package com.senForage.entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Facture
 *
 */
@Entity
@Table(name="facture")

public class Facture implements Serializable {

	   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private int ancienIndex;
	private int nouveauIndex;
	private int consommation;
	private int montant;
	private int montantNet;
	private boolean etat;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Compteur compteur = new Compteur();

	public Facture() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public int getAncienIndex() {
		return this.ancienIndex;
	}

	public void setAncienIndex(int ancienIndex) {
		this.ancienIndex = ancienIndex;
	}   
	public int getNouveauIndex() {
		return this.nouveauIndex;
	}

	public void setNouveauIndex(int nouveauIndex) {
		this.nouveauIndex = nouveauIndex;
	}   
	public int getConsommation() {
		return this.consommation;
	}

	public void setConsommation(int consommation) {
		this.consommation = consommation;
	}   
	public int getMontant() {
		return this.montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}   
	public int getMontantNet() {
		return this.montantNet;
	}

	public void setMontantNet(int montantNet) {
		this.montantNet = montantNet;
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
	/**
	 * @return the compteur
	 */
	public Compteur getCompteur() {
		return compteur;
	}
	/**
	 * @param compteur the compteur to set
	 */
	public void setCompteur(Compteur compteur) {
		this.compteur = compteur;
	}
	
   
}
