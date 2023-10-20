package br.edu.infnet.appvenda.model.domain;

public class Calcado extends Produto {

	private int numero;
	
	private String cor;
	
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