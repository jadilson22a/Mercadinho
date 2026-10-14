package com.github.jadilson22a.mercadinho.model;

public interface ProdutoInterface {
	String getCodigo();
    void setCodigo(String codigo);

    String getNome();
    void setNome(String nome);

    Double getQuantidade();
    void setQuantidade(Double quantidade);

    UnidadeMedida getUm();
    void setUm(UnidadeMedida um);
}
