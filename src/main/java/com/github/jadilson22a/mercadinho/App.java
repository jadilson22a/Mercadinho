package com.github.jadilson22a.mercadinho;

import com.github.jadilson22a.mercadinho.data.Conexao;
import com.github.jadilson22a.mercadinho.model.Produto;
import com.github.jadilson22a.mercadinho.model.ProdutoDAO;
import com.github.jadilson22a.mercadinho.model.ProdutoEx;
import com.github.jadilson22a.mercadinho.model.ProdutoIn;
import com.github.jadilson22a.mercadinho.model.UnidadeMedida;
import com.github.jadilson22a.mercadinho.service.ProdutoService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
    	Produto produto = new ProdutoIn("Banana", 5.0, UnidadeMedida.kg, "1234");
    	Produto produto2 = new ProdutoEx("energetico", 15.0, UnidadeMedida.un, "1234567891011");
    	
	    Conexao.conectar();
	    ProdutoService.salvar(produto);
	    ProdutoService.salvar(produto2);
	    System.out.println("Produtos salvos!");
	    ProdutoService.buscarTudo().forEach(System.out::println);;
	    ProdutoService.finalizarConexao();
    }
}
