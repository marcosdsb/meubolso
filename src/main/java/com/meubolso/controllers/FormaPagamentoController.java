package com.meubolso.controllers;

import com.meubolso.dto.FormaPagamentoDTO;
import com.meubolso.services.FormaPagamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/forma-pagamento")
@Tag(name = "Forma de pagamento", description = "Endpoints relacionados a forma de pagamento")
public class FormaPagamentoController {

    private final FormaPagamentoService service;

    public FormaPagamentoController(FormaPagamentoService service) {
        this.service = service;
    }


    @GetMapping
    @Operation(summary = "Listar todas as despesas", description = "Retorna uma lista de despesas cadastradas")
    public List<FormaPagamentoDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar despesa por ID", description = "Retorna os dados de uma despesa específica")
    public FormaPagamentoDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    @Operation(summary = "Cadastrar uma nova despesa", description = "Cadastrar uma nova despesa no sistema")
    public FormaPagamentoDTO salvar(@RequestBody FormaPagamentoDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Altera uma despesa", description = "Altera dados de uma despesa específica")
    public FormaPagamentoDTO atualizar(@PathVariable Long id, @RequestBody FormaPagamentoDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover uma despesa", description = "Exclui uma despesa do sistema")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

}
