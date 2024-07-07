package br.edu.utfpr.apppizzariaapi.infra.translation.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TranslationConstants {

    public static final String INGREDIENT_NOT_FOUND = "ingredient.not-found";
    public static final String PIZZA_NOT_FOUND = "pizza.not-found";
    public static final String PIZZA_INGREDIENTS_NOT_FOUND = "pizza.ingredients-not-found";

    public static final String PIZZERIA_LOGIN_EXISTS = "pizzeria.login-exists";

    public static final String AUTH_NO_HEADER_PRESENT = "auth.no-header-present";
    public static final String AUTH_PIZZERIA_INFORMED_NOT_FOUND = "auth.pizzeria-informed-not-found";
    public static final String AUTH_LOGIN_NOT_FOUND = "auth.login-not-found";
    public static final String AUTH_PASSWORD_INVALID = "auth.password-invalid";

    public static final String SALE_PIZZAS_NOT_FOUND = "sale.pizzas-not-found";
    public static final String SALE_INSUFFICIENT_INGREDIENTS = "sale.insufficient-ingredients";

    public static final String REGISTER_INVALID_FIELDS = "register.invalid-fields";
}
