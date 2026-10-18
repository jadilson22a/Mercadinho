package com.github.jadilson22a.mercadinho.model;

import java.util.List;

import com.github.jadilson22a.mercadinho.entities.PagamentoInterface;

public class Compra {

	private List<Produto> produtos;
	private Double valorTotal;
	private PagamentoInterface formaPagamento;
	private String cpf;
	
	public Compra(
			List<Produto> produtos, 
			PagamentoInterface 
			formaPagamento, 
			String cpf) {
		this.produtos = produtos;
		this.formaPagamento = formaPagamento;
		this.cpf = cpf;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public void somaValor() {
		Double valor = 0.0;
		
		for(Produto x: this.produtos) {
			valor += x.getValor();
		}
		
	}
	
}
