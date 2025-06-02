package com.meubolso.model;

import com.meubolso.enumerate.TipoCategoriaEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "categoria_despesa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaDespesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 20, name = "TIPO")
    private TipoCategoriaEnum tipoCategoriaEnum ;

    @NotBlank
    @Size(max = 100)
    @Column(name = "DESCRICAO")
    private String descricao;

}
