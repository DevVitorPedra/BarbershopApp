package com.example.cadastroclientes;

import android.graphics.Bitmap;
import android.media.Image;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.sql.Blob;

public class Cliente implements Serializable {
    private Integer Id;
    private String Nome;
    private String Telefone;
    private String Bairro;
    private String Lazer;
    private String Obs;
    private String Data;
    private String Topete;
    private String Topo;
    private String Lateral;
    private String Textura;
    private String Encaixe;
    private String Acabamento;
    private String Taper;
    private String Observacao;


    public Image getImagem() {
        return imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    private Image imagem;


    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public String getTopete() {
        return Topete;
    }

    public void setTopete(String topete) {
        Topete = topete;
    }

    public String getTopo() {
        return Topo;
    }

    public void setTopo(String topo) {
        Topo = topo;
    }

    public String getLateral() {
        return Lateral;
    }

    public void setLateral(String lateral) {
        Lateral = lateral;
    }

    public String getTextura() {
        return Textura;
    }

    public void setTextura(String textura) {
        Textura = textura;
    }

    public String getEncaixe() {
        return Encaixe;
    }

    public void setEncaixe(String encaixe) {
        Encaixe = encaixe;
    }

    public String getAcabamento() {
        return Acabamento;
    }

    public void setAcabamento(String acabamento) {
        Acabamento = acabamento;
    }

    public String getTaper() {
        return Taper;
    }

    public void setTaper(String taper) {
        Taper = taper;
    }

    public String getObservacao() {
        return Observacao;
    }

    public void setObservacao(String observacao) {
        Observacao = observacao;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        Bairro = bairro;
    }

    public String getLazer() {
        return Lazer;
    }

    public void setLazer(String lazer) {
        Lazer = lazer;
    }

    public String getObs() {
        return Obs;
    }

    public void setObs(String obs) {
        Obs = obs;
    }
    public String toString(){
        return Nome;
    }
}
