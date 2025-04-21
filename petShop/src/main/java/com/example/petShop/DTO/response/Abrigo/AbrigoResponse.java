package com.example.petShop.DTO.response.Abrigo;

public class AbrigoResponse {
    private String id;
    private String responsavel;
    private Long capacidadeTotal;
    private String localizacao;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
