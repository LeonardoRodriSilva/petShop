package com.example.petShop.controller;

import com.example.petShop.Service.AnimalService;
import com.example.petShop.entity.Animal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public List<Animal> listarTodos() {
        return animalService.listarTodos();
    }

    @PostMapping
    public Animal salvar(@RequestBody Animal animal) {
        return animalService.salvar(animal);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> buscarPorId(@PathVariable String id) {
        return animalService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Animal salvar(@PathVariable String id, @RequestBody Animal animalAtualizado) {
        return animalService.atualizar(id, animalAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        animalService.deletar(id);
        return ResponseEntity.noContent().build();
    }



}
