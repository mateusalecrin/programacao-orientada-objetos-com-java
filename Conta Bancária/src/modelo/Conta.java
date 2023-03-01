package modelo;

import java.util.ArrayList;

public class Conta {

	private String titularDaConta;
	private int tipoDaConta; // (1-conta poupan�a, 2-conta corrente.)
	private double saldo;
	private ArrayList<Movimentacao> listaDeMovimentacao = new ArrayList<Movimentacao>();

	// public Conta(String titularDaConta, int tipoDaConta) {
	// this.titularDaConta = titularDaConta;
	// this.tipoDaConta = tipoDaConta;
	// }
	public void setTitularDaConta(String titularDaConta) {
		this.titularDaConta = titularDaConta;
	}

	public void setTipoDaConta(int tipoDaConta) {
		this.tipoDaConta = tipoDaConta;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void setListaDeMovimentacao(ArrayList<Movimentacao> listaDeMovimentacao) {
		this.listaDeMovimentacao = listaDeMovimentacao;
	}

	public String getTitularDaConta() {
		return titularDaConta;
	}

	public int getTipoDaConta() {
		return tipoDaConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public ArrayList<Movimentacao> getListaDeMovimentacao() {
		return listaDeMovimentacao;
	}

	public void depositar(double valor) {
		saldo += valor;
	}

	public void sacar(double valor) {
		saldo -= valor;
	}

	public void geraMovimentacao(Movimentacao movimentacao) {
		listaDeMovimentacao.add(movimentacao);
	}

	public double gerarSaldo() {
		return saldo;
	}

	public String gerarDadosDaConta() {
		String conta = "Titular: " + titularDaConta + "\nTipo: ";
		if (tipoDaConta == 1) {
			conta += "Conta Corrente";
		} else {
			conta += "Conta Poupan�a";
		}
		conta += "\nSaldo: " + saldo;
		return conta;
	}

	public String gerarExtrato() {
		String extratoCompleto = "";
		String sinal = "";
		if (listaDeMovimentacao.size() != 0) {
			for (int i = 0; i < listaDeMovimentacao.size(); i++) {
				if (listaDeMovimentacao.get(i).getTipo().equals("Dep�sito")) {
					sinal = "+";
				} else {
					sinal = "-";
				}
				extratoCompleto += "-----------------" + "Movimenta��o: " + listaDeMovimentacao.get(i).getTipo()
						+ "-----------------" + "\nValor: " + sinal + " R$ " + listaDeMovimentacao.get(i).getValor()
						+ "\nData: " + listaDeMovimentacao.get(i).getData() + "\n" + "\n" + "\n";
			}

			extratoCompleto += "Saldo atual: R$" + saldo;
		} else {
			extratoCompleto = "Sem movimenta��es.";
		}
		return extratoCompleto;
	}

	public String gerarExtratoDepositos() {
		String extratoDepositos = "";
		String sinal = "+";
		if (listaDeMovimentacao.size() != 0) {
			for (int i = 0; i < listaDeMovimentacao.size(); i++) {
				if (listaDeMovimentacao.get(i).getTipo().equals("Dep�sito")) {
					extratoDepositos += "-----------------" + "Movimenta��o: " + listaDeMovimentacao.get(i).getTipo()
							+ "-----------------" + "\nValor: " + sinal + " R$ " + listaDeMovimentacao.get(i).getValor()
							+ "\nData: " + listaDeMovimentacao.get(i).getData() + "\n" + "\n" + "\n";
				}
			}
		} else {
			extratoDepositos = "Sem movimenta��es.";
		}
		return extratoDepositos;
	}

	public String gerarExtratoSaques() {
		String extratoSaques = "";
		String sinal = "-";
		if (listaDeMovimentacao.size() != 0) {
			for (int i = 0; i < listaDeMovimentacao.size(); i++) {
				if (listaDeMovimentacao.get(i).getTipo().equals("Saque")) {
					extratoSaques += "-----------------" + "Movimenta��o: " + listaDeMovimentacao.get(i).getTipo()
							+ "-----------------" + "\nValor: " + sinal + " R$ " + listaDeMovimentacao.get(i).getValor()
							+ "\nData: " + listaDeMovimentacao.get(i).getData() + "\n" + "\n" + "\n";
				}
			}
		} else {
			extratoSaques = "Sem movimenta��es.";
		}
		return extratoSaques;
	}

}
