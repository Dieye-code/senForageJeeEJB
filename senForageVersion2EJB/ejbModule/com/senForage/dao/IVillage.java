package com.senForage.dao;

import java.util.List;

import javax.ejb.Local;

import com.senForage.entities.Client;
import com.senForage.entities.Village;

@Local
public interface IVillage {
	
	public int addVillege(Village village);
	public int editVillege(Village village);
	public Village getVillage(int idVillage);
	public Village getVillageByLibelle(String libelle);
	public List<Village> listeVillage();
	public Client getClient(int idClient);
	public List<Client> listeClient();

}
