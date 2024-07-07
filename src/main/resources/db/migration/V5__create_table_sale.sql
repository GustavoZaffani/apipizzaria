CREATE TABLE IF NOT EXISTS sale
(
    id              UUID                PRIMARY KEY,
    pizzeria_id     UUID                NOT NULL REFERENCES pizzeria(id),
    sale_date       TIMESTAMP           NOT NULL,
    total           NUMERIC(15, 2)      NOT NULL
);

COMMENT ON TABLE sale IS 'Tabela que armazena as vendas.';

COMMENT ON COLUMN sale.id IS 'Identificador único da venda.';
COMMENT ON COLUMN sale.pizzeria_id IS 'Identificador da pizzaria associada à venda.';
COMMENT ON COLUMN sale.sale_date IS 'Data e hora da venda.';
COMMENT ON COLUMN sale.total IS 'Valor total da venda.';
