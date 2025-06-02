package com.meubolso.services.imp;

import com.meubolso.dto.DespesaDTO;
import com.meubolso.mappers.DespesaMapper;
import com.meubolso.model.Despesa;
import com.meubolso.repositories.DespesaRepository;
import com.meubolso.services.DespesaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DespesaServiceImpl implements DespesaService {

    private final DespesaRepository repository;
    private final DespesaMapper mapper;

    @Override
    public List<DespesaDTO> listarTodos() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public DespesaDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Despesa não encontrada"));
    }

    @Override
    public DespesaDTO salvar(DespesaDTO dto) {
        Despesa entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public DespesaDTO atualizar(Long id, DespesaDTO dto) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Despesa não encontrada para atualizar");
        }
        Despesa entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
