package com.william.crud_spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.william.crud_spring.model.Clientes;
import com.william.crud_spring.repository.ClienteRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(ClienteRepository clienteRepository) {
        return args -> {
			
			clienteRepository.deleteAll();

  			Clientes c = new Clientes ();

			c.setName("William Lima");
			c.setCategory("Pessoa Fisica");
			c.setCnpj("124.659.586-52");
			c.setPhone("3541-7886");

			clienteRepository.save(c);


		};

	}
}
