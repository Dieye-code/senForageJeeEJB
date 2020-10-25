package com.senForage.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.senForage.entities.Abonnement;
import com.senForage.entities.Compteur;

@Stateless
public class CompteurDao implements ICompteur {
	

	@PersistenceContext(unitName ="senForageVersion2Pu")
	private EntityManager em;

	public CompteurDao() {
		
	}

	@Override
	public int addCompteur(Compteur compteur) {
		try { 
			em.persist(compteur);
			em.flush();
			return compteur.getId();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int editCompteur(Compteur compteur) {
		try { 
			em.persist(compteur);
			em.flush();
			return compteur.getId();
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public Compteur getCompteur(int idClient) {
		try {
			return em.find(Compteur.class, idClient);
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
	public List<Compteur> listeCompteur() {
		try {
			Query query = em.createQuery("select c From Compteur c");
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Abonnement> listeAbonnement() {
		try {
			Query query = em.createQuery("select c From Abonnement c where c.etat=0");
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

}
