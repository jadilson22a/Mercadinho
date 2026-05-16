package org.example.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.example.connection.ConexaoDB;
import org.example.models.Venda;

public class VendaDAO { //Não testei sa porr@ ainda

    public static void salvar(Venda venda){
        String sql = "INSERT INTO `loja`.`vendas` " +
                "(`cpf`, `data`, `hora`, `mercadorias`) " +
                "VALUES (?, ?, ?, ?);";

        try(Connection conn = ConexaoDB.conexao();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, venda.getCpf());
            ps.setDate(2, Date.valueOf(venda.getData())); //Converte LocalDate em sql.Date
            ps.setTime(3, Time.valueOf(venda.getHora())); //Converte LocalDate em sql.Time
            ps.setString(5, venda.getMercadorias());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Venda> buscarCpf(String cpf){
        String sql = "select * from vendas where cpf = ?";

        try(Connection conn = ConexaoDB.conexao();
        PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, cpf);

            ResultSet rs = ps.executeQuery();

            List<Venda> vendas = new ArrayList<>();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                LocalDate data = LocalDate.parse(rs.getDate("data").toString());
                LocalTime hora = LocalTime.parse(rs.getTime("hora").toString());
                String mercadorias = rs.getString("mercadorias");

                vendas.add(new Venda(id, cpf, data, hora, mercadorias));
            }

            return vendas;
        }catch (SQLException e){throw new RuntimeException(e);}
    }

    public static List<Venda> buscarData(LocalDate data){
        String sql = "select * from vendas where data = ?";

        try(Connection conn = ConexaoDB.conexao();
        PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setDate(1, Date.valueOf(data));

            ResultSet rs = ps.executeQuery();

            List<Venda> vendas = new ArrayList<>();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String cpf = rs.getString("cpf");
                LocalTime hora = LocalTime.parse(rs.getTime("hora").toString());
                String mercadorias = rs.getString("mercadorias");

                vendas.add(new Venda(id, cpf, data, hora, mercadorias));
            }

            return vendas;
        }catch (SQLException e){throw new RuntimeException(e);}
    }

    public static Venda buscarId(Integer id){
        String sql = "select * from vendas where id = ?";

        try(Connection conn = ConexaoDB.conexao();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String cpf = rs.getString("cpf");
                LocalDate data = LocalDate.parse(rs.getDate("data").toString());
                LocalTime hora = LocalTime.parse(rs.getTime("hora").toString());
                String mercadorias = rs.getString("mercadorias");

                return new Venda(id, cpf, data, hora, mercadorias);
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
