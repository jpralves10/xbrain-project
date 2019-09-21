package com.xbrain.application.domain.pedido.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.xbrain.application.domain.pedido.dao.ClienteRepository;
import com.xbrain.application.domain.pedido.entity.Cliente;
import com.xbrain.application.domain.pedido.entity.ClientePK;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository dbCliente;
	
	@Transactional
	public List<Cliente> buscarListaCliente() {
		
		return dbCliente.findAll();
	}
	
	@Transactional
	public void saveCliente(String jsonCliente) {
		
		JsonParser parser = new JsonParser();
		JsonElement jsonElement = parser.parse(jsonCliente);
		
		JsonObject jObject = jsonElement.getAsJsonObject();
        Integer idCliente = jObject.get("idCliente").getAsInt();
        String nome = jObject.get("nome").getAsString();
                
        Cliente cliente = new Cliente();
        cliente.setId(new ClientePK());
        
        cliente.getId().setIdCliente(idCliente);
        cliente.setNome(nome);
		
		dbCliente.save(cliente);
	}
}