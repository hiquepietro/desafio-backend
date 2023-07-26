package com.desafio.demo.api.service.impl;

import com.desafio.demo.api.dto.FornecedorDTO;
import com.desafio.demo.api.service.FornecedorService;
import com.desafio.demo.model.entity.Fornecedor;
import com.desafio.demo.model.entity.repository.FornecedorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    private ModelMapper modelMapper;

    private final FornecedorRepository repository;

    public FornecedorServiceImpl(FornecedorRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }


    public FornecedorServiceImpl(FornecedorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Fornecedor save(Fornecedor fornecedor) {
        return repository.save(fornecedor);
    }

    @Override
    public Optional<Fornecedor> findById(Long id) {

        if (id == null) {
            throw new IllegalArgumentException("O id não pode ser nulo");
        }

        return repository.findById(id);
    }

    @Override
    public FornecedorDTO update(Fornecedor map) {
        if (map.getId() == null) {
            throw new IllegalArgumentException("O id não pode ser nulo");
        }

        return modelMapper.map(repository.save(map), FornecedorDTO.class);
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("O id não pode ser nulo");
        }
        repository.deleteById(id);
    }
}
