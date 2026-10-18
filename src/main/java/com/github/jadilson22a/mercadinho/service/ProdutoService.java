package com.github.jadilson22a.mercadinho.service;

import java.util.List;
import java.util.Optional;

import javax.swing.SwingUtilities;

import com.github.jadilson22a.mercadinho.data.ProdutoDAO;
import com.github.jadilson22a.mercadinho.entities.ProdutoInterface;
import com.github.jadilson22a.mercadinho.model.Produto;
import com.github.jadilson22a.mercadinho.view.ErroView;

public class ProdutoService {
	
	private final static ProdutoDAO dao = new ProdutoDAO();
	
	public static void salvar(ProdutoInterface produto) {
		validar(produto);
		dao.salvar(produto);
	}
	
	public static void atualizar(long id, ProdutoInterface produto) {
		validar(produto);
		dao.atualizar(id, produto);
	}
	
	public static List<ProdutoInterface> buscarTudo() {
		return dao.findAll();
	}
	
	public static ProdutoInterface buscarID(long id) {
		return dao.findById(id);
	}
	
	public static void excluir(long id) {
		dao.excluir(id);
	}
	
	private static void validar(ProdutoInterface produto) {
		Optional<ProdutoInterface> produtoEncontrado = 
				Optional.ofNullable(dao.findByNome(produto.getNome()));
		
		if (produtoEncontrado.isPresent()) {
			SwingUtilities.invokeLater(() -> {new ErroView("Produto Existente!");});
		}
		
	}
	
	public static void finalizarConexao() {
		dao.finalizarConexao();
	}

}
