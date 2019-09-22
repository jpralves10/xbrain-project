package com.xbrain.application.domain.pedido.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xbrain.application.domain.pedido.dao.EntregaRepository;
import com.xbrain.application.domain.pedido.entity.Entrega;
import com.xbrain.application.domain.pedido.entity.EntregaPK;

@Service
public class EntregaService {
	
	@Autowired
	private EntregaRepository dbEntrega;
	
	@Transactional
	public List<Entrega> buscarListaEntrega() {
		return dbEntrega.findAll();
	}
	
	@Transactional
    public void receiveMessage(List<String> message) {
		
		Entrega entrega = new Entrega();
		entrega.setId(new EntregaPK());
		
		entrega.getId().setIdPedido(Integer.parseInt(message.get(0)));
		entrega.setEnderecoEntrega(message.get(1));
		
        dbEntrega.save(entrega);
    }
}