package com.example.cadastroclientes;

import java.io.Serializable;

public class Producao extends Controle implements Serializable {
    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    private String hora;

    private String  servicoFeito;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;


    public String getServicoFeito() {
        return servicoFeito;
    }

    public void setServicoFeito(String servicoFeito) {
        this.servicoFeito = servicoFeito;
    }
}
