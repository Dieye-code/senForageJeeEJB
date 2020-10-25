package com.senForage.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.senForage.entities.Role;

@Stateless
public class RoleDao implements IRole {
	

	@PersistenceContext(unitName ="senForageVersion2Pu")
	private EntityManager em;

	public RoleDao() {
		
	}

	@Override
	public int addRole(Role role) {
		try {
			this.em.persist(role);
			this.em.flush();
			return role.getId();
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int updateRole(Role role) {
		try {
			this.em.merge(role);
			this.em.flush();
			return role.getId();
		} catch (Exception e) {
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> listeRole() {
		Query query = em.createQuery("select r from Role r");
		return query.getResultList();
	}

	@Override
	public Role getRoleById(int id) {
		try {
			return em.find(Role.class, id);
		} catch (Exception e) {
			return null;
		}
	}

}
