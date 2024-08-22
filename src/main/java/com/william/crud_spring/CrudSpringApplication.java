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
			c.setCnpj("112.113.114-55");
			c.setPhone("(81) 3333-7777");
			c.setIe("123456789");
			

			clienteRepository.save(c);


		};

	}
}
