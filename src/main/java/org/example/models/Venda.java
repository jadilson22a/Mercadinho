package org.example.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Venda { //ve se da pra melhorar essa bosta, ja são 01:38 da manha

    private Integer id;
    private String cpf;
    private LocalDate data;
    private LocalTime hora;
    private String mercadorias;
    
    public Venda(Integer id, String cpf, LocalDate data, LocalTime hora, String mercadorias) {
        this.id = id;
        this.cpf = cpf;
        this.data = data;
        this.hora = hora;
        this.mercadorias = mercadorias;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMercadorias() {
        return mercadorias;
    }

    public void setMercadorias(String mercadorias) {
        this.mercadorias = mercadorias;
    }

    

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Venda [id=" + id + ", cpf=" + cpf + ", data=" + data + ", hora=" + hora + ", mercadorias=" + mercadorias
                + "]";
    }


}
