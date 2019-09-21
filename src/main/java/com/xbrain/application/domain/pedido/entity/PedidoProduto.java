package com.xbrain.application.domain.pedido.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class PedidoProduto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private PedidoProdutoPK id;

	public PedidoProdutoPK getId() {
		return id;
	}

	public void setId(PedidoProdutoPK id) {
		this.id = id;
	}
}