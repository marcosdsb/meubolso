package com.meubolso.controllers;

import com.meubolso.dto.PostoCombustivelDTO;
import com.meubolso.services.PostoCombustivelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posto-combustivel")
@Tag(name = "Posto de Combustivel", description = "Endpoints relacionados CRUD de posto de combustivel")
public class PostoCombustivelController {

    private final PostoCombustivelService service;

    public PostoCombustivelController(PostoCombustivelService service) {
        this.service = service;
    }


    @GetMapping
    @Operation(summary = "Listar todas os postos", description = "Retorna uma lista de postos de combustível cadastrados")
    public List<PostoCombustivelDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar posto de combustível por ID", description = "Retorna os dados de um posto de combustível específico")
    public PostoCombustivelDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    @Operation(summary = "Cadastrar um novo posto de combustível", description = "Cadastrar um novo posto de combustível")
    public PostoCombustivelDTO salvar(@RequestBody PostoCombustivelDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Altera um posto de combustível", description = "Altera dados de um posto de combustível específico")
    public PostoCombustivelDTO atualizar(@PathVariable Long id, @RequestBody PostoCombustivelDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover um posto de combustível", description = "Exclui um posto de combustível")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
    
}
