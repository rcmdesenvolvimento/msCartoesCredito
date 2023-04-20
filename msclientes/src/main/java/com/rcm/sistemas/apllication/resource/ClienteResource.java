package com.rcm.sistemas.apllication.resource;

import java.net.URI;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rcm.sistemas.apllication.representation.ClienteSaveRequest;
import com.rcm.sistemas.apllication.service.ClienteService;
import com.rcm.sistemas.domain.entity.Cliente;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteResource {

	private final ClienteService clienteService;

	@GetMapping
	public String status() {
		return "Ok";
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody ClienteSaveRequest request) {
		Cliente cliente = request.toModel();
		clienteService.save(cliente);
		URI headerLocation = ServletUriComponentsBuilder.fromCurrentRequest().query("cpf={cpf}")
				.buildAndExpand(cliente.getCpf()).toUri();
		return ResponseEntity.created(headerLocation).build();
	}

	@GetMapping(params = "cpf")
	public ResponseEntity<?> getDadosCliente(@RequestParam("cpf") String cpf) {
		Optional<Cliente> cliente = clienteService.getByCPF(cpf);
		return cliente.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(cliente);
	}

}
