package com.meubolso.controllers;

import com.meubolso.dto.StatusPagamentoDTO;
import com.meubolso.services.StatusPagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status-pagamentos")
@RequiredArgsConstructor
public class StatusPagamentoController {

    private final StatusPagamentoService service;

    @GetMapping
    public List<StatusPagamentoDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public StatusPagamentoDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public StatusPagamentoDTO salvar(@RequestBody StatusPagamentoDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public StatusPagamentoDTO atualizar(@PathVariable Long id, @RequestBody StatusPagamentoDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
