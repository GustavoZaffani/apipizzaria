CREATE TABLE IF NOT EXISTS sale_item
(
    id              UUID              PRIMARY KEY,
    pizzeria_id     UUID              NOT NULL,
    sale_id         UUID              NOT NULL REFERENCES sale(id),
    pizza_id        UUID              NOT NULL REFERENCES pizza(id),
    quantity        BIGINT            NOT NULL
);


COMMENT ON TABLE sale_item IS 'Tabela que armazena os itens das vendas.';

COMMENT ON COLUMN sale_item.id IS 'Identificador único do item da venda.';
COMMENT ON COLUMN sale_item.pizzeria_id IS 'Identificador da pizzaria associada ao item da venda.';
COMMENT ON COLUMN sale_item.sale_id IS 'Identificador da venda associada ao item.';
COMMENT ON COLUMN sale_item.pizza_id IS 'Identificador da pizza associada ao item da venda.';
COMMENT ON COLUMN sale_item.quantity IS 'Quantidade da pizza vendida.';
