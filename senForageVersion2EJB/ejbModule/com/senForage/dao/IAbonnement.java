package com.senForage.dao;

import java.util.List;

import javax.ejb.Local;

import com.senForage.entities.Abonnement;
import com.senForage.entities.Client;

@Local
public interface IAbonnement {
	
	public int addAbonnement(Abonnement client);
	public int editAbonnement(Abonnement client);
	public Client getClient(int idClient);
	public Abonnement getAbonnement(int idAbonnement);
	public List<Client> listeClient();
	public List<Abonnement> listeAbonnement();

}
