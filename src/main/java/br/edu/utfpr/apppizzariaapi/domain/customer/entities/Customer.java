package br.edu.utfpr.apppizzariaapi.domain.customer.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Entity
@Table(name = "customer")
@EqualsAndHashCode(of = "id")
public class Customer {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String name;

    private String phone;

    private String email;

    private String login;
}
