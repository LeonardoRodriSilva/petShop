package com.example.petShop.repository;

import com.example.petShop.entity.Voluntario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VoluntarioRepository extends MongoRepository<Voluntario, String> {
    // Adicionar métodos de consulta personalizados, se necessário
}
