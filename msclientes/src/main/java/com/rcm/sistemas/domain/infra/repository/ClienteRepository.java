package com.rcm.sistemas.domain.infra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rcm.sistemas.domain.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	Optional<Cliente> findByCpf(String cpf);
}
