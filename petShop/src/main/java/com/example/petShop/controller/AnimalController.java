package com.example.petShop.controller;

import com.example.petShop.DTO.request.AnimalRequests.AtualizarAnimalRequest;
import com.example.petShop.DTO.request.AnimalRequests.CriarAnimalResquest;
import com.example.petShop.DTO.response.Animal.AnimalResponse;
import com.example.petShop.Service.AnimalService;
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
    public List<AnimalResponse> listarTodos() {
        return animalService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<AnimalResponse> salvar(@RequestBody CriarAnimalResquest resquest) {
        AnimalResponse response = animalService.salvar(resquest);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalResponse> buscarPorId(@PathVariable String id) {
        return animalService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimalResponse> atualizar(@PathVariable String id, @RequestBody AtualizarAnimalRequest request) {
        AnimalResponse response = animalService.atualizar(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        animalService.deletar(id);
        return ResponseEntity.noContent().build();
    }



}
