package com.example.petShop.controller;


import com.example.petShop.DTO.request.TutorRequests.AtualizarTutorRequest;
import com.example.petShop.DTO.request.TutorRequests.CriarTutorRequest;
import com.example.petShop.DTO.response.Tutor.TutorResponse;
import com.example.petShop.Service.TutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutores")
public class TutorController {

    private TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping
    public List<TutorResponse> listarTodos() { return tutorService.listarTodos(); }

    @PostMapping
    public ResponseEntity<TutorResponse> salvar(@RequestBody CriarTutorRequest request) {
        TutorResponse response = tutorService.salvar(request);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TutorResponse> buscarPorId(String id) {
        return tutorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TutorResponse> atualizar(@PathVariable String id, @RequestBody AtualizarTutorRequest request) {
        TutorResponse response = tutorService.atualizar(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        tutorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
