package com.desafio.demo.api.resource;

import com.desafio.demo.api.dto.EmpresaDTO;
import com.desafio.demo.api.service.EmpresaService;
import com.desafio.demo.model.entity.Empresa;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {

    private final ModelMapper modelMapper;
    private final EmpresaService empresaService;



    public EmpresaController(ModelMapper modelMapper, EmpresaService empresaService) {
        this.modelMapper = modelMapper;
        this.empresaService = empresaService;
    }

    @PostMapping
    public EmpresaDTO save(@RequestBody EmpresaDTO empresaDTO) {

        Empresa entity = modelMapper.map(empresaDTO, Empresa.class);
        entity = EmpresaService.save(entity);

        return modelMapper.map(entity, EmpresaDTO.class);
    }

    @GetMapping("/{id}")
    public EmpresaDTO findById(@PathVariable Long id) {
        return empresaService.findById(id)
                .map( company -> modelMapper.map(company, EmpresaDTO.class))
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public EmpresaDTO update(@RequestBody EmpresaDTO empresaDTO, @PathVariable Long id){
        return empresaService.update(modelMapper.map(empresaDTO, Empresa.class));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        empresaService.delete(id);
    }



}
