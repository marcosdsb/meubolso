package com.meubolso.controllers;

import com.meubolso.dto.TipoPagamentoDTO;
import com.meubolso.services.TipoPagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-pagamentos")
@RequiredArgsConstructor
public class TipoPagamentoController {

    private final TipoPagamentoService service;

    @GetMapping
    public List<TipoPagamentoDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public TipoPagamentoDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public TipoPagamentoDTO salvar(@RequestBody TipoPagamentoDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public TipoPagamentoDTO atualizar(@PathVariable Long id, @RequestBody TipoPagamentoDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
