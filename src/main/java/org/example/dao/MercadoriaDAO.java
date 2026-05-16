package org.example.dao;

import org.example.connection.ConexaoDB;
import org.example.entities.UnidadeMedida;
import org.example.models.Mercadoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//toda vez que add um novo campo na entidade tem que ajustar essa merda
//fazer uma oração e tentar criar polimorfismo nessa b0st@
public class MercadoriaDAO { 

    //Inserir
    public static void inserir(Mercadoria mercadoria){
        String sql = "INSERT INTO `loja`.`mercadoria` " +
                "(`nome`, `codigo`, `custo`, `preco`, `quantidade`, `unidade_medida`) " +
                "VALUES (?, ?, ?, ?, ?, ?);";

        try (Connection conn = ConexaoDB.conexao();
        PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, mercadoria.getNome());
            ps.setString(2, mercadoria.getCodigo());
            ps.setDouble(3, mercadoria.getCusto());
            ps.setDouble(4, mercadoria.getPreco());
            ps.setDouble(5, mercadoria.getQuantidade());
            ps.setString(6, mercadoria.getUnidadeMedida().getSigla());

            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Atualizar
    public static void atualizar(int id, Mercadoria mercadoria){
        String sql = "UPDATE `loja`.`mercadoria` " +
                "SET `nome` = ?, " +
                "`codigo` = ?, " +
                "`custo` = ?, " +
                "`preco` = ?, " +
                "`quantidade` = ?, " +
                "`unidade_medida` = ?" +
                "WHERE (`id` = ?);";

        try (Connection conn = ConexaoDB.conexao();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, mercadoria.getNome());
            ps.setString(2, mercadoria.getCodigo());
            ps.setDouble(3, mercadoria.getCusto());
            ps.setDouble(4, mercadoria.getPreco());
            ps.setDouble(5, mercadoria.getQuantidade());
            ps.setString(6, mercadoria.getUnidadeMedida().getSigla());
            ps.setInt(7, id);

            ps.executeUpdate();

        } catch (SQLException e) {throw new RuntimeException(e);}

    }

    //Deletar
    public static void deletar(int id){

        String sql = "DELETE FROM `loja`.`mercadoria` WHERE (`id` = ?);";

        try(Connection conn = ConexaoDB.conexao();
        PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, id);
            ps.executeUpdate();

        }catch (SQLException e){throw new RuntimeException(e);}
    }

    //BuscarID
    public static Mercadoria buscarId(int id){
        String sql = "select * from mercadoria where id = ?";

        try(Connection conn = ConexaoDB.conexao();
        PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                String codigo = rs.getString("codigo");
                Double custo = rs.getDouble("custo");
                Double preco = rs.getDouble("preco");
                Double quantidade = rs.getDouble("quantidade");
                String umSigla = rs.getString("unidade_medida");

                return new Mercadoria(id, nome, codigo, custo, preco, quantidade, UnidadeMedida.getEnum(umSigla));
            }

            return null;
        }catch (SQLException e){throw new RuntimeException(e);}
    }

    //Buscar Codigo
    public static Mercadoria buscarCodigo(String codigo){
        String sql = "select * from mercadoria where codigo = ?";

        try(Connection conn = ConexaoDB.conexao();
        PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, codigo);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Integer id = rs.getInt("id");
                String nome = rs.getString("nome");
                Double custo = rs.getDouble("custo");
                Double preco = rs.getDouble("preco");
                Double quantidade = rs.getDouble("quantidade");
                String umSigla = rs.getString("unidade_medida");

                return new Mercadoria(id, nome, codigo, custo, preco, quantidade, UnidadeMedida.getEnum(umSigla));
            }

            return null;
        }catch (SQLException e){throw new RuntimeException(e);}
    }

    //Buscar por nome
    public static List<Mercadoria> buscarNome(String nome){
        String sql = "select * from mercadoria where nome = ?";

        try(Connection conn = ConexaoDB.conexao();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, nome);

            ResultSet rs = ps.executeQuery();

            List<Mercadoria> mercadorias= new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt("id");
                String codigo = rs.getString("codigo");
                Double custo = rs.getDouble("custo");
                Double preco = rs.getDouble("preco");
                Double quantidade = rs.getDouble("quantidade");
                String umSigla = rs.getString("unidade_medida");

                mercadorias.add(
                        new Mercadoria(id, nome, codigo, custo, preco, quantidade, UnidadeMedida.getEnum(umSigla))
                );
            }

            return mercadorias;

        }catch (SQLException e){throw new RuntimeException(e);}
    }
}
