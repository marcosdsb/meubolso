package com.meubolso.controllers;

import com.meubolso.dto.AbastecimentoDTO;
import com.meubolso.services.AbastecimentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/abastecimento")
@Tag(name = "Abastecimento", description = "Endponts relacionados aos abastecimentos realizados")
public class AbastecimentoController {

    private final AbastecimentoService service;

    public AbastecimentoController(AbastecimentoService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Listar todas as despesas", description = "Retorna uma lista de despesas cadastradas")
    public List<AbastecimentoDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar despesa por ID", description = "Retorna os dados de uma despesa específica")
    public AbastecimentoDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    @Operation(summary = "Cadastrar uma nova despesa", description = "Cadastrar uma nova despesa no sistema")
    public AbastecimentoDTO salvar(@RequestBody AbastecimentoDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Altera uma despesa", description = "Altera dados de uma despesa específica")
    public AbastecimentoDTO atualizar(@PathVariable Long id, @RequestBody AbastecimentoDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover uma despesa", description = "Exclui uma despesa do sistema")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

}
