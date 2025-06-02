package com.meubolso.controllers;

import com.meubolso.dto.CategoriaDespesaDTO;
import com.meubolso.services.CategoriaDespesaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias-despesa")
@RequiredArgsConstructor
public class CategoriaDespesaController {

    private final CategoriaDespesaService service;

    @GetMapping
    public List<CategoriaDespesaDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public CategoriaDespesaDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public CategoriaDespesaDTO salvar(@RequestBody CategoriaDespesaDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public CategoriaDespesaDTO atualizar(@PathVariable Long id, @RequestBody CategoriaDespesaDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}