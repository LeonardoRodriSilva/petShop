package com.example.petShop.DTO.request.AbrigoRequests;

public class CriarAbrigoRequest {
    private String responsavel;
    private Long capacidadeTotal;
    private String localizacao;

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Long getCapacidadeTotal() {
        return capacidadeTotal;
    }

    public void setCapacidadeTotal(Long capacidadeTotal) {
        this.capacidadeTotal = capacidadeTotal;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
