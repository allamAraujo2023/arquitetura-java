package br.edu.infnet.appvenda.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name ="TRoupa")
public class Roupa extends Produto {
	
	@NotNull
	private String tamanho;
	
	@NotNull
	@Size(min = 1, max = 50, message = "A cor deve ter entre {min} e {max} caracteres.")
	private String cor;
	
	@NotNull
	@Size(min = 1, max = 100, message = "O tipo deve ter entre {min} e {max} caracteres.")
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