package controle;

import java.text.SimpleDateFormat;
import java.util.Date;

import modelo.*;
import visualizacao.EntradaSaida;

public class Controladora {

	public void exibeMenu() {
		SimpleDateFormat formato = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy '|' HH:mm:ss");
		boolean verificaCodigo = false;
		String listarProdutosCadastrados = "";
		String listarEstoque = "";
		String listarCupons = "";
		String descricao = "";
		String data = "";
		int produtoEscolhido = 0;
		int desejaContinuar = 0;
		double totalVendas = 0;
		double valorTotal = 0;
		int opcoesDoMenu = 0;
		int quantidade = 0;
		double preco = 0;
		int codigo = 0;

		Loja loja = new Loja();

		do {
			opcoesDoMenu = EntradaSaida.opcoesDoMenu();
			switch (opcoesDoMenu) {

			case 0:
				// Cadastro
				do {
					descricao = EntradaSaida.solicitaDescricao();
					do {
						codigo = EntradaSaida.solicitaCodigoOuQuantidade("Código do produto:");
						verificaCodigo = loja.verificaCodigo(codigo);
					} while (verificaCodigo == true);
					preco = EntradaSaida.solicitaPreco("Preço do produto:");
					Produto produto = new Produto(descricao, codigo, preco, quantidade);
					loja.adicionarProduto(produto);
					desejaContinuar = EntradaSaida.desejaContinuar();
				} while (desejaContinuar == 0);
				break;

			case 1: // Listar
				listarProdutosCadastrados = loja.listarProdutosCadastrados();
				EntradaSaida.exibeListaCadastroEstoqueCupom(listarProdutosCadastrados);
				break;

			case 2:  // Dar entrada
				listarProdutosCadastrados = loja.listarProdutosCadastrados();
				if (listarProdutosCadastrados.equalsIgnoreCase("Não há produtos cadastrados")) {
					EntradaSaida.exibeListaCadastroEstoqueCupom(listarProdutosCadastrados);
				} else {
					String[] produtosCadastrados = loja.criaArrayProdutos();
					produtoEscolhido = EntradaSaida.mostraOpcoesProdutos(produtosCadastrados);
					quantidade = EntradaSaida.solicitaCodigoOuQuantidade("Quantidade:");
					loja.darEntradaNoEstoque(produtoEscolhido, quantidade);
				}
				break;

			case 3: // Vender
				int produtosEmEstoque = loja.verificaSeHaProdutosParaVenda();

				if (produtosEmEstoque != 0) {
					String[] produtosCadastrados = loja.criaArrayProdutosParaVenda(produtosEmEstoque);
					produtoEscolhido = EntradaSaida.mostraOpcoesProdutos(produtosCadastrados);
					int quantidadeDisponivel = loja.verificaQuantidadeDisponivel(produtoEscolhido);
					descricao = loja.buscaDescricao(produtoEscolhido, descricao);
					quantidade = EntradaSaida
							.solicitaCodigoOuQuantidade("Produto: " + descricao + "\nInforme a quantidade vendida:");
					while (quantidade > quantidadeDisponivel) {
						quantidade = EntradaSaida.solicitaCodigoOuQuantidade("Disponivel em estoque somente "
								+ quantidadeDisponivel + " unidades." + "\n Informe novamente:");
					}

					loja.darSaidaNoEstoque(produtoEscolhido, quantidade);
					valorTotal = loja.calculaValorTotal(produtoEscolhido, quantidade);

					Date date = new Date();
					Cupom cupom = new Cupom();
					data = formato.format(date);
					cupom.setData(data);
					cupom.setQtdeVendida(quantidade);
					cupom.setValorTotal(valorTotal);
					cupom.setDescricao(descricao);
					loja.adicionarCupom(cupom);
				} else {
					EntradaSaida.exibeListaCadastroEstoqueCupom("Não há produtos para venda.");
				}
				break;

			case 4:
				listarEstoque = loja.listarProdutosEstoque();
				EntradaSaida.exibeListaCadastroEstoqueCupom(listarEstoque);
				break;

			case 5:
				listarCupons = loja.listarCupons();
				EntradaSaida.exibeListaCadastroEstoqueCupom(listarCupons);
				break;

			case 6:
				totalVendas = loja.calculaTodasVendas();
				if (totalVendas != 0) {
					EntradaSaida.exibeTotalVendas(totalVendas);
				} else {
					EntradaSaida.exibeMsgSemVendas();
				}
			}

		} while (opcoesDoMenu != 7);
	}
}
