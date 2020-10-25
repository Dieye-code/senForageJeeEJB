package com.senForage.dao;

import java.util.List;

import javax.ejb.Local;

import com.senForage.entities.Abonnement;
import com.senForage.entities.Compteur;

@Local
public interface ICompteur {
	
	public int addCompteur(Compteur client);
	public int editCompteur(Compteur client);
	public Compteur getCompteur(int idClient);
	public Abonnement getAbonnement(int idAbonnement);
	public List<Compteur> listeCompteur();
	public List<Abonnement> listeAbonnement();

}
