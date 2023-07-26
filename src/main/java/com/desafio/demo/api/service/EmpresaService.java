package com.desafio.demo.api.service;

import com.desafio.demo.api.dto.EmpresaDTO;
import com.desafio.demo.model.entity.Empresa;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface EmpresaService {
     Empresa save(Empresa empresa);

    Optional<Empresa> findById(Long id);

    EmpresaDTO update(Empresa map);

    void delete(Long id);
}
