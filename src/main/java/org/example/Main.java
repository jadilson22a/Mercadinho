package org.example;

import org.example.dao.MercadoriaDAO;
import org.example.entities.Mercadoria;
import org.example.entities.UnidadeMedida;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Busca por ID: " + MercadoriaDAO.buscarId(1));

        System.out.println("Busca por nome: " + MercadoriaDAO.buscarNome("morango"));

    }
}