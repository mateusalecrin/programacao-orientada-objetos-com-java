package visualizacao;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EntradaSaida {

	public static int opcoesDoMenu() {
		String[] opcoesDoMenu = { "Cadastrar produtos", "Produtos cadastrados", "Dar entrada", "Vender",
				"Produtos em estoque", "Visualizar cupons", "Total de vendas", "Sair" };
		JComboBox<String> menu = new JComboBox<String>(opcoesDoMenu);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a opção desejada", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
	}

	public static String solicitaDescricao() {
		return JOptionPane.showInputDialog(null, "Descrição do produto:");
	}

	public static double solicitaPreco(String msg) {
		double preco = 0;

		do {
			preco = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
		} while (preco <= 0);
		return preco;
	}

	public static int solicitaCodigoOuQuantidade(String msg) {
		int codigoQuantidade = 0;
		do {
			codigoQuantidade = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
		} while (codigoQuantidade <= 0);
		return codigoQuantidade;
	}

	public static int desejaContinuar() {
		String[] desejaContinuar = { "Sim", "Não" };
		return JOptionPane.showOptionDialog(null, "Deseja continuar?", "Cadastro de Produtos",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, desejaContinuar, desejaContinuar[0]);

	}

	public static void exibeListaCadastroEstoqueCupom(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	public static void exibeTotalVendas(double totalVendas) {
		JOptionPane.showMessageDialog(null, "Total dos cupons: R$" + totalVendas);
	}

	public static void exibeMsgSemVendas() {
		JOptionPane.showMessageDialog(null, "Não há histórico de vendas");
	}

	public static int mostraOpcoesProdutos(String[] listaProdutos) {
		return JOptionPane.showOptionDialog(null, "Informe o produto", "Produtos", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, listaProdutos, listaProdutos[0]);
	}
}
