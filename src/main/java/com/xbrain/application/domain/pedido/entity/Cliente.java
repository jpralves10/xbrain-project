package com.xbrain.application.domain.pedido.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ClientePK id;
	
	@Column
	private String nome;

	public ClientePK getId() {
		return id;
	}

	public void setId(ClientePK id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}