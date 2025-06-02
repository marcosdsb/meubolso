package com.meubolso.controllers;

import com.meubolso.dto.DespesaDTO;
import com.meubolso.services.DespesaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/despesas")
@Tag(name = "Despesas", description = "Endpoints relacionados a despesas")
public class DespesaController {

    private final DespesaService service;

    public DespesaController(DespesaService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Listar todas as despesas", description = "Retorna uma lista de despesas cadastradas")
    public List<DespesaDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar despesa por ID", description = "Retorna os dados de uma despesa específica")
    public DespesaDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    @Operation(summary = "Cadastrar uma nova despesa", description = "Cadastrar uma nova despesa no sistema")
    public DespesaDTO salvar(@RequestBody DespesaDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Altera uma despesa", description = "Altera dados de uma despesa específica")
    public DespesaDTO atualizar(@PathVariable Long id, @RequestBody DespesaDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover uma despesa", description = "Exclui uma despesa do sistema")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
