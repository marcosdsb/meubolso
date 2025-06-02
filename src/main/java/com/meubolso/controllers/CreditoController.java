package com.meubolso.controllers;

import com.meubolso.dto.CreditoDTO;
import com.meubolso.services.CreditoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/creditos")
@RequiredArgsConstructor
public class CreditoController {

    private final CreditoService service;

    @GetMapping
    public List<CreditoDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public CreditoDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public CreditoDTO salvar(@RequestBody CreditoDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public CreditoDTO atualizar(@PathVariable Long id, @RequestBody CreditoDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
