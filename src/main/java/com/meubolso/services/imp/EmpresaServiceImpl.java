package com.meubolso.services.imp;

import com.meubolso.services.EmpresaService;
import com.meubolso.dto.EmpresaDTO;
import com.meubolso.mappers.EmpresaMapper;
import com.meubolso.model.Empresa;
import com.meubolso.repositories.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository repository;
    private final EmpresaMapper mapper;

    @Override
    public List<EmpresaDTO> listarTodos() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public EmpresaDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
    }

    @Override
    public EmpresaDTO salvar(EmpresaDTO dto) {
        Empresa entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public EmpresaDTO atualizar(Long id, EmpresaDTO dto) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Empresa não encontrada para atualizar");
        }
        Empresa entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
