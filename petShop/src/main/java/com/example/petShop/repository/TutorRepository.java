package com.example.petShop.repository;

import com.example.petShop.entity.Tutor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TutorRepository extends MongoRepository<Tutor, String> {
    // Adicionar métodos de consulta personalizados, se necessário
}
