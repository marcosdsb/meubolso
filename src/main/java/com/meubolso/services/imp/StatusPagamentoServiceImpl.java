package com.meubolso.services.imp;

import com.meubolso.dto.StatusPagamentoDTO;
import com.meubolso.mappers.StatusPagamentoMapper;
import com.meubolso.model.StatusPagamento;
import com.meubolso.repositories.StatusPagamentoRepository;
import com.meubolso.services.StatusPagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusPagamentoServiceImpl implements StatusPagamentoService {

    private final StatusPagamentoRepository repository;
    private final StatusPagamentoMapper mapper;

    @Override
    public List<StatusPagamentoDTO> listarTodos() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public StatusPagamentoDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Status de Pagamento não encontrado"));
    }

    @Override
    public StatusPagamentoDTO salvar(StatusPagamentoDTO dto) {
        StatusPagamento entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public StatusPagamentoDTO atualizar(Long id, StatusPagamentoDTO dto) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Status de Pagamento não encontrado para atualização");
        }
        StatusPagamento entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
