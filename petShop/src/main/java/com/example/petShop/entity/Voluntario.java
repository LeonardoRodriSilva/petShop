package com.example.petShop.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "voluntarios")
public class Voluntario {
    @Id
    private String id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String localizacao;
    private List<Funcao> funcoes;

}
