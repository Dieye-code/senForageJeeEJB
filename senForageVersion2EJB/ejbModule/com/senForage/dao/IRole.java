package com.senForage.dao;

import java.util.List;

import javax.ejb.Local;

import com.senForage.entities.Role;

@Local
public interface IRole {
	
	public int addRole(Role role);
	public int updateRole(Role role);
	public List<Role> listeRole();
	public Role getRoleById(int id);

}
