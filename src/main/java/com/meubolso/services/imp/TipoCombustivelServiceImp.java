package com.meubolso.services.imp;

import com.meubolso.dto.TipoCombustivelDTO;
import com.meubolso.mappers.TipoCombustivelMapper;
import com.meubolso.model.TipoCombustivel;
import com.meubolso.repositories.TipoCombustivelRepository;
import com.meubolso.services.TipoCombustivelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoCombustivelServiceImp implements TipoCombustivelService {

    private final TipoCombustivelRepository repository;
    private final TipoCombustivelMapper mapper;

    public TipoCombustivelServiceImp(TipoCombustivelRepository repository, TipoCombustivelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<TipoCombustivelDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public TipoCombustivelDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("TipoCombustivel não encontrado"));
    }

    @Override
    public TipoCombustivelDTO salvar(TipoCombustivelDTO dto) {
        TipoCombustivel entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public TipoCombustivelDTO atualizar(Long id, TipoCombustivelDTO dto) {
        if(!repository.existsById(id)) {
            throw new RuntimeException("TipoCombustivel não encontrado");
        }
        TipoCombustivel entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
    
}
