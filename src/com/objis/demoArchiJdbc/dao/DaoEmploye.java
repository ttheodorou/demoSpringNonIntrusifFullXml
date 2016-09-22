package com.objis.demoArchiJdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.objis.demoArchiJdbc.domaine.Employe;

public class DaoEmploye {

	DaoDataBase ddb;
	public DaoDataBase getDdb() {
		return ddb;
	}

	public void setDdb(DaoDataBase ddb) {
		this.ddb = ddb;
	}


//	Employe saveEmploye;

	public DaoEmploye() {
		super();
	}

	public void createEmploye(Employe employe) {

		String url = "jdbc:mysql://localhost/formation";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;

		try {

			// Etape 1 : chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			ddb.cn = DriverManager.getConnection(ddb.url, ddb.login, ddb.passwd);

			// Etape 3 : Création d'un statement
			ddb.st = ddb.cn.createStatement();

			// Etape 4 : execution requete
			String sql = "INSERT INTO employe (id, nom, prenom) VALUES ('" + employe.getId() + "','" + employe.getNom()
					+ "','" + employe.getPrenom() + "')";
			ddb.st.executeUpdate(sql);

			// Etape 5 : parcours ResultSet
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				// Etape 5 : libérer ressources de la mémoire
				ddb.cn.close();
				ddb.st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Employe> readAllEmploye() {
		List<Employe> listEmploye = new ArrayList<Employe>();
		try {
			// Etape 1 : chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			ddb.cn = DriverManager.getConnection(ddb.url, ddb.login, ddb.passwd);

			// Etape 3 : Création d'un statement
			ddb.st = ddb.cn.createStatement();

			// Etape 4 : execution requete
			String sql = "SELECT * FROM employe";
			ddb.rs = ddb.st.executeQuery(sql);

			// Etape 5 : parcours ResultSet
			while (ddb.rs.next()) {
				listEmploye.add(new Employe(ddb.rs.getInt("id"), ddb.rs.getString("nom"), ddb.rs.getString("prenom")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				// Etape 5 : libérer ressources de la mémoire
				ddb.cn.close();
				ddb.st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listEmploye;
	}

	public Employe readEmployeById(int id) {
		Employe lectureEmploye = null;
		try {
			// Etape 1 : chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			ddb.cn = DriverManager.getConnection(ddb.url, ddb.login, ddb.passwd);

			// Etape 3 : Création d'un statement
			ddb.st = ddb.cn.createStatement();

			// Etape 4 : execution requete
			String sql = "SELECT * FROM employe WHERE id = " + id + "";
			ddb.rs = ddb.st.executeQuery(sql);

			// Etape 5 : parcours ResultSet
			lectureEmploye = new Employe(ddb.rs.getInt("id"), ddb.rs.getString("nom"), ddb.rs.getString("prenom"));

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				// Etape 5 : libérer ressources de la mémoire
				ddb.cn.close();
				ddb.st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lectureEmploye;
	}

	public Employe updateEmployeByNom(int id, String nom) {

		Employe updateEmploye = null;

		try {
			// Etape 1 : chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			ddb.cn = DriverManager.getConnection(ddb.url, ddb.login, ddb.passwd);

			// Etape 3 : Création d'un statement
			ddb.st = ddb.cn.createStatement();

			// Etape 4 : execution requete
			String sql = "UPDATE employe SET nom = '" + nom + " WHERE id = '" + id + "'";
			ddb.rs = ddb.st.executeQuery(sql);

			// Etape 5 : parcours ResultSet
			updateEmploye = new Employe(ddb.rs.getInt("id"), ddb.rs.getString("nom"), ddb.rs.getString("prenom"));

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				// Etape 5 : libérer ressources de la mémoire
				ddb.cn.close();
				ddb.st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return updateEmploye;
	}

	public void deleteEmployeById(int id) {

		try {
			// Etape 1 : chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			ddb.cn = DriverManager.getConnection(ddb.url, ddb.login, ddb.passwd);

			// Etape 3 : Création d'un statement
			ddb.st = ddb.cn.createStatement();

			// Etape 4 : execution requete
			String sql = "DELETE FROM javadb WHERE id = '" + id + "'";
			ddb.st.executeQuery(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				// Etape 5 : libérer ressources de la mémoire
				ddb.cn.close();
				ddb.st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
