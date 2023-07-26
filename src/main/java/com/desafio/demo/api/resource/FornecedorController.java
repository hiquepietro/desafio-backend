package com.desafio.demo.api.resource;



import com.desafio.demo.api.dto.FornecedorDTO;
import com.desafio.demo.api.service.FornecedorService;
import com.desafio.demo.model.entity.Fornecedor;
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
@RequestMapping("/api/fornecedor")
public class FornecedorController {



        private final ModelMapper modelMapper;
        private final FornecedorService fornecedorService;



        public FornecedorController(ModelMapper modelMapper, FornecedorService fornecedorService) {
            this.modelMapper = modelMapper;
            this.fornecedorService = fornecedorService;
        }

        @PostMapping
        public FornecedorDTO save(@RequestBody FornecedorDTO fornecedorDTO) {

            Fornecedor entity = modelMapper.map(fornecedorDTO, Fornecedor.class);

            entity = FornecedorService.save(entity);

            return modelMapper.map(entity, FornecedorDTO.class);
        }

        @GetMapping("/{id}")
        public FornecedorDTO findById(@PathVariable Long id) {
            return FornecedorService.findById(id)
                    .map( company -> modelMapper.map(company, FornecedorDTO.class))
                    .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        }

        @PutMapping("/{id}")
        public FornecedorDTO update(@RequestBody FornecedorDTO fornecedorDTO, @PathVariable Long id){
            return fornecedorService.update(modelMapper.map(fornecedorDTO, Fornecedor.class));
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id){
            FornecedorService.delete(id);
        }

    }
}
