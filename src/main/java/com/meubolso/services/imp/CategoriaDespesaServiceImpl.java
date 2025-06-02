package com.meubolso.services.imp;

import com.meubolso.dto.CategoriaDespesaDTO;
import com.meubolso.mappers.CategoriaDespesaMapper;
import com.meubolso.model.CategoriaDespesa;
import com.meubolso.repositories.CategoriaDespesaRepository;
import com.meubolso.services.CategoriaDespesaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaDespesaServiceImpl implements CategoriaDespesaService {

    private final CategoriaDespesaRepository repository;
    private final CategoriaDespesaMapper mapper;

    @Override
    public List<CategoriaDespesaDTO> listarTodos() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public CategoriaDespesaDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Categoria de despesa não encontrada"));
    }

    @Override
    public CategoriaDespesaDTO salvar(CategoriaDespesaDTO dto) {
        CategoriaDespesa entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public CategoriaDespesaDTO atualizar(Long id, CategoriaDespesaDTO dto) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Categoria de despesa não encontrada para atualizar");
        }
        CategoriaDespesa entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
