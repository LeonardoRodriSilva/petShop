package com.example.petShop.Service;

import com.example.petShop.DTO.request.VoluntarioRequests.AtualizarVoluntarioRequest;
import com.example.petShop.DTO.request.VoluntarioRequests.CriarVoluntarioRequest;
import com.example.petShop.DTO.response.Voluntario.VoluntarioResponse;
import com.example.petShop.entity.Voluntario;
import com.example.petShop.repository.VoluntarioRepository;
import org.springframework.data.repository.Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VoluntarioService {

    private final VoluntarioRepository voluntarioRepository;

    public VoluntarioService(VoluntarioRepository voluntarioRepository) {
        this.voluntarioRepository = voluntarioRepository;
    }

    public List<VoluntarioResponse> listarTodos() {
        return voluntarioRepository.findAll().stream()
                .map(this::converterParaResponse)
                .collect(Collectors.toList());
    }

    public VoluntarioResponse salvar(Voluntario voluntario) {
        Voluntario voluntarioSalvo = voluntarioRepository.save(voluntario);
        return converterParaResponse(voluntarioSalvo);
    }

    public VoluntarioResponse salvar(CriarVoluntarioRequest request) {
        Voluntario voluntario = converterParaEntidade(request);
        Voluntario voluntarioSalvo = voluntarioRepository.save(voluntario);
        return converterParaResponse(voluntarioSalvo);
    }

    public Optional<VoluntarioResponse> buscarPorId(String id) {
        return voluntarioRepository.findById(id)
                .map(this::converterParaResponse);
    }

    public ResponseEntity<VoluntarioResponse> atualizar(@PathVariable String id, AtualizarVoluntarioRequest request) {
        return voluntarioRepository.findById(id)
                .map(voluntarioExistente -> {
                    atualizarEntidade(voluntarioExistente, request);
                    Voluntario voluntarioAtualizado = voluntarioRepository.save(voluntarioExistente);
                    return ResponseEntity.ok(converterParaResponse(voluntarioAtualizado));
                })
                .orElseThrow(() -> new RuntimeException("Voluntário não encontrado com o ID: " + id));
    }

    public ResponseEntity<VoluntarioResponse> deletar(@PathVariable String id) {
        if (!voluntarioRepository.existsById(id)) {
            throw new RuntimeException("Voluntário não encontrado com o ID: " + id);
        }
        voluntarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private void atualizarEntidade(Voluntario voluntario, AtualizarVoluntarioRequest request) {
        voluntario.setNome(request.getNome());
        voluntario.setCpf(request.getCpf());
        voluntario.setDataNascimento(request.getDataNascimento());
        voluntario.setLocalizacao(request.getLocalizacao());
        voluntario.setFuncoes(request.getFuncoes());
    }

    private Voluntario converterParaEntidade(CriarVoluntarioRequest request) {
        Voluntario voluntario = new Voluntario();
        voluntario.setNome(request.getNome());
        voluntario.setCpf(request.getCpf());
        voluntario.setDataNascimento(request.getDataNascimento());
        voluntario.setLocalizacao(request.getLocalizacao());
        voluntario.setFuncoes(request.getFuncoes());
        return voluntario;
    }

    private VoluntarioResponse converterParaResponse(Voluntario voluntario) {
        VoluntarioResponse voluntarioResponse = new VoluntarioResponse();
        voluntarioResponse.setId(voluntario.getId());
        voluntarioResponse.setNome(voluntario.getNome());
        voluntarioResponse.setCpf(voluntario.getCpf());
        voluntarioResponse.setDataNascimento(voluntario.getDataNascimento());
        voluntarioResponse.setLocalizacao(voluntario.getLocalizacao());
        voluntarioResponse.setFuncoes(voluntario.getFuncoes());
        return voluntarioResponse;
    }
}
