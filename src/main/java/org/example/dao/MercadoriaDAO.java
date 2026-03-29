package org.example.dao;

import org.example.connection.ConexaoDB;
import org.example.entities.Mercadoria;
import org.example.entities.UnidadeMedida;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MercadoriaDAO {

    //Inserir
    public static void inserir(Mercadoria mercadoria){
        String sql = "INSERT INTO `mercadinho`.`mercadorias` " +
                "(`nome`, `codigo`, `preco`, `quantidade`, `unidadeMedida`) " +
                "VALUES (?, ?, ?, ?, ?);";

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
    public static void atualizar(int id, Mercadoria mercadoria){
        String sql = "UPDATE `mercadinho`.`mercadorias` " +
                "SET `nome` = ?, " +
                "`codigo` = ?, " +
                "`preco` = ?, " +
                "`quantidade` = ?, " +
                "`unidadeMedida` = ?" +
                "WHERE (`id` = ?);";

        try (Connection conn = ConexaoDB.conexao();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, mercadoria.getNome());
            ps.setString(2, mercadoria.getCodigo());
            ps.setDouble(3,mercadoria.getPreco());
            ps.setDouble(4, mercadoria.getQuantidade());
            ps.setString(5, mercadoria.getUnidadeMedida().getSigla());
            ps.setInt(6, id);

            ps.executeUpdate();

        } catch (SQLException e) {throw new RuntimeException(e);}

    }

    //Deletar
    public static void deletar(int id){

        String sql = "DELETE FROM `mercadinho`.`mercadorias` WHERE (`id` = ?);";

        try(Connection conn = ConexaoDB.conexao();
        PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, id);
            ps.executeUpdate();

        }catch (SQLException e){throw new RuntimeException(e);}
    }

    public static Mercadoria buscarId(int id){
        String sql = "select * from mercadinho where id = ?";

        try(Connection conn = ConexaoDB.conexao();
        PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            String nome = rs.getString("nome");
            String codigo = rs.getString("codigo");
            Double preco = rs.getDouble("preco");
            Double quantidade = rs.getDouble("quantidade");
            String umSigla = rs.getString("unidadeMedida");

            return new Mercadoria(id,nome,codigo,preco,quantidade,UnidadeMedida.getEnum(umSigla));

        }catch (SQLException e){throw new RuntimeException(e);}
    }
}
