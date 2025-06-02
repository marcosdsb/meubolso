package com.meubolso.services.imp;

import com.meubolso.dto.CreditoDTO;
import com.meubolso.mappers.CreditoMapper;
import com.meubolso.model.Credito;
import com.meubolso.repositories.CreditoRepository;
import com.meubolso.services.CreditoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditoServiceImpl implements CreditoService {

    private final CreditoRepository repository;
    private final CreditoMapper mapper;

    @Override
    public List<CreditoDTO> listarTodos() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public CreditoDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Crédito não encontrado"));
    }

    @Override
    public CreditoDTO salvar(CreditoDTO dto) {
        Credito entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public CreditoDTO atualizar(Long id, CreditoDTO dto) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Crédito não encontrado para atualizar");
        }
        Credito entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
