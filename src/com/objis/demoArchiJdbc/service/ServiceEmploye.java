package com.objis.demoArchiJdbc.service;

import java.util.List;

import com.objis.demoArchiJdbc.dao.DaoEmploye;
import com.objis.demoArchiJdbc.domaine.Employe;

public class ServiceEmploye {

	DaoEmploye daoEmploye;

	public DaoEmploye getDaoEmploye() {
		return daoEmploye;
	}

	public void setDaoEmploye(DaoEmploye daoEmploye) {
		this.daoEmploye = daoEmploye;
	}

	public ServiceEmploye() {
		super();
	}

	public Employe createEmploye(Employe employe) {
		daoEmploye.createEmploye(employe);
		Employe newEmploye = daoEmploye.readEmployeById(employe.getId());
		return newEmploye;

	}

	public List<Employe> readAllEmploye() {
		return daoEmploye.readAllEmploye();

	}

	public Employe readEmployeById(int id) {
		return daoEmploye.readEmployeById(id);

	}

	public void updateEmployeByNom(int id, String nom) {
		daoEmploye.updateEmployeByNom(id, nom);
	}

	public void deleteEmployeById(int id) {
		daoEmploye.deleteEmployeById(id);
	}
}
