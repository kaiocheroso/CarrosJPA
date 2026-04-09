package org.example.lojacarrojpa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Carros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Informe a marca")
    private String marca;

    @NotBlank(message = "Informe o modelo")
    private String modelo;

    @NotNull(message = "informe o ano")
    @Min(value = 1000, message = "O ano deve ter 4 dígitos")
    @Max(value = 9999, message = "O ano deve ter 4 dígitos")
    private int ano;

    @NotNull(message = "informe o preco")
    @Min(value = 5000, message = "Ta muito barato")
    private Double preco;

    @NotNull(message = "informe se o carro esta disponivel")
    private Boolean disponibilidade;

    @Transient
    private Double margemLucro;

    @PrePersist
    @PreUpdate
    public void calcularMargem(){
        this.margemLucro = preco * 0.20;
    }

    public Carros(){}
}