package com.xbrain.application.domain.pedido.service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.xbrain.application.domain.pedido.dao.PedidoProdutoRepository;
import com.xbrain.application.domain.pedido.dao.PedidoRepository;
import com.xbrain.application.domain.pedido.entity.Pedido;
import com.xbrain.application.domain.pedido.entity.PedidoPK;
import com.xbrain.application.domain.pedido.entity.PedidoProduto;
import com.xbrain.application.domain.pedido.entity.PedidoProdutoPK;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository dbPedido;
	@Autowired
	private PedidoProdutoRepository dbPedidoProduto;
	
	@Transactional
	public List<Pedido> buscarListaPedido() {		
		return dbPedido.findAll();
	}
	
	@Transactional
	public void savePedido(String jsonPedido) {
		
		JsonParser parser = new JsonParser();
		JsonElement jsonElement = parser.parse(jsonPedido);

		JsonObject jObject = jsonElement.getAsJsonObject();
        Integer idCliente = jObject.get("idCliente").getAsInt();
        Double valorTotal = jObject.get("valorTotal").getAsDouble();
        String enderecoEntrega = jObject.get("enderecoEntrega").getAsString();
        
        JsonElement element = jObject.get("produtos");
        Type listType = new TypeToken<List<Integer>>() {}.getType();
        
        List<Integer> produtos = new Gson().fromJson(element, listType);

        Pedido pedido = new Pedido();
        pedido.setId(new PedidoPK());
        
        pedido.getId().setIdPedido(getIdPedido());
        pedido.getId().setIdCliente(idCliente);
        pedido.setValorTotal(valorTotal);
        pedido.setEnderecoEntrega(enderecoEntrega);
        
        dbPedido.save(pedido);
		
        produtos.forEach(item -> {
        	PedidoProduto pedidoProduto = new PedidoProduto();
        	pedidoProduto.setId(new PedidoProdutoPK());
        	
        	pedidoProduto.getId().setIdPedido(pedido.getId().getIdPedido());
        	pedidoProduto.getId().setIdProduto(item);
        	
        	dbPedidoProduto.save(pedidoProduto);
        });
	}
	
	@Transactional
	private Integer getIdPedido() {

		List<Pedido> listaPedidos = dbPedido.findAll();
		
		if(listaPedidos.size() > 0) {
			listaPedidos.sort((a, b) -> a.getId().getIdPedido().compareTo(b.getId().getIdPedido()));
			
			Stream<Pedido> stream = listaPedidos.stream();
			Pedido lastPedido = stream.reduce((first, second) -> second).orElse(null);
			
			return lastPedido.getId().getIdPedido() + 1;
		}else {
			return 0;
		}
	}
}