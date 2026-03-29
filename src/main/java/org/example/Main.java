package org.example;

import org.example.dao.MercadoriaDAO;
import org.example.entities.UnidadeMedida;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String sigla = "MM";

        System.out.println(UnidadeMedida.getEnum(sigla));

    }
}