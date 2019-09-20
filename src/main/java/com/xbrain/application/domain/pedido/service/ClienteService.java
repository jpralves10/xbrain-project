package com.xbrain.application.domain.pedido.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xbrain.application.domain.pedido.dao.ClienteDAO;
import com.xbrain.application.domain.pedido.entity.Cliente;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteDAO dbCliente;
	
	@Transactional
	public List<Cliente> buscarListaCliente() {
		
		return dbCliente.findAll();
	}
}