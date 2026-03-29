package org.example.entities;

import java.util.Objects;

public class Mercadoria {

    private int id;
    private String nome;
    private String codigo;
    private Double preco;
    private Double quantidade;
    private UnidadeMedida unidadeMedida;

    public Mercadoria(String nome, String codigo, Double preco, Double quantidade, UnidadeMedida unidadeMedida) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidade = quantidade;
        this.unidadeMedida = unidadeMedida;
    }

    public Mercadoria(int id, String nome, String codigo, Double preco, Double quantidade, UnidadeMedida unidadeMedida) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidade = quantidade;
        this.unidadeMedida = unidadeMedida;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Mercadoria that = (Mercadoria) o;
        return id == that.id && Objects.equals(nome, that.nome) && Objects.equals(codigo, that.codigo) && Objects.equals(preco, that.preco) && unidadeMedida == that.unidadeMedida;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, codigo, preco, unidadeMedida);
    }

    @Override
    public String toString() {
        return "Mercadoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", codigo='" + codigo + '\'' +
                ", preco=" + preco +
                ", unidadeMedida=" + unidadeMedida +
                '}';
    }
}
