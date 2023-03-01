package visao;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EntradaSaida {

	public static void bemVindoAoSistema() {
		JOptionPane.showMessageDialog(null, "@--------------------------------------@" + "\nBanco Nacional"
				+ "\n@--------------------------------------@");
	}

	public static int opcoesDoMenu() {
		String[] opcoesDoMenu = { "Depósito", "Saque", "Saldo", "Dados da Conta", "Extrato Completo",
				"Extrato de Depósitos", "Extrato de Saques", "Sair" };
		JComboBox<String> menu = new JComboBox<String>(opcoesDoMenu);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a opção desejada", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
	}

	public static String solicitaTitularDaConta() {
		return JOptionPane.showInputDialog("Informe o titular da conta:");
	}

	public static int solicitaTipoConta() {
		return Integer.parseInt(JOptionPane.showInputDialog("Informe o tipo da conta (1 - Corrente | 2 - Poupança):"));
	}

	public static double solicitarInformacoesDeposito() {
		return Double.parseDouble(JOptionPane.showInputDialog("Qual o valor para depósito?"));
	}

	public static double solicitarInformacoesSaque() {

		return Double.parseDouble(JOptionPane.showInputDialog("Qual o valor do saque?"));
	}

	public static void exibirSaldo(double saldo, String date) {
		JOptionPane.showMessageDialog(null, "Seu saldo: R$" + saldo + "\n" + date);

	}

	public static void exibirDadosDaConta(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	public static void exibirExtratoCompleto(String extratoCompleto) {
		JOptionPane.showMessageDialog(null, extratoCompleto);
	}

	public static void exibirExtratoDeDepositos(String extratoDepositos) {
		JOptionPane.showMessageDialog(null, extratoDepositos);
	}

	public static void exibirExtratoDeSaques(String extratoSaques) {
		JOptionPane.showMessageDialog(null, extratoSaques);
	}

	public static void exibirMsgSemLimite() {
		JOptionPane.showMessageDialog(null,
				"Este valor excederá o limite da conta (R$ -1000.00) \nSaque não efetuado.");
	}
}
