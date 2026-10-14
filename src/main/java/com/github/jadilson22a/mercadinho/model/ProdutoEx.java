package com.github.jadilson22a.mercadinho.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("EXTERNO")
public class ProdutoEx extends Produto{
	
	/* EAN-13 */
	@Column(name = "ean", length = 13)
	private String ean;

	public ProdutoEx(long id, String nome, Double quantidade, UnidadeMedida um, String ean) {
		super(id, nome, quantidade, um);
		this.ean = ean;
	}

	public ProdutoEx(String nome, Double quantidade, UnidadeMedida um, String ean) {
		super(nome, quantidade, um);
		this.ean = ean;
	}

	public ProdutoEx() {
		
	}

	public String getCodigo() {
		return this.ean;
	}

	public void setCodigo(String ean) {
		this.ean = ean;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(ean);
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
		ProdutoEx other = (ProdutoEx) obj;
		return ean == other.ean;
	}
	
	@Override
	public String toString() {
		return "ProdutoEx [ean=" + this.ean + ", id=" + getId() + ", nome=" + getNome() + ", quantidade="
				+ getQuantidade() + ", unidadeMedida=" + getUm() + "]";
	}

}
