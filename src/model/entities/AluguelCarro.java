package model.entities;

import java.time.LocalDateTime;

public class AluguelCarro {
	private LocalDateTime inicio;
	private LocalDateTime fim;
	
	private Veiculo veiculo;
	private NotaFiscal notaFiscal;
	
	public AluguelCarro() {}

	public AluguelCarro(LocalDateTime inicio, LocalDateTime fim, Veiculo veiculo) {
		super();
		this.inicio = inicio;
		this.fim = fim;
		this.veiculo = veiculo;
	}

	public LocalDateTime getInicio() {
		return inicio;
	}

	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}

	public LocalDateTime getFim() {
		return fim;
	}

	public void setFim(LocalDateTime fim) {
		this.fim = fim;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	
	
}
