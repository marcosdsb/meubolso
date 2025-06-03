package com.meubolso.controllers;

import com.meubolso.dto.TipoCombustivelDTO;
import com.meubolso.services.TipoCombustivelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-compustivel")
@Tag(name = "Tipo de Combustível", description = "Endponts relacionados ao CRUD tipo de combustível")
public class TipoCombustivelController {

    private final TipoCombustivelService service;

    public TipoCombustivelController(TipoCombustivelService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Listar todos os tipos de combustível", description = "Retorna uma lista de tipos de combustível cadastrados")
    public List<TipoCombustivelDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar tipo de combustível por ID", description = "Retorna os dados de um tipos de combustível específico")
    public TipoCombustivelDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    @Operation(summary = "Cadastrar um novo tipos de combustível", description = "Cadastrar um novo tipos de combustível")
    public TipoCombustivelDTO salvar(@RequestBody TipoCombustivelDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Altera um tipo de combustível", description = "Altera dados de um tipo de combustível específico")
    public TipoCombustivelDTO atualizar(@PathVariable Long id, @RequestBody TipoCombustivelDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover um tipo de combustível", description = "Exclui um tipo de combustível")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

}
