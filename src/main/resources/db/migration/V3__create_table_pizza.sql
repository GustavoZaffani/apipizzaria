CREATE TABLE IF NOT EXISTS pizza
(
    id              UUID                        PRIMARY KEY,
    name            VARCHAR(255)                NOT NULL,
    price           NUMERIC(15, 2)              NOT NULL
);

COMMENT ON TABLE pizza IS 'Tabela que armazena informações das pizzas.';

COMMENT ON COLUMN pizza.id IS 'Identificador único da pizza.';
COMMENT ON COLUMN pizza.name IS 'Nome da pizza.';
COMMENT ON COLUMN pizza.price IS 'Preço da pizza.';
