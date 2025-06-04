package com.meubolso.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MES_REFERENCIA", uniqueConstraints = @UniqueConstraint(columnNames = {"ano", "mes"}))
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class MesReferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ano")
    @NonNull
    private String ano;

    @Column(name = "mes")
    @NonNull
    private String mes;

    public MesReferencia(Long id) {
        this.id = id;
    }
}
