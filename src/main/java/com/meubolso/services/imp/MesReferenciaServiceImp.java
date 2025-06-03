package com.meubolso.services.imp;

import com.meubolso.dto.MesReferenciaDTO;
import com.meubolso.mappers.MesReferenciaMapper;
import com.meubolso.model.MesReferencia;
import com.meubolso.repositories.MesReferenciaRepository;
import com.meubolso.services.MesReferenciaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesReferenciaServiceImp implements MesReferenciaService {

    private final MesReferenciaRepository repository;
    private final MesReferenciaMapper mapper;

    public MesReferenciaServiceImp(MesReferenciaRepository repository, MesReferenciaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<MesReferenciaDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public MesReferenciaDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("MesReferencia não encontrado"));
    }

    @Override
    public MesReferenciaDTO salvar(MesReferenciaDTO dto) {
        MesReferencia entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public MesReferenciaDTO atualizar(Long id, MesReferenciaDTO dto) {
        if(!repository.existsById(id)) {
            throw new RuntimeException("MesReferencia não encontrado");
        }
        MesReferencia entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
