package com.meubolso.controllers;

import com.meubolso.dto.EmpresaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
@RequiredArgsConstructor
public class EmpresaController {

    private final EmpresaService service;

    @GetMapping
    public List<EmpresaDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public EmpresaDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public EmpresaDTO salvar(@RequestBody EmpresaDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public EmpresaDTO atualizar(@PathVariable Long id, @RequestBody EmpresaDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}