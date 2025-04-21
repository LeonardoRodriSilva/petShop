package com.example.petShop.controller;


import com.example.petShop.DTO.request.AbrigoRequests.AtualizarAbrigoRequest;
import com.example.petShop.DTO.request.AbrigoRequests.CriarAbrigoRequest;
import com.example.petShop.DTO.response.Abrigo.AbrigoResponse;
import com.example.petShop.Service.AbrigoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abrigos")
public class AbrigoController {

    private final AbrigoService abrigoService;

    public AbrigoController(AbrigoService abrigoService) { this.abrigoService = abrigoService; }

    @GetMapping
    public List<AbrigoResponse> listarTodos() { return abrigoService.ListarTodos(); }

    @PostMapping
    public ResponseEntity<AbrigoResponse> salvar(@RequestBody CriarAbrigoRequest request) {
        AbrigoResponse response = abrigoService.salvar(request);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AbrigoResponse> buscarPorId(@PathVariable String id) {
        return abrigoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AbrigoResponse> atualizar(@PathVariable String id, @RequestBody AtualizarAbrigoRequest request) {
        AbrigoResponse response = abrigoService.atualizar(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        abrigoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
