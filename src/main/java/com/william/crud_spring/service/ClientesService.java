package com.william.crud_spring.service;



import java.util.List; 

import org.springframework.stereotype.Service;

import com.william.crud_spring.model.Clientes;
import com.william.crud_spring.repository.ClienteRepository;



@Service
public class ClientesService {

    private final  ClienteRepository clienteRepository;

        public ClientesService(ClienteRepository clienteRepository){
            this.clienteRepository = clienteRepository;
        }
    
        
        public List<Clientes> list(){
        return clienteRepository.findAll();
    }
    
}
