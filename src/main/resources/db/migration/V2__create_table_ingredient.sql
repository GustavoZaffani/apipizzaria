CREATE TABLE IF NOT EXISTS ingredient
(
    id               UUID                       PRIMARY KEY,
    name             VARCHAR(255)               NOT NULL,
    description      TEXT                       NOT NULL,
    price            NUMERIC(15, 2)             NOT NULL,
    measurement_unit VARCHAR(50)                NOT NULL,
    quantity         NUMERIC(15, 2)             NOT NULL
);

COMMENT ON TABLE ingredient IS 'Tabela que armazena os ingredientes.';

COMMENT ON COLUMN ingredient.id IS 'Identificador único do ingrediente.';
COMMENT ON COLUMN ingredient.name IS 'Nome do ingrediente.';
COMMENT ON COLUMN ingredient.description IS 'Descrição do ingrediente.';
COMMENT ON COLUMN ingredient.price IS 'Preço do ingrediente.';
COMMENT ON COLUMN ingredient.measurement_unit IS 'Unidade de medida do ingrediente.';
COMMENT ON COLUMN ingredient.quantity IS 'Quantidade do ingrediente em estoque.';
