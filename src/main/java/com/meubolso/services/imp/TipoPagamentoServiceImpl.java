package com.meubolso.services.imp;

import com.meubolso.dto.TipoPagamentoDTO;
import com.meubolso.mappers.TipoPagamentoMapper;
import com.meubolso.model.TipoPagamento;
import com.meubolso.repositories.TipoPagamentoRepository;
import com.meubolso.services.TipoPagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoPagamentoServiceImpl implements TipoPagamentoService {

    private final TipoPagamentoRepository repository;
    private final TipoPagamentoMapper mapper;

    @Override
    public List<TipoPagamentoDTO> listarTodos() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public TipoPagamentoDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Tipo de Pagamento não encontrado"));
    }

    @Override
    public TipoPagamentoDTO salvar(TipoPagamentoDTO dto) {
        TipoPagamento entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public TipoPagamentoDTO atualizar(Long id, TipoPagamentoDTO dto) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Tipo de Pagamento não encontrado para atualizar");
        }
        TipoPagamento entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
