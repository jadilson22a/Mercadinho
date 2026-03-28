package org.example.connection;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    // Inicia a variavel de ambiente
    private static final Dotenv env = Dotenv.load();
    private static final String url = env.get("DB_URL");
    private static final String user = env.get("DB_USER");
    private static final String password = env.get("DB_PASSWORD");

    public static Connection conexao() throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }
}
