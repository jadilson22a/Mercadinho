package org.example.dao;

import org.example.connection.ConexaoDB;
import org.example.entities.Mercadoria;
import org.example.entities.UnidadeMedida;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    //BuscarID
    public static Mercadoria buscarId(int id){
        String sql = "select * from mercadorias where id = ?";

        try(Connection conn = ConexaoDB.conexao();
        PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                String codigo = rs.getString("codigo");
                Double preco = rs.getDouble("preco");
                Double quantidade = rs.getDouble("quantidade");
                String umSigla = rs.getString("unidadeMedida");

                return new Mercadoria(id, nome, codigo, preco, quantidade, UnidadeMedida.getEnum(umSigla));
            }

            return null;
        }catch (SQLException e){throw new RuntimeException(e);}
    }

    //Buscar por nome
    public static List<Mercadoria> buscarNome(String nome){
        String sql = "select * from mercadorias where nome = ?";

        try(Connection conn = ConexaoDB.conexao();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, nome);

            ResultSet rs = ps.executeQuery();

            List<Mercadoria> mercadorias= new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt("id");
                String codigo = rs.getString("codigo");
                Double preco = rs.getDouble("preco");
                Double quantidade = rs.getDouble("quantidade");
                String umSigla = rs.getString("unidadeMedida");

                mercadorias.add(
                        new Mercadoria(id, nome, codigo, preco, quantidade, UnidadeMedida.getEnum(umSigla))
                );
            }

            return mercadorias;

        }catch (SQLException e){throw new RuntimeException(e);}
    }
}
