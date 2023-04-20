package com.rcm.sistemas.mscartoes.application.service;

import com.rcm.sistemas.mscartoes.domain.entity.CartaoCliente;
import com.rcm.sistemas.mscartoes.infra.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartaoClienteService {

    private final ClienteCartaoRepository cartaoRepository;

    public List<CartaoCliente> listarCartoesByCpf(String cpf) {
        return cartaoRepository.findByCpf(cpf);
    }
}
