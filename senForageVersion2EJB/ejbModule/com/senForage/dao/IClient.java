package com.senForage.dao;

import java.util.List;

import javax.ejb.Local;

import com.senForage.entities.Client;
import com.senForage.entities.Village;

@Local
public interface IClient {
	
	public int addClient(Client client);
	public int editClient(Client client);
	public Client getClient(int idClient);
	public Village getVillage(int idVillage);
	public List<Client> listeClient();
	public List<Village> listeVillage();

}
