package com.meubolso.services.imp;

import com.meubolso.dto.PostoCombustivelDTO;
import com.meubolso.mappers.PostoCombustivelMapper;
import com.meubolso.model.PostoCombustivel;
import com.meubolso.repositories.PostoCombustivelRepository;
import com.meubolso.services.PostoCombustivelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostoCombustivelServiceImp implements PostoCombustivelService {

    private final PostoCombustivelRepository repository;
    private final PostoCombustivelMapper mapper;

    public PostoCombustivelServiceImp(PostoCombustivelRepository repository, PostoCombustivelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<PostoCombustivelDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public PostoCombustivelDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("PostoCombustivel não encontrado"));
    }

    @Override
    public PostoCombustivelDTO salvar(PostoCombustivelDTO dto) {
        PostoCombustivel entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public PostoCombustivelDTO atualizar(Long id, PostoCombustivelDTO dto) {
        if(!repository.existsById(id)) {
            throw new RuntimeException("PostoCombustivel não encontrado");
        }
        PostoCombustivel entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
