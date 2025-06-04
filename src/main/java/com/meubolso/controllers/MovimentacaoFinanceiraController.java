package com.meubolso.controllers;

import com.meubolso.dto.MovimentacaoFinanceiraDTO;
import com.meubolso.services.MovimentacaoFinanceiraService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
}
