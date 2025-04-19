package com.example.petShop.DTO.response;

import java.time.LocalDate;

public class AnimalResponse {
    private String id;
    private String especie;
    private String raca;
    private String situacao;
    private String porte;
    private LocalDate dataNascimento;
    private Boolean disponivelParaAdocao;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Boolean getDisponivelParaAdocao() {
        return disponivelParaAdocao;
    }

    public void setDisponivelParaAdocao(Boolean disponivelParaAdocao) {
        this.disponivelParaAdocao = disponivelParaAdocao;
    }
}
