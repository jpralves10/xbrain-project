package com.xbrain.application.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xbrain.application.domain.pedido.entity.Entrega;
import com.xbrain.application.domain.pedido.service.EntregaService;

@RestController
@RequestMapping(value="/entrega")
public class EntregaResource {
	
	@Autowired
	private EntregaService serviceEntrega;
	
	@RequestMapping("/list")
	public ResponseEntity<?> obterListaEntrega() {
		
		List<Entrega> listaEntrega = serviceEntrega.buscarListaEntrega();
		
		return ResponseEntity.ok().body(listaEntrega);
	}
}