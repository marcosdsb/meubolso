package com.meubolso.controllers;

import com.meubolso.dto.MesReferenciaDTO;
import com.meubolso.services.MesReferenciaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mes-referencia")
@Tag(name = "Mes Referencia", description = "Endpoints relacionados ao mês de referencia da compra no cartão")
public class MesReferenciaController {
    
    private final MesReferenciaService service;

    public MesReferenciaController(MesReferenciaService service) {
        this.service = service;
    }


    @GetMapping
    @Operation(summary = "Listar todas as despesas", description = "Retorna uma lista de despesas cadastradas")
    public List<MesReferenciaDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar despesa por ID", description = "Retorna os dados de uma despesa específica")
    public MesReferenciaDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    @Operation(summary = "Cadastrar uma nova despesa", description = "Cadastrar uma nova despesa no sistema")
    public MesReferenciaDTO salvar(@RequestBody MesReferenciaDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Altera uma despesa", description = "Altera dados de uma despesa específica")
    public MesReferenciaDTO atualizar(@PathVariable Long id, @RequestBody MesReferenciaDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover uma despesa", description = "Exclui uma despesa do sistema")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
    
}
