package com.rcm.sistemas.apllication.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rcm.sistemas.domain.entity.Cliente;
import com.rcm.sistemas.domain.infra.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
	
	private final ClienteRepository clienteRepository;

    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> getByCPF(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }

}
