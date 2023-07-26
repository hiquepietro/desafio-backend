package com.desafio.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String cnpj;

    @Column
    private String cpf;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String email;

    @JoinColumn(name = "empresa_id")

    @OneToMany
    private Empresa empresa;

    @Column
    private String rg;

    @Column
    private String dataNascimento;

    @Column(nullable = false)
    private String uf;

}
