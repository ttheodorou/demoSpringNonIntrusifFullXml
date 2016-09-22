package com.objis.demoArchiJdbc.domaine;

public class Employe {
	
	private int id;
	private String nom;
	private String prenom;
	
	public Employe( int id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
	

	public Employe() {
		super();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String toString(){
		return ("Employ� : "+ id +", "+ nom +", "+ prenom);
	}
	
}
