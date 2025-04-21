package com.example.petShop.repository;

import com.example.petShop.entity.Abrigo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AbrigoRepository extends MongoRepository <Abrigo, String> {
    // Métodos adicionais de consulta podem ser definidos aqui, se necessário
}
