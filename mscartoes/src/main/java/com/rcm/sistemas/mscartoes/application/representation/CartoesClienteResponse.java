package com.rcm.sistemas.mscartoes.application.representation;

import com.rcm.sistemas.mscartoes.domain.entity.Cartao;
import com.rcm.sistemas.mscartoes.domain.entity.CartaoCliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartoesClienteResponse {

    private String nome;
    private String bandeira;
    private BigDecimal limiteLiberado;

    public static CartoesClienteResponse fromModel(CartaoCliente cartaoCliente) {
        return new CartoesClienteResponse(
                cartaoCliente.getCartao().getNome(),
                cartaoCliente.getCartao().getBandeira().toString(),
                cartaoCliente.getLimite()
        );
    }
}
