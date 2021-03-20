package com.fatec.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
	private static final long serialVersionUID = -1458117513014624324L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	@OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="ficha", nullable = false)
    private Ficha ficha;
	
	public Cliente(Long id, Ficha ficha) {
		super();
		this.id = id;
		this.ficha = ficha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ficha getFicha() {
		return ficha;
	}

	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}
	
	
}

