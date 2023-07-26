package com.desafio.demo.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FornecedorDTO {

    private Long id;

    private String nome;

    private String cnpj;

    private String cep;

    private String cpf;

    private String email;

    private String rg;

    private String dataNascimento;

    private String uf;


}
