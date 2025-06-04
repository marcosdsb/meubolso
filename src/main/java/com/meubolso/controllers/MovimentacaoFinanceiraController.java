package com.meubolso.controllers;

import com.meubolso.dto.MovimentacaoFinanceiraDTO;
import com.meubolso.filtro.MovimentacaoFinanceiraFiltro;
import com.meubolso.services.MovimentacaoFinanceiraService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/movimentacao-financeira")
@RequiredArgsConstructor
public class MovimentacaoFinanceiraController {

    private final MovimentacaoFinanceiraService service;

    @GetMapping
    public List<MovimentacaoFinanceiraDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public MovimentacaoFinanceiraDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public MovimentacaoFinanceiraDTO salvar(@RequestBody MovimentacaoFinanceiraDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public MovimentacaoFinanceiraDTO atualizar(@PathVariable Long id, @RequestBody MovimentacaoFinanceiraDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    // Filtro básico com 3 parâmetros
    @GetMapping("/filtro")
    public List<MovimentacaoFinanceiraDTO> filtrar(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim,
            @RequestParam(required = false) Long statusPagamentoId
    ) {
        return service.filtrar(dataInicio, dataFim, statusPagamentoId);
    }

    // Filtro completo via body (POST)
    @PostMapping("/filtro")
    public List<MovimentacaoFinanceiraDTO> filtrarAvancado(@RequestBody MovimentacaoFinanceiraFiltro filtro) {
        return service.filtrar(filtro);
    }

}
