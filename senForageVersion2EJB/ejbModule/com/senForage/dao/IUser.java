package com.senForage.dao;

import java.util.List;

import javax.ejb.Local;

import com.senForage.entities.Role;
import com.senForage.entities.User;

@Local
public interface IUser {
	
	public int addUser(User user);
	public int updateUser(User user);
	public List<User> listeUser();
	public List<Role> listeRole();
	public User getUserById(int id);
	public Role getRoleById(int id);
	public User getUserByEmail(String email);

}
