package com.desafio.demo.api.service;


import com.desafio.demo.api.dto.FornecedorDTO;
import com.desafio.demo.model.entity.Fornecedor;

import java.util.Optional;

public interface FornecedorService {
    Fornecedor save(Fornecedor fornecedor);

    Optional<Fornecedor> findById(Long id);

    FornecedorDTO update(Fornecedor map);

    void delete(Long id);
}
