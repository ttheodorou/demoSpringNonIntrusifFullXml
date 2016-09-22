package com.objis.demoArchiJdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DaoDataBase {
	String url = "jdbc:mysql://localhost/formation";
	String login = "root";
	String passwd = "";
	Connection cn = null;
	Statement st = null;
	ResultSet rs = null;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Connection getCn() {
		return cn;
	}

	public void setCn(Connection cn) {
		this.cn = cn;
	}

	public Statement getSt() {
		return st;
	}

	public void setSt(Statement st) {
		this.st = st;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public DaoDataBase(String url, String login, String passwd, Connection cn, Statement st, ResultSet rs) {
		super();
		this.url = url;
		this.login = login;
		this.passwd = passwd;
		this.cn = cn;
		this.st = st;
		this.rs = rs;
	}

	public DaoDataBase() {
		super();
	}

}
