CREATE TABLE IF NOT EXISTS pizzeria
(
    id                   UUID               PRIMARY KEY,
    name                 VARCHAR(255)       NOT NULL,
    phone                VARCHAR(20)        NOT NULL,
    email                VARCHAR(255)       NOT NULL,
    login                VARCHAR(50)        NOT NULL,
    password             VARCHAR(255)       NOT NULL,
    street               VARCHAR(255)       NOT NULL,
    neighborhood         VARCHAR(255)       NOT NULL,
    zip_code             VARCHAR(20)        NOT NULL,
    number               VARCHAR(10),
    complement           VARCHAR(255)       NOT NULL,
    city                 VARCHAR(100)       NOT NULL,
    state                VARCHAR(50)        NOT NULL,
    active               BOOLEAN            NOT NULL DEFAULT TRUE,
    deleted_at           TIMESTAMP          NULL
);

COMMENT ON COLUMN pizzeria.id IS 'Identificador único da pizzaria';
COMMENT ON COLUMN pizzeria.name IS 'Nome da pizzaria';
COMMENT ON COLUMN pizzeria.phone IS 'Número de telefone da pizzaria';
COMMENT ON COLUMN pizzeria.email IS 'Endereço de email da pizzaria';
COMMENT ON COLUMN pizzeria.login IS 'Login para acesso à conta da pizzaria';
COMMENT ON COLUMN pizzeria.password IS 'Senha para acesso à conta da pizzaria';
COMMENT ON COLUMN pizzeria.street IS 'Rua do endereço da pizzaria';
COMMENT ON COLUMN pizzeria.neighborhood IS 'Bairro do endereço da pizzaria';
COMMENT ON COLUMN pizzeria.zip_code IS 'CEP do endereço da pizzaria';
COMMENT ON COLUMN pizzeria.number IS 'Número do endereço da pizzaria';
COMMENT ON COLUMN pizzeria.complement IS 'Complemento do endereço da pizzaria';
COMMENT ON COLUMN pizzeria.city IS 'Cidade do endereço da pizzaria';
COMMENT ON COLUMN pizzeria.state IS 'Estado do endereço da pizzaria';
COMMENT ON COLUMN pizzeria.active IS 'Indica se a pizzaria está ativa';
COMMENT ON COLUMN pizzeria.deleted_at IS 'Data de exclusão da pizzaria';
