package model.services;

import java.time.Duration;

import model.entities.AluguelCarro;
import model.entities.NotaFiscal;

public class ServicoAluguel {
	private Double precoPorHora;
	private Double precoPorDia;
	
	private ServicoImpostoBrasil servicoImpostoBrasil;
	
	public ServicoAluguel() {}

	public ServicoAluguel(Double precoPorHora, Double precoPorDia, ServicoImpostoBrasil servicoImpostoBrasil) {
		this.precoPorHora = precoPorHora;
		this.precoPorDia = precoPorDia;
		this.servicoImpostoBrasil = servicoImpostoBrasil;
	}

	public Double getPrecoPorHora() {
		return precoPorHora;
	}

	public void setPrecoPorHora(Double precoPorHora) {
		this.precoPorHora = precoPorHora;
	}

	public Double getPrecoPorDia() {
		return precoPorDia;
	}

	public void setPrecoPorDia(Double precoPorDia) {
		this.precoPorDia = precoPorDia;
	}

	public ServicoImpostoBrasil getServicoImpostoBrasil() {
		return servicoImpostoBrasil;
	}

	public void setServicoImpostoBrasil(ServicoImpostoBrasil servicoImpostoBrasil) {
		this.servicoImpostoBrasil = servicoImpostoBrasil;
	}
	
	public void processarNotaFiscal(AluguelCarro aluguelCarro) {
		double duracao = Duration.between(aluguelCarro.getInicio(), aluguelCarro.getFim()).getSeconds() / 3600;
		double pagamentoBasico = 0;
		if (duracao <= 12.0) {
			pagamentoBasico = Math.ceil(duracao) * precoPorHora;
		}else if(duracao >=12.1) {
			pagamentoBasico = Math.ceil(duracao / 24) * precoPorDia;
		}
		
		double imposto = ServicoImpostoBrasil.getTaxa(pagamentoBasico);
		aluguelCarro.setNotaFiscal(new NotaFiscal(pagamentoBasico, imposto));
	}
	
	
}
