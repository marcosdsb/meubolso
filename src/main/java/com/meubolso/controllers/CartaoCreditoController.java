package com.meubolso.controllers;

import com.meubolso.dto.CartaoCreditoDTO;
import com.meubolso.services.CartaoCreditoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cartao-credito")
@Tag(name = "Cartão de Crédito", description = "Endpoints relacionados ao Cartão de Crédito")
public class CartaoCreditoController {

    private final CartaoCreditoService service;

    public CartaoCreditoController(CartaoCreditoService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Listar todas as despesas", description = "Retorna uma lista de despesas cadastradas")
    public List<CartaoCreditoDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar despesa por ID", description = "Retorna os dados de uma despesa específica")
    public CartaoCreditoDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    @Operation(summary = "Cadastrar uma nova despesa", description = "Cadastrar uma nova despesa no sistema")
    public CartaoCreditoDTO salvar(@RequestBody CartaoCreditoDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Altera uma despesa", description = "Altera dados de uma despesa específica")
    public CartaoCreditoDTO atualizar(@PathVariable Long id, @RequestBody CartaoCreditoDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover uma despesa", description = "Exclui uma despesa do sistema")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
