package com.example.petShop.Service;

import com.example.petShop.DTO.request.AnimalRequests.AtualizarAnimalRequest;
import com.example.petShop.DTO.request.AnimalRequests.CriarAnimalResquest;
import com.example.petShop.DTO.response.Animal.AnimalResponse;
import com.example.petShop.entity.Animal;
import com.example.petShop.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<AnimalResponse> listarTodos() {
        return animalRepository.findAll().stream()
                .map(this::converterParaResponse)
                .collect(Collectors.toList());
    }

    public AnimalResponse salvar(CriarAnimalResquest request) {
        Animal animal = converterParaEntidade(request);
        Animal animalSalvo = animalRepository.save(animal);
        return converterParaResponse(animalSalvo);
    }

    public Optional<AnimalResponse> buscarPorId(String id) {
        return animalRepository.findById(id)
                .map(this::converterParaResponse);
    }

    public AnimalResponse atualizar(String id, AtualizarAnimalRequest request) {
        return animalRepository.findById(id)
                .map(animalExistente -> {
                    atualizarEntidade(animalExistente, request);
                    Animal animalAtualizado = animalRepository.save(animalExistente);
                    return converterParaResponse(animalAtualizado);
                })
                .orElseThrow(() -> new RuntimeException("Animal não encontrado com o ID: " + id));
    }

    public void deletar(String id) {
        if (!animalRepository.existsById(id)) {
            throw new RuntimeException("Animal não encontrado com o ID: " + id);
        }
        animalRepository.deleteById(id);
    }

    private Animal converterParaEntidade(CriarAnimalResquest request) {
        Animal animal = new Animal();
        animal.setEspecie(request.getEspecie());
        animal.setRaca(request.getRaca());
        animal.setDataNascimento(request.getDataNascimento());
        animal.setDisponivel(request.getDisponivelParaAdocao());
        return animal;
    }

    private void atualizarEntidade(Animal animal, AtualizarAnimalRequest request) {
        animal.setEspecie(request.getEspecie());
        animal.setRaca(request.getRaca());
        animal.setDataNascimento(request.getDataNascimento());
        animal.setDisponivel(request.getDisponivelParaAdocao());
    }

    private AnimalResponse converterParaResponse(Animal animal) {
        AnimalResponse response = new AnimalResponse();
        response.setId(animal.getId());
        response.setEspecie(animal.getEspecie());
        response.setRaca(animal.getRaca());
        response.setDataNascimento(animal.getDataNascimento());
        response.setDisponivelParaAdocao(animal.getDisponivel());
        return response;
    }
}