package model.services;

public class ServicoImpostoBrasil {
	public static Double getTaxa(Double valor) {
		if (valor <= 100.00) {
			return valor * .2;
		}else {
			return valor * .15;
		}
	}
}
