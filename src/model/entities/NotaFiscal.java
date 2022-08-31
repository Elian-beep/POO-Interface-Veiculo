package model.entities;

public class NotaFiscal {
	private Double pagamentoBasico;
	private Double imposto;
	
	public NotaFiscal() {}

	public NotaFiscal(Double pagamentoBasico, Double imposto) {
		super();
		this.pagamentoBasico = pagamentoBasico;
		this.imposto = imposto;
	}

	public Double getPagamentoBasico() {
		return pagamentoBasico;
	}

	public void setPagamentoBasico(Double pagamentoBasico) {
		this.pagamentoBasico = pagamentoBasico;
	}

	public Double getImposto() {
		return imposto;
	}

	public void setImposto(Double imposto) {
		this.imposto = imposto;
	}
	
	public Double getPagamentoTotal() {
		return getPagamentoBasico()+getImposto();
	}
}
