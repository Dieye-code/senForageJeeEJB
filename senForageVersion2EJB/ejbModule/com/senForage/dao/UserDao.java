package com.senForage.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.senForage.entities.Role;
import com.senForage.entities.User;

@Stateless
public class UserDao implements IUser {
	

	@PersistenceContext(unitName ="senForageVersion2Pu")
	private EntityManager em;

	public UserDao() {
		
	}

	@Override
	public int addUser(User user) {
		try { 
			this.em.persist(user);
			em.flush();
			return user.getId();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int updateUser(User user) {
		try {
			this.em.merge(user);
			this.em.flush();
			return user.getId();
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public List<User> listeUser() {
		Query query = em.createQuery("select u from User u");
		return query.getResultList();
	}

	@Override
	public List<Role> listeRole() {
		Query query = em.createQuery("select u from Role u");
		return query.getResultList();
	}

	@Override
	public User getUserById(int id) {
		try {
			return em.find(User.class, id);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Role getRoleById(int id) {
		try {
			return em.find(Role.class, id);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public User getUserByEmail(String email) {
		try {
			Query query = em.createQuery("select u from User u where u.email=:email");
			query.setParameter("email", email);
			return (User) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

}
