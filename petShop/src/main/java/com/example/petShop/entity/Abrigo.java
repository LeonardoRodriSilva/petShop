package com.example.petShop.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "abrigos")
public class Abrigo {
    @Id
    private String id;
    private String responsavel;
    private Long capacidadeTotal;
    private String localizacao;
}
