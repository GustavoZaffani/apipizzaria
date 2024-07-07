CREATE TABLE IF NOT EXISTS pizza_ingredient (
    id              UUID            PRIMARY KEY,
    pizzeria_id     UUID            NOT NULL,
    pizza_id        UUID            NOT NULL,
    ingredient_id   UUID            NOT NULL,
    quantity        NUMERIC(15, 2)  NOT NULL,
    CONSTRAINT fk_pi_pizza          FOREIGN KEY (pizza_id)      REFERENCES pizza (id),
    CONSTRAINT fk_pi_ingredient     FOREIGN KEY (ingredient_id) REFERENCES ingredient (id)
);

COMMENT ON TABLE pizza_ingredient IS 'Tabela que armazena a relação entre pizzas e ingredientes.';
COMMENT ON COLUMN pizza_ingredient.id IS 'Identificador único da relação entre pizza e ingrediente.';
COMMENT ON COLUMN pizza_ingredient.pizzeria_id IS 'Identificador da pizzaria associada ao ingrediente da pizza.';
COMMENT ON COLUMN pizza_ingredient.pizza_id IS 'Chave estrangeira referenciando a tabela de pizzas.';
COMMENT ON COLUMN pizza_ingredient.ingredient_id IS 'Chave estrangeira referenciando a tabela de ingredientes.';
COMMENT ON COLUMN pizza_ingredient.quantity IS 'Quantidade do ingrediente na pizza.';
