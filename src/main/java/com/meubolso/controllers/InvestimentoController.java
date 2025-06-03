package com.meubolso.controllers;

import com.meubolso.dto.InvestimentoDTO;
import com.meubolso.services.InvestimentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/investimento")
@Tag(name = "Investimentos", description = "Endpoints relacionados ao investimentos")
public class InvestimentoController {

    private final InvestimentoService service;

    public InvestimentoController(InvestimentoService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Listar todos os investimentos", description = "Retorna uma lista de investimentos cadastradas")
    public List<InvestimentoDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar investimento por ID", description = "Retorna os dados de um investimento específico")
    public InvestimentoDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    @Operation(summary = "Cadastrar um novo investimento", description = "Cadastra um novo investimento no sistema")
    public InvestimentoDTO salvar(@RequestBody InvestimentoDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Altera um investimento", description = "Altera dados de uma investimento específico")
    public InvestimentoDTO atualizar(@PathVariable Long id, @RequestBody InvestimentoDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover um investimentos", description = "Exclui um investimentos do sistema")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
    
}
