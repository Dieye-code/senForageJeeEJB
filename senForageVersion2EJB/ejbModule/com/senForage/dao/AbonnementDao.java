package com.senForage.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.senForage.entities.Abonnement;
import com.senForage.entities.Client;

@Stateless
public class AbonnementDao implements IAbonnement {
	
	@PersistenceContext(unitName ="senForageVersion2Pu")
	private EntityManager em;

	public AbonnementDao() {
	}

	@Override
	public int addAbonnement(Abonnement abonnement) {
		try {
			em.persist(abonnement);
			em.flush();
			return abonnement.getId();
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int editAbonnement(Abonnement abonnement) {
		try {
			em.persist(abonnement);
			em.flush();
			return abonnement.getId();
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
	public Abonnement getAbonnement(int idAbonnement) {
		try {
			return em.find(Abonnement.class, idAbonnement);
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
	public List<Abonnement> listeAbonnement() {
		try {
			Query query = em.createQuery("select c From Abonnement c");
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

}
