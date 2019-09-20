package com.xbrain.application.domain.pedido.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xbrain.application.domain.pedido.dao.PedidoDAO;
import com.xbrain.application.domain.pedido.entity.Pedido;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoDAO dbPedido;
	
	@Transactional
	public List<Pedido> buscarListaPedido() {
		
		return dbPedido.findAll();
	}
}