package com.xbrain.application.domain.pedido.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Produto implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ProdutoPK id;
	
	@Column
	private String descricao;

	public ProdutoPK getId() {
		return id;
	}

	public void setId(ProdutoPK id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}