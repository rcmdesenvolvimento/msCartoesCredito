package com.rcm.sistemas.mscartoes.application.resource;

import com.rcm.sistemas.mscartoes.application.representation.CartaoSaveRequest;
import com.rcm.sistemas.mscartoes.application.service.CartaoService;
import com.rcm.sistemas.mscartoes.domain.entity.Cartao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartoes")
@RequiredArgsConstructor
public class CartoesResource {

    private final CartaoService cartaoService;

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
    public ResponseEntity<List<Cartao>> getCartoesResndaAteh(@RequestParam("renda") Long renda){
        List<Cartao> cartaoRendaMenorIgual = this.cartaoService.getCartaoRendaMenorIgual(renda);
        return ResponseEntity.ok(cartaoRendaMenorIgual);

    }
}
