package com.github.jadilson22a.mercadinho.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_produto")
public abstract class Produto implements ProdutoInterface{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "quantidade")
	private Double quantidade;
	
	@Column(name = "unidade_medida")
	@Enumerated(EnumType.STRING)
	private UnidadeMedida um;
	
	public Produto(long id, String nome, Double quantidade, UnidadeMedida um) {
			this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.um = um;
	}

	public Produto(String nome, Double quantidade, UnidadeMedida um) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.um = um;
	}
	
	public Produto() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public UnidadeMedida getUm() {
		return um;
	}

	public void setUm(UnidadeMedida um) {
		this.um = um;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Long.valueOf(id), nome, quantidade, um);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return id == other.id && Objects.equals(nome, other.nome) && Objects.equals(quantidade, other.quantidade)
				&& um == other.um;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", quantidade=" + quantidade + ", um=" + um + "]";
	}
	
	

}
