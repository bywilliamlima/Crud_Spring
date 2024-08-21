package  com.william.crud_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.william.crud_spring.model.Clientes;

@Repository
public interface  ClienteRepository  extends JpaRepository<Clientes, Long> {
     
}
