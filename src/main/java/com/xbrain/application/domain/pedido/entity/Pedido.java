package com.xbrain.application.domain.pedido.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Pedido implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private PedidoPK id;
	
	@Column
	private Double valorTotal;
	
	@Column
	private String enderecoEntrega;

	public PedidoPK getId() {
		return id;
	}

	public void setId(PedidoPK id) {
		this.id = id;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(String enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}
}