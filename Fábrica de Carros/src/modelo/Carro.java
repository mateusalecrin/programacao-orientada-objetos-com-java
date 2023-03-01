package modelo;

public class Carro {
	private String marca;
	private String modelo;
	private String cor;
	private int ano;

	public Carro(String marca, String modelo, String cor, int ano) {
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.ano = ano;
	}

	public String getModelo() {
		return modelo;
	}

	public String getMarca() {
		return marca;
	}

	public String getCor() {
		return cor;
	}

	public int getAno() {
		return ano;
	}
}
