package com.rcm.sistemas.mscartoes.application.representation;

import com.rcm.sistemas.mscartoes.domain.entity.Cartao;
import com.rcm.sistemas.mscartoes.domain.enums.BandeiraCartao;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoSaveRequest {

    private Long id;
    private String nome;
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limiteBasico;

    public Cartao toModel() {
        return new Cartao(nome, bandeira, renda, limiteBasico);
    }

}
