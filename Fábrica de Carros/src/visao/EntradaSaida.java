package visao;

import modelo.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EntradaSaida {

	public static int solicitaOpcao() {
		String[] opcoesDoMenu = { "Fabricar carros", "Vender um carro", "Ver informações dos carros", "Sair" };
		JComboBox<String> menu = new JComboBox<String>(opcoesDoMenu);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a opção desejada", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();

	}

	public static int solicitaQtdeCarros() {

		int qtdeCarros = Integer.parseInt(JOptionPane.showInputDialog(
				"Quantos carros deseja fabricar? \n \n(Quantidade de carros a ser fabricados com as descrições informadas a seguir)."));
		while (qtdeCarros <= 0) {
			JOptionPane.showMessageDialog(null, "Informe um número positivo!", "Erro", JOptionPane.WARNING_MESSAGE);
			qtdeCarros = Integer.parseInt(JOptionPane.showInputDialog(
					"Quantos carros deseja fabricar? \n \n(Quantidade de carros a ser fabricados com as descrições informadas a seguir)."));
		}

		return qtdeCarros;
	}

	public static String solicitaDescricao(String descricao) {
		return JOptionPane.showInputDialog(descricao);
	}

	public static int solicitaAno() {
		return Integer.parseInt(JOptionPane.showInputDialog("Ano"));
	}

	public static void vendeCarro(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	public static int selecionaModelo(String[] arrayDeCarros) {
		return JOptionPane.showOptionDialog(null, "Informe o modelo do carro", "Modelo", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, arrayDeCarros, arrayDeCarros[0]);
	}

	public static void informacoesDoModelo(int modeloEscolhido, Carro listaDeCarros) {
		JOptionPane.showMessageDialog(null, "Marca: " + listaDeCarros.getMarca() + "\nModelo: "
				+ listaDeCarros.getModelo() + "\nAno: " + listaDeCarros.getAno() + "\nCor: " + listaDeCarros.getCor());
	}

	public static void exibeMsgEncerraPrograma() {
		JOptionPane.showMessageDialog(null, "O programa está sendo encerrado.");
	}

	public static void exibeMsgNaoHaCarros() {
		JOptionPane.showMessageDialog(null, "Não há carros fabricados.");
	}
}
