package com.meubolso.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "posto_combustivel")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostoCombustivel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(name = "NOME")
    private String nome;

    @Size(max = 20)
    @Column(name = "CNPJ")
    private String cnpj;

    @Size(max = 150)
    @Column(name = "ENDERECO")
    private String endereco;
}
