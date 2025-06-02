package com.meubolso.services;

import com.meubolso.dto.ExtratoCompletoDTO;

import java.time.LocalDate;

public interface ExtratoService {
    ExtratoCompletoDTO gerarExtrato(LocalDate inicio, LocalDate fim);
}
