package com.github.jadilson22a.mercadinho.service;

import java.util.List;
import java.util.Optional;

import com.github.jadilson22a.mercadinho.model.Produto;
import com.github.jadilson22a.mercadinho.model.ProdutoDAO;

public class ProdutoService {
	
	public static void salvar(Produto produto) {
		validar(produto);
		ProdutoDAO.salvar(produto);
	}
	
	public static void atualizar(long id, Produto produto) {
		validar(produto);
		ProdutoDAO.atualizar(id, produto);
	}
	
	public static List<Produto> buscarTudo() {
		return ProdutoDAO.findAll();
	}
	
	public static Produto buscarID(long id) {
		return ProdutoDAO.findById(id);
	}
	
	public static void excluir(long id) {
		ProdutoDAO.excluir(id);
	}
	
	private static void validar(Produto produto) {
		Optional<Produto> produtoEncontrado = 
				Optional.ofNullable(ProdutoDAO.findByNome(produto.getNome()));
		
		if (produtoEncontrado.isPresent()) {
			throw new RuntimeException("Esse produto ja existe!");
		}
		
	}

}
