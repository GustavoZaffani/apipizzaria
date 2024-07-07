CREATE TABLE IF NOT EXISTS pizza
(
    id              UUID                        PRIMARY KEY,
    pizzeria_id     UUID                        NOT NULL,
    name            VARCHAR(255)                NOT NULL,
    price           NUMERIC(15, 2)              NOT NULL,
    active          BOOLEAN                     NOT NULL DEFAULT TRUE,
    deleted_at      TIMESTAMP                   NULL
);

COMMENT ON TABLE pizza IS 'Tabela que armazena informações das pizzas.';

COMMENT ON COLUMN pizza.id IS 'Identificador único da pizza.';
COMMENT ON COLUMN pizza.pizzeria_id IS 'Identificador da pizzaria associada à pizza.';
COMMENT ON COLUMN pizza.name IS 'Nome da pizza.';
COMMENT ON COLUMN pizza.price IS 'Preço da pizza.';
COMMENT ON COLUMN pizza.active IS 'Indica se a pizza está ativa.';
COMMENT ON COLUMN pizza.deleted_at IS 'Data e hora em que a pizza foi desativada (soft delete).';

