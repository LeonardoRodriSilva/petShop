package com.example.petShop.DTO.request.VoluntarioRequests;

import com.example.petShop.entity.Funcao;

import java.time.LocalDate;
import java.util.List;

public class AtualizarVoluntarioRequest {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String localizacao;
    private List<Funcao> funcoes;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public List<Funcao> getFuncoes() {
        return funcoes;
    }

    public void setFuncoes(List<Funcao> funcoes) {
        this.funcoes = funcoes;
    }
}
