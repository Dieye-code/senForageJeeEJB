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
public class VillageDao implements IVillage {
	

	@PersistenceContext(unitName ="senForageVersion2Pu")
	private EntityManager em;

	public VillageDao() {
		
	}

	@Override
	public int addVillege(Village village) {
		try { 
			em.persist(village);
			em.flush();
			return village.getId();
		} catch (Exception e) { 
			return 0;
		}
		
	}

	@Override
	public int editVillege(Village village) {
		try { 
			em.merge(village);
			em.flush();
			return village.getId();
		} catch (Exception e) { 
			return 0;
		}
	}

	@Override
	public Village getVillage(int idVillage) {
		try {
			return em.find(Village.class, idVillage);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Village getVillageByLibelle(String libelle) {
		try {
			
			Query query = em.createQuery("select v from Village v where v.libelle=:libelle");
			query.setParameter("village", libelle);
			
			return (Village) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Village> listeVillage() {
		Query query = em.createQuery("select v from Village v");
		return query.getResultList();
	}

	@Override
	public Client getClient(int idClient) {
		try {
			return em.find(Client.class, idClient);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Client> listeClient() {
		Query query = em.createQuery("select v from Client v");
		return query.getResultList();
	}

}
