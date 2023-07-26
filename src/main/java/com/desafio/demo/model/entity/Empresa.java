package com.desafio.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "nome_fantasia")
    private String nomeFantasia;

    @Column(nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private String cep;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Fornecedor> fornecedor;
}
