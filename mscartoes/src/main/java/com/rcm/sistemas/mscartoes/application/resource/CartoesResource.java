package com.rcm.sistemas.mscartoes.application.resource;

import com.ctc.wstx.evt.WstxEventReader;
import com.rcm.sistemas.mscartoes.application.representation.CartaoSaveRequest;
import com.rcm.sistemas.mscartoes.application.representation.CartoesClienteResponse;
import com.rcm.sistemas.mscartoes.application.service.CartaoClienteService;
import com.rcm.sistemas.mscartoes.application.service.CartaoService;
import com.rcm.sistemas.mscartoes.domain.entity.Cartao;
import com.rcm.sistemas.mscartoes.domain.entity.CartaoCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cartoes")
@RequiredArgsConstructor
public class CartoesResource {

    private final CartaoService cartaoService;
    private final CartaoClienteService cartaoClienteService;

    @GetMapping
    public String status() {
        return "ok";
    }

    @PostMapping
    public ResponseEntity cadastro(@RequestBody CartaoSaveRequest cartaoSaveRequest) {
        Cartao cartao = cartaoSaveRequest.toModel();
        cartaoService.save(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartao>> getCartoesResndaAteh(@RequestParam("renda") Long renda) {
        List<Cartao> cartaoRendaMenorIgual = this.cartaoService.getCartaoRendaMenorIgual(renda);
        return ResponseEntity.ok(cartaoRendaMenorIgual);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartoesClienteResponse>> getCartorsByCliente(@RequestParam("cpf") String cpf) {
        List<CartaoCliente> cartaoClientes = this.cartaoClienteService.listarCartoesByCpf(cpf);
        List<CartoesClienteResponse> list = cartaoClientes.stream()
                .map(CartoesClienteResponse::fromModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }
}
