package com.meubolso.services.imp;

import com.meubolso.dto.MovimentacaoFinanceiraDTO;
import com.meubolso.enumerate.TipoMovimentacaoEnum;
import com.meubolso.filtro.MovimentacaoFinanceiraFiltro;
import com.meubolso.mappers.MovimentacaoFinanceiraMapper;
import com.meubolso.model.*;
import com.meubolso.repositories.*;
import com.meubolso.services.MovimentacaoFinanceiraService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovimentacaoFinanceiraServiceImp implements MovimentacaoFinanceiraService {

    private final MovimentacaoFinanceiraRepository repository;
    private final EmpresaRepository empresaRepository;
    private final CartaoCreditoRepository cartaoCreditoRepository;
    private final MesReferenciaRepository mesReferenciaRepository;
    private final StatusPagamentoRepository statusPagamentoRepository;
    private final CategoriaDespesaRepository categoriaDespesaRepository;
    private final FormaPagamentoRepository formaPagamentoRepository;

    private final MovimentacaoFinanceiraMapper mapper;

    @PersistenceContext
    private EntityManager entityManager;

    public MovimentacaoFinanceiraServiceImp(MovimentacaoFinanceiraRepository repository,
                                            MovimentacaoFinanceiraMapper mapper, EmpresaRepository empresaRepository, CartaoCreditoRepository cartaoCreditoRepository, MesReferenciaRepository mesReferenciaRepository, StatusPagamentoRepository statusPagamentoRepository, CategoriaDespesaRepository categoriaDespesaRepository, FormaPagamentoRepository formaPagamentoRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.empresaRepository = empresaRepository;
        this.cartaoCreditoRepository = cartaoCreditoRepository;
        this.mesReferenciaRepository = mesReferenciaRepository;
        this.statusPagamentoRepository = statusPagamentoRepository;
        this.categoriaDespesaRepository = categoriaDespesaRepository;
        this.formaPagamentoRepository = formaPagamentoRepository;
    }

    @Override
    public List<MovimentacaoFinanceiraDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public MovimentacaoFinanceiraDTO buscarPorId(Long id) {
        MovimentacaoFinanceira entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movimentação não encontrada"));
        return mapper.toDto(entity);
    }

    @Override
    public MovimentacaoFinanceiraDTO salvar(MovimentacaoFinanceiraDTO dto) {
        validarDadosObrigatorios(dto);

        MovimentacaoFinanceira entity = mapper.toEntity(dto);
        carregarRelacionamentos(entity, dto);

        MovimentacaoFinanceira salvo = repository.save(entity);

        // Gerar parcelas, se aplicável
        if (Boolean.TRUE.equals(dto.getRecorrente()) || dto.getTotalParcelas() != null && dto.getTotalParcelas() > 1) {
            gerarParcelas(salvo);
        }

        return mapper.toDto(salvo);
    }

    @Override
    public MovimentacaoFinanceiraDTO atualizar(Long id, MovimentacaoFinanceiraDTO dto) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Movimentação Financeira com ID " + id + " não encontrada.");
        }

        validarDadosObrigatorios(dto);

        MovimentacaoFinanceira entity = mapper.toEntity(dto);
        entity.setId(id);

        carregarRelacionamentos(entity, dto);

        MovimentacaoFinanceira atualizado = repository.save(entity);
        return mapper.toDto(atualizado);
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<MovimentacaoFinanceiraDTO> filtrar(LocalDate dataInicio, LocalDate dataFim, Long statusPagamentoId) {
        MovimentacaoFinanceiraFiltro filtro = new MovimentacaoFinanceiraFiltro();
        filtro.setDataInicio(dataInicio);
        filtro.setDataFim(dataFim);
        filtro.setStatusPagamentoId(statusPagamentoId);
        return filtrar(filtro);
    }

    @Override
    public List<MovimentacaoFinanceiraDTO> filtrar(MovimentacaoFinanceiraFiltro filtro) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<MovimentacaoFinanceira> query = cb.createQuery(MovimentacaoFinanceira.class);
        Root<MovimentacaoFinanceira> root = query.from(MovimentacaoFinanceira.class);

        List<Predicate> predicates = new ArrayList<>();

        if (filtro.getDataInicio() != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("dataLancamento"), filtro.getDataInicio()));
        }
        if (filtro.getDataFim() != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get("dataLancamento"), filtro.getDataFim()));
        }
        if (filtro.getStatusPagamentoId() != null) {
            predicates.add(cb.equal(root.get("statusPagamento").get("id"), filtro.getStatusPagamentoId()));
        }
        if (filtro.getMesReferenciaId() != null) {
            predicates.add(cb.equal(root.get("mesReferencia").get("id"), filtro.getMesReferenciaId()));
        }
        if (filtro.getEmpresaId() != null) {
            predicates.add(cb.equal(root.get("empresa").get("id"), filtro.getEmpresaId()));
        }
        if (filtro.getTipoMovimentacao() != null) {
            try {
                predicates.add(cb.equal(
                        root.get("tipoMovimentacaoEnum"),
                        TipoMovimentacaoEnum.valueOf(filtro.getTipoMovimentacao())
                ));
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("Tipo de movimentação inválido: " + filtro.getTipoMovimentacao());
            }

        }

        query.where(predicates.toArray(new Predicate[0]));

        List<MovimentacaoFinanceira> resultados = entityManager.createQuery(query).getResultList();

        return resultados.stream().map(mapper::toDto).toList();
    }


    private void validarDadosObrigatorios(MovimentacaoFinanceiraDTO dto) {
        if (dto.getTipoMovimentacao() == null) {
            throw new IllegalArgumentException("O tipo da movimentação é obrigatório.");
        }
        if (dto.getValor() == null || dto.getValor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor deve ser maior que zero.");
        }
        if (dto.getDataLancamento() == null) {
            throw new IllegalArgumentException("A data de lançamento é obrigatória.");
        }
    }

    private void carregarRelacionamentos(MovimentacaoFinanceira entity, MovimentacaoFinanceiraDTO dto) {
        if (dto.getFormaPagamentoId() != null) {
            FormaPagamento formaPagamento = formaPagamentoRepository.findById(dto.getFormaPagamentoId())
                    .orElseThrow(() -> new EntityNotFoundException("Forma de pagamento com ID " + dto.getFormaPagamentoId() + " não encontrada."));
            entity.setFormaPagamento(formaPagamento);
        }

        if (dto.getCartaoCreditoId() != null) {
            CartaoCredito cartaoCredito = cartaoCreditoRepository.findById(dto.getCartaoCreditoId())
                    .orElseThrow(() -> new EntityNotFoundException("Cartão de crédito com ID " + dto.getCartaoCreditoId() + " não encontrado."));
            entity.setCartaoCredito(cartaoCredito);
        }

        if (dto.getMesReferenciaId() != null) {
            MesReferencia mesReferencia = mesReferenciaRepository.findById(dto.getMesReferenciaId())
                    .orElseThrow(() -> new EntityNotFoundException("Mês de referência com ID " + dto.getMesReferenciaId() + " não encontrado."));
            entity.setMesReferencia(mesReferencia);
        }

        if (dto.getStatusPagamentoId() != null) {
            StatusPagamento statusPagamento = statusPagamentoRepository.findById(dto.getStatusPagamentoId())
                    .orElseThrow(() -> new EntityNotFoundException("Status de pagamento com ID " + dto.getStatusPagamentoId() + " não encontrado."));
            entity.setStatusPagamento(statusPagamento);
        }

        if (dto.getCategoriaDespesaId() != null) {
            CategoriaDespesa categoriaDespesa = categoriaDespesaRepository.findById(dto.getCategoriaDespesaId())
                    .orElseThrow(() -> new EntityNotFoundException("Categoria de despesa com ID " + dto.getCategoriaDespesaId() + " não encontrada."));
            entity.setCategoriaDespesa(categoriaDespesa);
        }

        if (dto.getEmpresaId() != null) {
            Empresa empresa = empresaRepository.findById(dto.getEmpresaId())
                    .orElseThrow(() -> new EntityNotFoundException("Empresa com ID " + dto.getEmpresaId() + " não encontrada."));
            entity.setEmpresa(empresa);
        }
    }


    private void gerarParcelas(MovimentacaoFinanceira primeiraParcela) {
        Integer totalParcelas = primeiraParcela.getTotalParcelas();
        if (totalParcelas == null || totalParcelas <= 1) return;

        CartaoCredito cartao = primeiraParcela.getCartaoCredito();
        if (cartao == null) return;

        LocalDate dataCompra = primeiraParcela.getDataLancamento();
        int melhorDia = cartao.getMelhorDiaCompra();
        int vencimento = cartao.getDiaVencimentoFatura();

        List<MovimentacaoFinanceira> parcelas = new ArrayList<>();

        for (int i = 1; i < totalParcelas; i++) {
            MovimentacaoFinanceira novaParcela = new MovimentacaoFinanceira();
            BeanUtils.copyProperties(primeiraParcela, novaParcela, "id", "dataLancamento", "dataVencimento", "numeroParcela");

            novaParcela.setNumeroParcela(i + 1);

            // Data da nova parcela (adianta +1 mês por parcela)
            LocalDate novaDataCompra = dataCompra.plusMonths(i);
            novaParcela.setDataLancamento(novaDataCompra);

            // Ajuste da data de vencimento com base no melhor dia e dia de vencimento da fatura
            LocalDate dataBase = novaDataCompra.withDayOfMonth(1);
            LocalDate vencimentoParcela;

            if (novaDataCompra.getDayOfMonth() > melhorDia) {
                // Compra entra na fatura do próximo mês
                vencimentoParcela = dataBase.plusMonths(2).withDayOfMonth(vencimento);
            } else {
                // Compra entra na fatura do mesmo mês
                vencimentoParcela = dataBase.plusMonths(1).withDayOfMonth(vencimento);
            }

            novaParcela.setDataVencimento(vencimentoParcela);
            parcelas.add(novaParcela);
        }

        repository.saveAll(parcelas);
    }
}
