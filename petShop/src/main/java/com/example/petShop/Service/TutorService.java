package com.example.petShop.Service;


import com.example.petShop.DTO.request.TutorRequests.AtualizarTutorRequest;
import com.example.petShop.DTO.request.TutorRequests.CriarTutorRequest;
import com.example.petShop.DTO.response.Tutor.TutorResponse;
import com.example.petShop.entity.Tutor;
import com.example.petShop.repository.TutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TutorService {

    private final TutorRepository tutorRepository;

    public TutorService(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    public List<TutorResponse> listarTodos() {
        return tutorRepository.findAll().stream()
                .map(this::converterParaResponse)
                .collect(Collectors.toList());
    }

    public TutorResponse salvar(CriarTutorRequest request) {
        Tutor tutor = converterParaEntidade(request);
        Tutor tutorSalvo = tutorRepository.save(tutor);
        return converterParaResponse(tutorSalvo);
    }

    public Optional<TutorResponse> buscarPorId(String id) {
        return tutorRepository.findById(id)
                .map(this::converterParaResponse);
    }

    public TutorResponse atualizar(String id, AtualizarTutorRequest request) {
        return tutorRepository.findById(id)
                .map(tutorExistente -> {
                    atualizarEntidade(tutorExistente, request);
                    Tutor tutorAtualizado = tutorRepository.save(tutorExistente);
                    return converterParaResponse(tutorAtualizado);
                })
                .orElseThrow(() -> new RuntimeException("Tutor não encontrado com o ID: " + id));
    }

    public void deletar(String id) {
        if (!tutorRepository.existsById(id)) {
            throw new RuntimeException("Tutor não encontrado com o ID: " + id);
        }
        tutorRepository.deleteById(id);
    }

    private void atualizarEntidade(Tutor tutor, AtualizarTutorRequest request) {
        tutor.setNome(request.getNome());
        tutor.setCpf(request.getCpf());
        tutor.setDataNascimento(request.getDataNascimento());
        tutor.setLocalizacao(request.getLocalizacao());
    }

    private TutorResponse converterParaResponse(Tutor tutor) {
        TutorResponse response = new TutorResponse();
        response.setId(tutor.getId());
        response.setNome(tutor.getNome());
        response.setCpf(tutor.getCpf());
        response.setDataNascimento(tutor.getDataNascimento());
        response.setLocalizacao(tutor.getLocalizacao());
        return response;
    }

    private Tutor converterParaEntidade(CriarTutorRequest request) {
        Tutor tutor = new Tutor();
        tutor.setNome(request.getNome());
        tutor.setCpf(request.getCpf());
        tutor.setDataNascimento(request.getDataNascimento());
        tutor.setLocalizacao(request.getLocalizacao());
        return tutor;
    }
}
