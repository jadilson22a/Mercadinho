package org.example.models;

import org.example.entities.UnidadeMedida;

public class Mercadoria {

    private int id;
    private String nome;
    private String codigo;
    private Double custo;
    private Double preco;
    private Double quantidade;
    private UnidadeMedida unidadeMedida;

    public Mercadoria(String nome, String codigo, Double custo, Double preco, Double quantidade, UnidadeMedida unidadeMedida) {
        this.nome = nome;
        this.codigo = codigo;
        this.custo = custo;
        this.preco = preco;
        this.quantidade = quantidade;
        this.unidadeMedida = unidadeMedida;
    }

    public Mercadoria(int id, String nome, String codigo, Double custo, Double preco, Double quantidade, UnidadeMedida unidadeMedida) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.custo = custo;
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

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        result = prime * result + ((custo == null) ? 0 : custo.hashCode());
        result = prime * result + ((preco == null) ? 0 : preco.hashCode());
        result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
        result = prime * result + ((unidadeMedida == null) ? 0 : unidadeMedida.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Mercadoria other = (Mercadoria) obj;
        if (id != other.id)
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        if (custo == null) {
            if (other.custo != null)
                return false;
        } else if (!custo.equals(other.custo))
            return false;
        if (preco == null) {
            if (other.preco != null)
                return false;
        } else if (!preco.equals(other.preco))
            return false;
        if (quantidade == null) {
            if (other.quantidade != null)
                return false;
        } else if (!quantidade.equals(other.quantidade))
            return false;
        if (unidadeMedida != other.unidadeMedida)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Mercadoria [id=" + id + ", nome=" + nome + ", codigo=" + codigo + ", custo=" + custo + ", preco="
                + preco + ", quantidade=" + quantidade + ", unidadeMedida=" + unidadeMedida + "]";
    }

    
}
