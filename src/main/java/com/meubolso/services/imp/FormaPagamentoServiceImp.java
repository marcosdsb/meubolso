package com.meubolso.services.imp;

import com.meubolso.dto.FormaPagamentoDTO;
import com.meubolso.mappers.FormaPagamentoMapper;
import com.meubolso.model.FormaPagamento;
import com.meubolso.repositories.FormaPagamentoRepository;
import com.meubolso.services.FormaPagamentoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormaPagamentoServiceImp implements FormaPagamentoService {

    private final FormaPagamentoRepository repository;
    private final FormaPagamentoMapper mapper;

    public FormaPagamentoServiceImp(FormaPagamentoRepository repository, FormaPagamentoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<FormaPagamentoDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public FormaPagamentoDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("FormaPagamento não encontrado"));
    }

    @Override
    public FormaPagamentoDTO salvar(FormaPagamentoDTO dto) {
        FormaPagamento entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public FormaPagamentoDTO atualizar(Long id, FormaPagamentoDTO dto) {
        if(!repository.existsById(id)) {
            throw new RuntimeException("FormaPagamento não encontrado");
        }
        FormaPagamento entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
    
}
