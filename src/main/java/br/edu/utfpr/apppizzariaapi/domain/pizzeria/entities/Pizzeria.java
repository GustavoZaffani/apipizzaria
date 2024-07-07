package br.edu.utfpr.apppizzariaapi.domain.pizzeria.entities;

import br.edu.utfpr.apppizzariaapi.domain.pizzeria.requests.PizzeriaCreateRequest;
import br.edu.utfpr.apppizzariaapi.domain.pizzeria.requests.PizzeriaUpdateRequest;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.UUID;

import static io.micrometer.common.util.StringUtils.isNotBlank;

@Getter
@Entity
@Table(name = "pizzeria")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Pizzeria {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String name;

    @Embedded
    private Address address;

    private String phone;

    private String email;

    private String login;

    private String password;

    public Pizzeria(PizzeriaCreateRequest request) {
        this.name = request.name();
        this.address = new Address(request.address());
        this.phone = request.phone();
        this.email = request.email();
        this.login = request.login();
        this.password = request.password();
    }

    public void update(PizzeriaUpdateRequest request) {
        if (isNotBlank(request.name())) {
            this.name = request.name();
        }

        if (request.address() != null) {
            address.update(request.address());
        }

        if (isNotBlank(request.phone())) {
            this.phone = request.phone();
        }
    }
}
