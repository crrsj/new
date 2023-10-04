package com.spring.api.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.api.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
    @Query(value = "select c from Cliente c where upper(trim(c.nome)) like %?1% ") 
	List<Cliente>buscarPorNome(String name);
    @Query( value  = "select c from Cliente c where upper(trim(c.cpf)) like %?1% ")
    List<Cliente>buscarCpf(String name);
    @Query( value  = "select c from Cliente c where upper(trim(c.placa)) like %?1% ")
    List<Cliente>buscarPlaca(String name);
    
     
}
