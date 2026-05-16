package org.example;

import java.util.List;

import org.example.dao.MercadoriaDAO;
import org.example.entities.Mercadoria;
import org.example.entities.UnidadeMedida;

public class MainTests {
    
    public static void executar(){


        try {
            // testando CRUD mercadoria
            MercadoriaDAO.inserir(new Mercadoria("teste", "123456", 25.90, 12.00, UnidadeMedida.PACOTE));
            List<Mercadoria> mercadorias = MercadoriaDAO.buscarNome("teste");
            mercadorias.forEach(x -> MercadoriaDAO.deletar(x.getId()));

            System.out.println("Teste de crud concluido ✔️");
        } catch (Exception e) {
            System.out.println("Erro de teste!");
        }
        

    }

}
