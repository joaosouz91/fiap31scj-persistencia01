package br.com.fiap.joao.persistencia01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Set;
import java.sql.DriverManager;

public abstract class Dao<T> {
	
	protected Connection cn;
	protected PreparedStatement stmt;
	protected ResultSet rs;

	private String connString = "jdbc:mysql://localhost:3306/dbescola";
	
	public void openConnection() throws Exception {
		
		//especificação do driver de acesso
		Class.forName("com.mysql.jdbc.Driver");
		
		//abertura da conexão
		cn = DriverManager.getConnection(connString, "root", "fiap");
	}
	
	public void closeConnection() throws Exception {
		if(cn != null && !cn.isClosed()) {
			cn.close();
		}
	}
	
	public abstract void include(T elemento) throws Exception;
	public abstract T find(int id) throws Exception;
	public abstract Set<T> list(int... param) throws Exception;
	
}
