package com.example.petShop.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "tutores")
public class Tutor {
    @Id
    private String id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String localizacao;

}
