package modelo;

import java.util.ArrayList;

public class Loja {

	private ArrayList<Produto> listaDeProdutos = new ArrayList<Produto>();
	private ArrayList<Cupom> listaDeCupons = new ArrayList<Cupom>();

	public void adicionarProduto(Produto produto) {
		listaDeProdutos.add(produto);
	}

	public void adicionarCupom(Cupom cupom) {
		listaDeCupons.add(cupom);
	}

	public String listarProdutosCadastrados() {
		String listaCadastros = "";
		if (listaDeProdutos.size() != 0) {
			for (int i = 0; i < listaDeProdutos.size(); i++) {
				listaCadastros += (i + 1) + " - " + listaDeProdutos.get(i).getProdutoDescricao() + "\n";
			}
		} else {
			listaCadastros = "Não há produtos cadastrados";
		}
		return listaCadastros;
	}

	public String listarProdutosEstoque() {
		String listaEstoque = "";
		if (listaDeProdutos.size() != 0) {
			for (int i = 0; i < listaDeProdutos.size(); i++) {
				if (listaDeProdutos.get(i).getProdutoQtde() != 0) {
					listaEstoque += (i + 1) + " - " + listaDeProdutos.get(i).getProdutoDescricao() + " - "
							+ listaDeProdutos.get(i).getProdutoQtde() + "un.\n";
				}
			}
		} else {
			listaEstoque = "Não há produtos em estoque";
		}
		return listaEstoque;
	}

	public String listarCupons() {
		String listarCupons = "";
		if (listaDeCupons.size() != 0) {
			for (int i = 0; i < listaDeCupons.size(); i++) {
				listarCupons += "----------Cupons----------\n" + "Produto: " + listaDeCupons.get(i).getDescricao()
						+ "\n" + "Quantidade: " + listaDeCupons.get(i).getQtdeVendida() + "\n" + "Valor total: "
						+ listaDeCupons.get(i).getValorTotal() + "\n" + "Data: " + listaDeCupons.get(i).getData()
						+ "\n";
			}
		} else {
			listarCupons = "Não há histórico de vendas";
		}
		return listarCupons;
	}

	public void darEntradaNoEstoque(int produtoEscolhido, int quantidade) {
		listaDeProdutos.get(produtoEscolhido)
				.setProdutoQtde(listaDeProdutos.get(produtoEscolhido).getProdutoQtde() + quantidade);
	}

	public void darSaidaNoEstoque(int produtoEscolhido, int quantidade) {
		listaDeProdutos.get(produtoEscolhido)
				.setProdutoQtde(listaDeProdutos.get(produtoEscolhido).getProdutoQtde() - quantidade);
	}

	public double calculaValorTotal(int produtoEscolhido, int quantidade) {
		double preco = listaDeProdutos.get(produtoEscolhido).getProdutoPreco();
		return preco * quantidade;
	}

	public double calculaTodasVendas() {
		double totalVendas = 0;
		for (int i = 0; i < listaDeCupons.size(); i++) {
			totalVendas += listaDeCupons.get(i).getValorTotal();
		}
		return totalVendas;
	}

	public String[] criaArrayProdutos() {
		String[] arrayProdutos = new String[listaDeProdutos.size()];

		for (int i = 0; i < listaDeProdutos.size(); i++) {
			arrayProdutos[i] = listaDeProdutos.get(i).getProdutoDescricao();
		}
		return arrayProdutos;
	}

	public int verificaQuantidadeDisponivel(int produtoEscolhido) {
		int quantidadeDisponivel = listaDeProdutos.get(produtoEscolhido).getProdutoQtde();
		return quantidadeDisponivel;
	}

	public String buscaDescricao(int produtoEscolhido, String descricao) {
		return descricao = listaDeProdutos.get(produtoEscolhido).getProdutoDescricao();
	}

	public boolean verificaCodigo(int codigo) {
		boolean codigoExistente = false;
		if (listaDeProdutos.size() != 0) {
			for (int i = 0; i < listaDeProdutos.size(); i++) {
				if (listaDeProdutos.get(i).getProdutoCodigo() == codigo) {
					codigoExistente = true;
				}
			}
		}
		return codigoExistente;

	}

	public String[] criaArrayProdutosParaVenda(int produtosParaVenda) {
		String[] arrayProdutos = new String[produtosParaVenda];

		for (int i = 0; i < listaDeProdutos.size(); i++) {
			if (listaDeProdutos.get(i).getProdutoQtde() != 0) {
				arrayProdutos[i] = listaDeProdutos.get(i).getProdutoDescricao();
			}
		}
		return arrayProdutos;
	}

	public int verificaSeHaProdutosParaVenda() {
		int produtosParaVenda = 0;
		for (int i = 0; i < listaDeProdutos.size(); i++) {
			if (listaDeProdutos.get(i).getProdutoQtde() != 0) {
				produtosParaVenda += 1;
			}
		}
		return produtosParaVenda;
	}

}
