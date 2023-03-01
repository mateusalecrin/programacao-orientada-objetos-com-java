package controle;

import visao.EntradaSaida;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.*;

public class Controladora {

	public void exibeMenu() {
		SimpleDateFormat formato = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy '|' HH:mm:ss");
		int opcoesDoMenu = 0;
		EntradaSaida.bemVindoAoSistema();
		String titularDaConta = EntradaSaida.solicitaTitularDaConta();
		int tipoDaConta = EntradaSaida.solicitaTipoConta();
		while ((tipoDaConta > 2) || (tipoDaConta < 1)) {
			tipoDaConta = EntradaSaida.solicitaTipoConta();
		}
		Conta conta = new Conta();
		conta.setTitularDaConta(titularDaConta);
		conta.setTipoDaConta(tipoDaConta);

		do {
			opcoesDoMenu = EntradaSaida.opcoesDoMenu();

			switch (opcoesDoMenu) {

				case 0:
					String tipo = "Depósito";
					double valor = EntradaSaida.solicitarInformacoesDeposito();
					Date date = new Date();
					Movimentacao movimentacao = new Movimentacao();
					movimentacao.setValor(valor);
					movimentacao.setTipo(tipo);
					movimentacao.setData(formato.format(date));
					conta.geraMovimentacao(movimentacao);
					conta.depositar(valor);

					break;
				case 1:
					// Fazer saque

					tipo = "Saque";
					valor = EntradaSaida.solicitarInformacoesSaque();
					if ((conta.getSaldo() - valor) > -1000) {

						date = new Date();
						movimentacao = new Movimentacao();
						movimentacao.setValor(valor);
						movimentacao.setTipo(tipo);
						movimentacao.setData(formato.format(date));
						conta.geraMovimentacao(movimentacao);
						conta.sacar(valor);
					} else {
						EntradaSaida.exibirMsgSemLimite();
					}
					break;

				case 2:
					// Exibir Saldo

					date = new Date();
					double saldo = conta.gerarSaldo();
					EntradaSaida.exibirSaldo(saldo, formato.format(date));
					// porque por exmplo tenho que usar o método gerarSaldo na conta?
					break;

				case 3:
					// Exibir dados da conta

					String msg = conta.gerarDadosDaConta();
					EntradaSaida.exibirDadosDaConta(msg);
					break;

				case 4:
					// Exibir extrato completo

					String extratoCompleto = conta.gerarExtrato();
					EntradaSaida.exibirExtratoCompleto(extratoCompleto);
					break;

				case 5:
					// Exibir extrato de depositos

					String extratoDepositos = conta.gerarExtratoDepositos();
					EntradaSaida.exibirExtratoDeDepositos(extratoDepositos);
					break;

				case 6:
					// Exibir extrato de saques

					String extratoSaques = conta.gerarExtratoSaques();
					EntradaSaida.exibirExtratoDeSaques(extratoSaques);
					break;
			}
		} while (opcoesDoMenu != 7);
	}
}
