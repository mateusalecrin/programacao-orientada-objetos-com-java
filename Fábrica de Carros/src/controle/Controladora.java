package controle;

import modelo.*;
import visao.EntradaSaida;

public class Controladora {

	public void exibeMenu() {
		int opcoesDoMenu = 0;
		String modelo = "";
		String marca = "";
		String cor = "";
		int ano = 0;

		Fabrica fabrica = new Fabrica();
		do {

			opcoesDoMenu = EntradaSaida.solicitaOpcao();

			switch (opcoesDoMenu) {
			
			case 0:
				int qtdeCarros = EntradaSaida.solicitaQtdeCarros();
				for (int i = 0; i < qtdeCarros; i++) {
					modelo = EntradaSaida.solicitaDescricao("Modelo");
					marca = EntradaSaida.solicitaDescricao("Marca");
					cor = EntradaSaida.solicitaDescricao("Cor");
					ano = EntradaSaida.solicitaAno();
					Carro carro = new Carro(marca, modelo, cor, ano);
					fabrica.constroiCarro(carro);
				}
				break;
				
			case 1:
				String msg = "";
				boolean verificaElmts = fabrica.verificaSePossuiElementos();
				if (verificaElmts == true) {
					modelo = EntradaSaida.solicitaDescricao("Modelo");
					cor = EntradaSaida.solicitaDescricao("Cor");
					boolean carroVendido = fabrica.venderCarro(modelo, cor);
					if (carroVendido == true) {
						msg = "Carro vendido.";
					} else {
						msg = "Não existe um carro com essas descrições.";
					}
					EntradaSaida.vendeCarro(msg);
				} else {
					EntradaSaida.exibeMsgNaoHaCarros();
				}
				break;
				
			case 2:
				verificaElmts = fabrica.verificaSePossuiElementos();
				if (verificaElmts == true) {
					String[] arrayDeCarros = fabrica.criaArrayDeCarros();
					int modeloEscolhido = EntradaSaida.selecionaModelo(arrayDeCarros);
					EntradaSaida.informacoesDoModelo(modeloEscolhido, fabrica.listaDeCarros.get(modeloEscolhido));
				} else {
					EntradaSaida.exibeMsgNaoHaCarros();
				}
				break;
			}
		} while (opcoesDoMenu != 3);

		EntradaSaida.exibeMsgEncerraPrograma();

		System.exit(0);
	}
}
