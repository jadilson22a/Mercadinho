package org.example;

import org.example.connection.ConexaoDB;
import org.example.dao.MercadoriaDAO;
import org.example.entities.Mercadoria;
import org.example.entities.UnidadeMedida;

import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Mercadoria mercadoria = new Mercadoria(
                "banana",
                "123455",
                2.50,
                1.00,
                UnidadeMedida.UNIDADE);

        MercadoriaDAO.inserir(mercadoria);
    }
}