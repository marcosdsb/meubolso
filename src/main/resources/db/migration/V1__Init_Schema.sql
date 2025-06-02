-- =====================================================================================
-- V1__Init_Schema.sql
-- Criação de todas as tabelas conforme entidades definidas
-- =====================================================================================

-- 1. Tabela mes_referencia
CREATE TABLE IF NOT EXISTS mes_referencia (
                                              id SERIAL PRIMARY KEY,
                                              ano INTEGER NOT NULL,
                                              mes INTEGER NOT NULL,
                                              UNIQUE (ano, mes)
    );

-- 2. Tabela empresa
CREATE TABLE IF NOT EXISTS empresa (
                                       id SERIAL PRIMARY KEY,
                                       nome VARCHAR(100) NOT NULL
    );

-- 3. Tabela cartao_credito
CREATE TABLE IF NOT EXISTS cartao_credito (
                                              id SERIAL PRIMARY KEY,
                                              nome VARCHAR(100) NOT NULL
    );

-- 4. Tabela forma_pagamento
CREATE TABLE IF NOT EXISTS forma_pagamento (
                                               id SERIAL PRIMARY KEY,
                                               tipo VARCHAR(50) NOT NULL,
    cartao_credito_id INTEGER,
    CONSTRAINT fk_formapagamento_cartao FOREIGN KEY (cartao_credito_id)
    REFERENCES cartao_credito(id)
    ON DELETE SET NULL
    );

-- 5. Tabela status_pagamento
CREATE TABLE IF NOT EXISTS status_pagamento (
                                                id SERIAL PRIMARY KEY,
                                                status VARCHAR(20) NOT NULL
    );

-- 6. Tabela categoria_despesa
CREATE TABLE IF NOT EXISTS categoria_despesa (
                                                 id SERIAL PRIMARY KEY,
                                                 tipo VARCHAR(20) NOT NULL,
    descricao VARCHAR(100) NOT NULL
    );

-- 7. Tabela despesa
CREATE TABLE IF NOT EXISTS despesa (
                                       id SERIAL PRIMARY KEY,
                                       categoria_id INTEGER,
                                       total NUMERIC(12,2),
    data DATE,
    mes_id INTEGER,
    forma_pagamento_id INTEGER,
    status_pagamento_id INTEGER,
    valor_parcela NUMERIC(12,2),
    numero_parcela INTEGER,
    total_parcelas INTEGER,
    data_vencimento DATE,
    recorrente BOOLEAN,
    data_inicio DATE,
    data_fim DATE,
    CONSTRAINT fk_despesa_categoria FOREIGN KEY (categoria_id)
    REFERENCES categoria_despesa(id)
    ON DELETE SET NULL,
    CONSTRAINT fk_despesa_mes FOREIGN KEY (mes_id)
    REFERENCES mes_referencia(id)
    ON DELETE SET NULL,
    CONSTRAINT fk_despesa_formapagamento FOREIGN KEY (forma_pagamento_id)
    REFERENCES forma_pagamento(id)
    ON DELETE SET NULL,
    CONSTRAINT fk_despesa_status FOREIGN KEY (status_pagamento_id)
    REFERENCES status_pagamento(id)
    ON DELETE SET NULL
    );

-- 8. Tabela credito
CREATE TABLE IF NOT EXISTS credito (
                                       id SERIAL PRIMARY KEY,
                                       valor NUMERIC(12,2) NOT NULL,
    data DATE NOT NULL,
    empresa_id INTEGER,
    mes_id INTEGER,
    CONSTRAINT fk_credito_empresa FOREIGN KEY (empresa_id)
    REFERENCES empresa(id)
    ON DELETE SET NULL,
    CONSTRAINT fk_credito_mes FOREIGN KEY (mes_id)
    REFERENCES mes_referencia(id)
    ON DELETE SET NULL
    );

-- 9. Tabela investimento
CREATE TABLE IF NOT EXISTS investimento (
                                            id SERIAL PRIMARY KEY,
                                            tipo VARCHAR(30) NOT NULL,
    descricao VARCHAR(100),
    valor NUMERIC(12,2) NOT NULL,
    data DATE NOT NULL,
    mes_id INTEGER,
    CONSTRAINT fk_investimento_mes FOREIGN KEY (mes_id)
    REFERENCES mes_referencia(id)
    ON DELETE SET NULL
    );

-- 10. Tabela tipo_combustivel
CREATE TABLE IF NOT EXISTS tipo_combustivel (
                                                id SERIAL PRIMARY KEY,
                                                nome VARCHAR(50) NOT NULL
    );

-- 11. Tabela posto_combustivel
CREATE TABLE IF NOT EXISTS posto_combustivel (
                                                 id SERIAL PRIMARY KEY,
                                                 nome VARCHAR(100) NOT NULL,
    cnpj VARCHAR(20),
    endereco VARCHAR(150)
    );

-- 12. Tabela abastecimento
CREATE TABLE IF NOT EXISTS abastecimento (
                                             id SERIAL PRIMARY KEY,
                                             data DATE NOT NULL,
                                             tipo_combustivel_id INTEGER,
                                             valor_total NUMERIC(12,2) NOT NULL,
    litros NUMERIC(12,2) NOT NULL,
    km_atual INTEGER NOT NULL,
    mes_id INTEGER,
    posto_id INTEGER,
    CONSTRAINT fk_abastecimento_tipo_combustivel FOREIGN KEY (tipo_combustivel_id)
    REFERENCES tipo_combustivel(id)
    ON DELETE SET NULL,
    CONSTRAINT fk_abastecimento_mes FOREIGN KEY (mes_id)
    REFERENCES mes_referencia(id)
    ON DELETE SET NULL,
    CONSTRAINT fk_abastecimento_posto FOREIGN KEY (posto_id)
    REFERENCES posto_combustivel(id)
    ON DELETE SET NULL
    );
