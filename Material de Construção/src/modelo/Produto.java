package modelo;

public class Produto {

	private String produtoDescricao;
	private double produtoPreco;
	private int produtoCodigo;
	private int produtoQtde;

	public String getProdutoDescricao() {
		return produtoDescricao;
	}

	public double getProdutoPreco() {
		return produtoPreco;
	}

	public int getProdutoCodigo() {
		return produtoCodigo;
	}

	public int getProdutoQtde() {
		return produtoQtde;
	}

	public void setProdutoQtde(int produtoQtde) {
		this.produtoQtde = produtoQtde;
	}

	public Produto(String descricao, int codigo, double preco, int quantidade) {
		this.produtoDescricao = descricao;
		this.produtoQtde = quantidade;
		this.produtoPreco = preco;
		this.produtoCodigo = codigo;
	}
}
