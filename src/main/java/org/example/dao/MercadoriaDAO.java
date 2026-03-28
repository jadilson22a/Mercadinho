package org.example.dao;

import org.example.connection.ConexaoDB;
import org.example.entities.Mercadoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MercadoriaDAO {

    //Inserir
    public static void inserir(Mercadoria mercadoria){
        String sql = "INSERT INTO `mercadinho`.`mercadorias` (`nome`, `codigo`, `preco`, `quantidade`, `unidadeMedida`) VALUES (?, ?, ?, ?, ?);";

        try (Connection conn = ConexaoDB.conexao();
        PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, mercadoria.getNome());
            ps.setString(2, mercadoria.getCodigo());
            ps.setDouble(3,mercadoria.getPreco());
            ps.setDouble(4, mercadoria.getQuantidade());
            ps.setString(5, mercadoria.getUnidadeMedida().getSigla());

            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Atualizar
    //Deletar
}
