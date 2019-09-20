package com.xbrain.application.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xbrain.application.domain.pedido.entity.Pedido;
import com.xbrain.application.domain.pedido.service.PedidoService;

@RestController
@RequestMapping(value="/pedido")
public class PedidoResource {

	@Autowired
	private PedidoService servicePedido;
	
	@RequestMapping("/listar")
	public ResponseEntity<?> obterListaPedido() {
		
		List<Pedido> listaPedido = servicePedido.buscarListaPedido();
		
		return ResponseEntity.ok().body(listaPedido);
	}
}