package br.edu.utfpr.apppizzariaapi.infra.cache;

import java.util.UUID;

public class AuthenticationContext {
    private static final ThreadLocal<UUID> PIZZERIA_ID = new ThreadLocal<>();

    public static UUID getPizzeriaId() {
        return PIZZERIA_ID.get();
    }

    public static void setPizzeriaId(UUID value) {
        PIZZERIA_ID.set(value);
    }

    public static void clear() {
        PIZZERIA_ID.remove();
    }
}
