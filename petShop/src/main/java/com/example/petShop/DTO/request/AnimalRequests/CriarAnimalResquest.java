package com.example.petShop.DTO.request.AnimalRequests;

import java.time.LocalDate;

public class CriarAnimalResquest {
    private String especie;
    private String raca;
    private String situacao;
    private String porte;
    private LocalDate dataNascimento;
    private Boolean disponivelParaAdocao;

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
