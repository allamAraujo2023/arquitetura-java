package br.edu.infnet.appvenda.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="TRoupa")
public class Roupa extends Produto {
	
	private String tamanho;
	
	private String cor;
	
	private String tipo;
	
	
	@Override
	public String toString() {
		
		return String.format("%s - %s - %s - %s", super.toString(), tamanho, cor, tipo);
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}