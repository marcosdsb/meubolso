package com.meubolso.services.imp;

import com.meubolso.dto.AbastecimentoDTO;
import com.meubolso.mappers.AbastecimentoMapper;
import com.meubolso.model.Abastecimento;
import com.meubolso.repositories.AbastecimentoRepository;
import com.meubolso.services.AbastecimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AbastecimentoServiceImp implements AbastecimentoService {

    private final AbastecimentoRepository repository;
    private final AbastecimentoMapper mapper;

    @Override
    public List<AbastecimentoDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public AbastecimentoDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Abastecimento não encontrado"));
    }

    @Override
    public AbastecimentoDTO salvar(AbastecimentoDTO dto) {
        Abastecimento entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public AbastecimentoDTO atualizar(Long id, AbastecimentoDTO dto) {
        if(!repository.existsById(id)) {
            throw new RuntimeException("Abastecimento não encontrado");
        }
        Abastecimento entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
