package com.desafio.demo.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpresaDTO {

    private Long id;
    private String nomeFantasia;

    private String cnpj;

    private String cep;

}
