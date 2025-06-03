package com.meubolso.services.imp;

import com.meubolso.dto.CartaoCreditoDTO;
import com.meubolso.mappers.CartaoCreditoMapper;
import com.meubolso.model.CartaoCredito;
import com.meubolso.repositories.CartaoCreditoRepository;
import com.meubolso.services.CartaoCreditoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaoCreditoServiceImp implements CartaoCreditoService {

    private final CartaoCreditoRepository repository;
    private final CartaoCreditoMapper mapper;

    public CartaoCreditoServiceImp(CartaoCreditoRepository repository, CartaoCreditoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<CartaoCreditoDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public CartaoCreditoDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("CartaoCredito não encontrado"));
    }

    @Override
    public CartaoCreditoDTO salvar(CartaoCreditoDTO dto) {
        CartaoCredito entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public CartaoCreditoDTO atualizar(Long id, CartaoCreditoDTO dto) {
        if(!repository.existsById(id)) {
            throw new RuntimeException("CartaoCredito não encontrado");
        }
        CartaoCredito entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
    
}
