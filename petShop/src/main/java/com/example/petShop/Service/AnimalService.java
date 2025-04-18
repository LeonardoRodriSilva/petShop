package com.example.petShop.Service;

import com.example.petShop.entity.Animal;
import com.example.petShop.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> listarTodos() {
        return animalRepository.findAll();
    }

    public Animal salvar(Animal animal) {
        return animalRepository.save(animal);
    }

    public Optional<Animal> buscarPorId(String id) {
        return animalRepository.findById(id);
    }

    public void deletar(String id) {
        animalRepository.deleteById(id);
    }

    public Animal atualizar(String id, Animal animal) {
        if (animalRepository.existsById(id)) {
            animal.setNome(animal.getNome());
            animal.setAbrigoId(animal.getAbrigoId());
            animal.setSituacao(animal.getSituacao());
            animal.setDisponivel(animal.getDisponivel());
            return animalRepository.save(animal);
        } else {
            return null;
        }
    }
}
