package com.meubolso.services.imp;

import com.meubolso.dto.MovimentacaoFinanceiraDTO;
import com.meubolso.mappers.MovimentacaoFinanceiraMapper;
import com.meubolso.model.MovimentacaoFinanceira;
import com.meubolso.repositories.MovimentacaoFinanceiraRepository;
import com.meubolso.services.MovimentacaoFinanceiraService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentacaoFinanceiraServiceImp implements MovimentacaoFinanceiraService {

    private final MovimentacaoFinanceiraRepository repository;
    private final MovimentacaoFinanceiraMapper mapper;

    public MovimentacaoFinanceiraServiceImp(MovimentacaoFinanceiraRepository repository, MovimentacaoFinanceiraMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<MovimentacaoFinanceiraDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public MovimentacaoFinanceiraDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("MovimentacaoFinanceira não encontrado"));
    }

    @Override
    public MovimentacaoFinanceiraDTO salvar(MovimentacaoFinanceiraDTO dto) {
        MovimentacaoFinanceira entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public MovimentacaoFinanceiraDTO atualizar(Long id, MovimentacaoFinanceiraDTO dto) {
        if(!repository.existsById(id)) {
            throw new RuntimeException("MovimentacaoFinanceira não encontrado");
        }
        MovimentacaoFinanceira entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
    
}
