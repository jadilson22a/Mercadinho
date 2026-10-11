package com.github.jadilson22a.mercadinho.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class Conexao {

	private final static Dotenv dotenv = Dotenv.load();
	private final static String username = dotenv.get("DB_USERNAME");
	private final static String password = dotenv.get("DB_PASSWORD");
	private final static String url = dotenv.get("DB_URL");
	
	public static Connection conectar() {
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
