package com.meubolso.services.imp;

import com.meubolso.dto.InvestimentoDTO;
import com.meubolso.mappers.InvestimentoMapper;
import com.meubolso.model.Investimento;
import com.meubolso.repositories.InvestimentoRepository;
import com.meubolso.services.InvestimentoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestimentoServiceImp implements InvestimentoService {

    private final InvestimentoRepository repository;
    private final InvestimentoMapper mapper;

    public InvestimentoServiceImp(InvestimentoRepository repository, InvestimentoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<InvestimentoDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public InvestimentoDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Investimento não encontrado"));
    }

    @Override
    public InvestimentoDTO salvar(InvestimentoDTO dto) {
        Investimento entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public InvestimentoDTO atualizar(Long id, InvestimentoDTO dto) {
        if(!repository.existsById(id)) {
            throw new RuntimeException("Investimento não encontrado");
        }
        Investimento entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
    
}
