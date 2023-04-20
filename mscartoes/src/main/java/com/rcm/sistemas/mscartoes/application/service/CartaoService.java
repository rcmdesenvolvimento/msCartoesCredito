package com.rcm.sistemas.mscartoes.application.service;

import com.rcm.sistemas.mscartoes.domain.entity.Cartao;
import com.rcm.sistemas.mscartoes.infra.repository.CartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartaoService {

    private final CartaoRepository cartaoRepository;

    @Transactional
    public Cartao save(Cartao cartao) {
        return cartaoRepository.save(cartao);
    }

    public List<Cartao> getCartaoRendaMenorIgual(Long renda) {
        BigDecimal valorRenda = BigDecimal.valueOf(renda);
        return cartaoRepository.findByRendaLessThanEqual(valorRenda);
    }
}
