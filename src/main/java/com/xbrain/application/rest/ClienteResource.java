package com.xbrain.application.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xbrain.application.domain.pedido.entity.Cliente;
import com.xbrain.application.domain.pedido.service.ClienteService;

@RestController
@RequestMapping(value="/cliente")
public class ClienteResource {
	
	@Autowired
	private ClienteService serviceCliente;
	
	@RequestMapping("/listar")
	public ResponseEntity<?> obterListaCliente() {
		
		List<Cliente> listaCliente = serviceCliente.buscarListaCliente();
		
		return ResponseEntity.ok().body(listaCliente);
	}
}