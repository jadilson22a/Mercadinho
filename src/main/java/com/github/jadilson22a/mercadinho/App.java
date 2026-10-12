package com.github.jadilson22a.mercadinho;

import com.github.jadilson22a.mercadinho.data.Conexao;
import com.github.jadilson22a.mercadinho.model.Produto;
import com.github.jadilson22a.mercadinho.model.ProdutoDAO;
import com.github.jadilson22a.mercadinho.model.UnidadeMedida;
import com.github.jadilson22a.mercadinho.service.ProdutoService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
    	Produto produto = new Produto("sabao", 5.0, UnidadeMedida.un);
    	
	    Conexao.conectar();
	    ProdutoService.salvar(produto);
	    System.out.println("Produto salvo!");
	    ProdutoService.salvar(produto);
	    ProdutoService.buscarTudo().forEach(System.out::println);;
    }
}
