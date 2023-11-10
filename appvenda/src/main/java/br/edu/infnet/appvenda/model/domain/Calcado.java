package br.edu.infnet.appvenda.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
@Table(name ="TCalcado")
public class Calcado extends Produto {

	@NotNull
	@PositiveOrZero
	private int numero;
	
	@NotNull
	@Size(min = 1, max = 50, message = "A cor deve ter entre {min} e {max} caracteres.")
	private String cor;
	
	@NotNull
	@Size(min = 1, max = 100, message = "A marca deve ter entre {min} e {max} caracteres.")
	private String marca;
	                                                                

	@Override
	public String toString() {
		
		return String.format("%s - %s - %s - %s", super.toString(), numero, cor, marca);
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}