package com.xbrain.application.domain.pedido.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Entrega implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private EntregaPK id;
	
	@Column
	private String enderecoEntrega;

	public EntregaPK getId() {
		return id;
	}

	public void setId(EntregaPK id) {
		this.id = id;
	}

	public String getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(String enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}
}