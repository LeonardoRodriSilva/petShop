package com.example.petShop.Service;

import com.example.petShop.DTO.request.AbrigoRequests.AtualizarAbrigoRequest;
import com.example.petShop.DTO.request.AbrigoRequests.CriarAbrigoRequest;
import com.example.petShop.DTO.response.Abrigo.AbrigoResponse;
import com.example.petShop.entity.Abrigo;
import com.example.petShop.repository.AbrigoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AbrigoService {

    private final AbrigoRepository abrigoRepository;

    public AbrigoService(AbrigoRepository abrigoRepository) {
        this.abrigoRepository = abrigoRepository;
    }

    public List<AbrigoResponse> ListarTodos() {
        return abrigoRepository.findAll().stream()
                .map(this::converterParaResponse)
                .collect(Collectors.toList());
    }

    public AbrigoResponse salvar(CriarAbrigoRequest request) {
        Abrigo abrigo = converterParaEntidade(request);
        Abrigo abrigoSalvo = abrigoRepository.save(abrigo);
        return converterParaResponse(abrigoSalvo);
    }

    public Optional<AbrigoResponse> buscarPorId(String id) {
        return abrigoRepository.findById(id)
                .map(this::converterParaResponse);
    }

    public AbrigoResponse atualizar(String id, AtualizarAbrigoRequest request) {
        return abrigoRepository.findById(id)
                .map(abrigoExistente -> {
                    atualizarEntidade(abrigoExistente, request);
                    Abrigo abrigoAtualizado = abrigoRepository.save(abrigoExistente);
                    return converterParaResponse(abrigoAtualizado);
                })
                .orElseThrow(() -> new RuntimeException("Abrigo não encontrado com o ID: " + id));
    }

    public void deletar(String id) {
        if (!abrigoRepository.existsById(id)) {
            throw new RuntimeException("Abrigo não encontrado com o ID: " + id);
        }
        abrigoRepository.deleteById(id);
    }

    private AbrigoResponse converterParaResponse(Abrigo abrigo) {
        AbrigoResponse abrigoResponse = new AbrigoResponse();
        abrigoResponse.setId(abrigo.getId());
        abrigoResponse.setResponsavel(abrigo.getResponsavel());
        abrigoResponse.setCapacidadeTotal(abrigo.getCapacidadeTotal());
        abrigoResponse.setLocalizacao(abrigo.getLocalizacao());
        return abrigoResponse;
    }

    private void atualizarEntidade(Abrigo abrigo, AtualizarAbrigoRequest request) {
        abrigo.setResponsavel(request.getResponsavel());
        abrigo.setCapacidadeTotal(request.getCapacidadeTotal());
        abrigo.setLocalizacao(request.getLocalizacao());
    }

    private Abrigo converterParaEntidade(CriarAbrigoRequest request) {
        Abrigo abrigo = new Abrigo();
        abrigo.setResponsavel(request.getResponsavel());
        abrigo.setCapacidadeTotal(request.getCapacidadeTotal());
        abrigo.setLocalizacao(request.getLocalizacao());
        return abrigo;
    }
}
