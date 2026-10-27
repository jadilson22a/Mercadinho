package com.github.jadilson22a.mercadinho;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import com.github.jadilson22a.mercadinho.data.Conexao;
import com.github.jadilson22a.mercadinho.data.ProdutoDAO;
import com.github.jadilson22a.mercadinho.entities.UnidadeMedida;
import com.github.jadilson22a.mercadinho.model.Produto;
import com.github.jadilson22a.mercadinho.model.ProdutoEx;
import com.github.jadilson22a.mercadinho.model.ProdutoIn;
import com.github.jadilson22a.mercadinho.service.ProdutoService;
import com.github.jadilson22a.mercadinho.view.FormularioGenerico;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
    	
    	List<String> labels = new ArrayList<String>();
    	labels.add("Label 1:  ");
    	labels.add("Label 2:  ");
    	labels.add("Label 3:  ");
    	labels.add("Label 4:  ");
    	labels.add("Label 5:  ");
    	labels.add("Label 6:  ");
    	labels.add("Label 7:  ");
    	labels.add("Label 8:  ");
    	
    	SwingUtilities.invokeLater(() -> {new FormularioGenerico(labels);});
    }
}
