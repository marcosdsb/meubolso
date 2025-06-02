package com.meubolso.services.imp;

import com.meubolso.dto.ExtratoCompletoDTO;
import com.meubolso.dto.ExtratoLancamentoDTO;
import com.meubolso.model.Credito;
import com.meubolso.model.Despesa;
import com.meubolso.repositories.CreditoRepository;
import com.meubolso.repositories.DespesaRepository;
import com.meubolso.services.ExtratoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExtratoServiceImpl implements ExtratoService {

    private final CreditoRepository creditoRepository;
    private final DespesaRepository despesaRepository;

    @Override
    public ExtratoCompletoDTO gerarExtrato(LocalDate inicio, LocalDate fim) {
        List<Credito> creditos = creditoRepository.findByDataBetween(inicio, fim);
        List<Despesa> despesas = despesaRepository.findByDataBetween(inicio, fim);

        List<ExtratoLancamentoDTO> lancamentos = new ArrayList<>();

        creditos.forEach(c -> lancamentos.add(new ExtratoLancamentoDTO(
                c.getData(),
                c.getValor(),
                "CREDITO",
                c.getEmpresa().getNome()
        )));

        despesas.forEach(d -> lancamentos.add(new ExtratoLancamentoDTO(
                d.getData(),
                d.getValor().negate(),
                "DESPESA",
                d.getCategoria().getDescricao()
        )));

        lancamentos.sort(Comparator.comparing(ExtratoLancamentoDTO::data));

        BigDecimal saldo = lancamentos.stream()
                .map(ExtratoLancamentoDTO::valor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new ExtratoCompletoDTO(lancamentos, saldo);
    }
}
