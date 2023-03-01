package modelo;

public class Cupom {

	private String data;
	private String descricao;
	private int qtdeVendida;
	private double valorTotal;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getQtdeVendida() {
		return qtdeVendida;
	}

	public void setQtdeVendida(int qtdeVendida) {
		this.qtdeVendida = qtdeVendida;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
