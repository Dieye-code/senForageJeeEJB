package com.senForage.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.senForage.entities.Client;
import com.senForage.entities.Village;

@Stateless
public class ClientDao implements IClient {


	@PersistenceContext(unitName ="senForageVersion2Pu")
	private EntityManager em;
	
	public ClientDao() {
	}

	@Override
	public int addClient(Client client) {
		try {
			em.persist(client);
			em.flush();
			return client.getId();
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int editClient(Client client) {
		try { 
			em.merge(client);
			em.flush();
			return client.getId();
		} catch (Exception e) { 
			return 0;
		}
	}

	@Override
	public Client getClient(int idClient) {
		try {
			return em.find(Client.class, idClient);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Village getVillage(int idVillage) {
		try {
			return em.find(Village.class, idVillage);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Client> listeClient() {
		try {
			Query query = em.createQuery("select c From Client c");
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Village> listeVillage() {
		try {
			Query query = em.createQuery("select c From Village c");
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

}
