-- Criação da nova tabela movimentacao_financeira
CREATE TABLE IF NOT EXISTS movimentacao_financeira (
                                                       id SERIAL PRIMARY KEY,
                                                       descricao VARCHAR(255) NOT NULL,
    valor NUMERIC(12,2) NOT NULL,
    tipo_movimentacao VARCHAR(10) NOT NULL, -- ENTRADA ou SAIDA
    data_lancamento DATE NOT NULL,
    data_vencimento DATE,
    data_pagamento DATE,
    recorrente BOOLEAN DEFAULT FALSE,
    numero_parcela INTEGER,
    total_parcelas INTEGER,
    valor_parcela NUMERIC(12,2),
    local_compra VARCHAR(150),
    produto_servico VARCHAR(255),
    mes_id INTEGER,
    forma_pagamento_id INTEGER,
    status_pagamento_id INTEGER,

    CONSTRAINT fk_movimentacao_mes FOREIGN KEY (mes_id)
    REFERENCES mes_referencia(id) ON DELETE SET NULL,
    CONSTRAINT fk_movimentacao_forma_pagamento FOREIGN KEY (forma_pagamento_id)
    REFERENCES forma_pagamento(id) ON DELETE SET NULL,
    CONSTRAINT fk_movimentacao_status_pagamento FOREIGN KEY (status_pagamento_id)
    REFERENCES status_pagamento(id) ON DELETE SET NULL
    );

-- Adiciona campos no cartão de crédito para controle de faturas
ALTER TABLE cartao_credito ADD COLUMN dia_vencimento_fatura INTEGER;
ALTER TABLE cartao_credito ADD COLUMN melhor_dia_compra INTEGER;
