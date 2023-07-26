package com.desafio.demo.api.service.impl;


import com.desafio.demo.api.dto.EmpresaDTO;
import com.desafio.demo.api.service.EmpresaService;
import com.desafio.demo.model.entity.Empresa;
import com.desafio.demo.model.entity.repository.EmpresaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    private  ModelMapper modelMapper;

    private final EmpresaRepository repository;

    public EmpresaServiceImpl(EmpresaRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }


    public EmpresaServiceImpl(EmpresaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Empresa save(Empresa empresa) {
        return repository.save(empresa);
    }

    @Override
    public Optional <Empresa> findById(Long id) {

        if (id == null) {
            throw new IllegalArgumentException("O id não pode ser nulo");
        }

        return repository.findById(id);
    }

    @Override
    public EmpresaDTO update(Empresa map) {
        if (map.getId() == null) {
            throw new IllegalArgumentException("O id não pode ser nulo");
        }

        return modelMapper.map(repository.save(map), EmpresaDTO.class);
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("O id não pode ser nulo");
        }
        repository.deleteById(id);
    }
}
