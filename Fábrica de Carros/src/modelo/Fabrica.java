package modelo;

import java.util.ArrayList;
import java.util.List;

public class Fabrica {

	public List<Carro> listaDeCarros = new ArrayList<Carro>();

	public void constroiCarro(Carro carro) {
		listaDeCarros.add(carro);
	}

	public boolean venderCarro(String modelo, String cor) {
		boolean carroVendido = false;
		for (int i =0; i< listaDeCarros.size(); i++) {
			if ((listaDeCarros.get(i).getModelo().equals(modelo)) && (listaDeCarros.get(i).getCor().equals(cor))) {
				listaDeCarros.remove(listaDeCarros.get(i));
				carroVendido = true;
			}
		}
		return carroVendido;
	}

	public List<Carro> getListaDeCarros() {
		return listaDeCarros;
	}

	public Carro getCarro(int index) {
		return listaDeCarros.get(index);
	}

	public String[] criaArrayDeCarros() {
		int qtdeModelos = listaDeCarros.size();
		String[] arrayDeCarros = new String[qtdeModelos];

		for (int i = 0; i < qtdeModelos; i++) {
			arrayDeCarros[i] = listaDeCarros.get(i).getModelo();
		}
		return arrayDeCarros;
	}

	public boolean verificaSePossuiElementos() {
		boolean elementosVerificador = false;
		int qtdeElementos = 0;
		qtdeElementos = listaDeCarros.size();
		if (qtdeElementos != 0) {
			elementosVerificador = true;
		}
		return elementosVerificador;
	}
}
