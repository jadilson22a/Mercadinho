package com.github.jadilson22a.mercadinho.model;

import java.util.Objects;

import com.github.jadilson22a.mercadinho.entities.UnidadeMedida;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("INTERNO")
public class ProdutoIn extends Produto{

	@Column(name = "sku", length = 4)
	private String sku;

	public ProdutoIn(long id, String nome, Double quantidade, UnidadeMedida um, Double valor, String sku) {
		super(id, nome, quantidade, um, valor);
		this.sku = sku;
	}

	public ProdutoIn(String nome, Double quantidade, UnidadeMedida um, Double valor, String sku) {
		super(nome, quantidade, um, valor);
		this.sku = sku;
	}

	public ProdutoIn() {
	}

	public String getCodigo() {
		return sku;
	}

	public void setCodigo(String sku) {
		this.sku = sku;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(sku);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoIn other = (ProdutoIn) obj;
		return Objects.equals(sku, other.sku);
	}

	@Override
	public String toString() {
		return "ProdutoIn [sku=" + sku + ", id=" + getId() + ", nome=" + getNome() + ", quantidade="
				+ getQuantidade() + ", unidadeMedida=" + getUm() + "]";
	}

	
}
