package com.william.crud_spring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.william.crud_spring.model.Clientes;
import com.william.crud_spring.repository.ClienteRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;

@Validated 
@RestController
@RequestMapping("/api/clientes")
@AllArgsConstructor
public class ClientesController {

    
    private final  ClienteRepository clienteRepository;

   
    


    @GetMapping
    public List<Clientes> list(){
        return clienteRepository.findAll();
    }

    @GetMapping("/{name}")


    public ResponseEntity<Clientes> findByClientes(@PathVariable Long name) {
        return clienteRepository.findById(name)
            .map(recordFound -> ResponseEntity.ok().body(recordFound))
            .orElse(ResponseEntity.notFound().build());

    }


    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Clientes create(@RequestBody @Valid Clientes clientes){

       return clienteRepository.save(clientes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clientes> update(@PathVariable @NotNull @Positive Long id,
        @RequestBody @Valid Clientes clientes){
          return clienteRepository.findById(id)
            .map(recordFound -> {
                recordFound.setName(clientes.getName());
                recordFound.setCategory(clientes.getCategory());
                recordFound.setCnpj(clientes.getCnpj());
                Clientes update	 = clienteRepository.save(recordFound);
                return  ResponseEntity.ok().body(update);
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete (@PathVariable @NotNull @Positive Long id) {
            
            return clienteRepository.findById(id)
            .map(recordFound -> {

                clienteRepository.deleteById(id);

                return  ResponseEntity.noContent().<Void>build();
            })
            .orElse(ResponseEntity.notFound().build());

    }

}
