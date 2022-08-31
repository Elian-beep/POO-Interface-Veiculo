package app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.AluguelCarro;
import model.entities.Veiculo;
import model.services.ServicoAluguel;
import model.services.ServicoImpostoBrasil;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Entre com os dados do aluguél: ");

		System.out.print("Modelo de carro: ");
		Veiculo veiculo = new Veiculo(sc.nextLine());

		System.out.print("Data retirada (dd/MM/YYYY hh:mm): ");
		LocalDateTime inicio = LocalDateTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

		System.out.print("Data devolucao (dd/MM/YYYY hh:mm): ");
		LocalDateTime termino = LocalDateTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));	
		
		AluguelCarro aluguelCarro = new AluguelCarro(inicio, termino, veiculo);
		
		System.out.print("Informe o preço por hora: ");
		double precoPorHora = sc.nextDouble();

		System.out.print("Informe o preço por dia: ");
		double precoPorDia = sc.nextDouble();
		
		ServicoAluguel servicoAluguel = new ServicoAluguel(precoPorHora, precoPorDia, new ServicoImpostoBrasil());
		
		System.out.println();
		System.out.println("NOTA FISCAL: ");
		servicoAluguel.processarNotaFiscal(aluguelCarro);
		
		System.out.println("Pagamento Básico: "+ String.format("R$ %.2f", aluguelCarro.getNotaFiscal().getPagamentoBasico()));
		System.out.println("Imposto: "+ String.format("R$ %.2f", aluguelCarro.getNotaFiscal().getImposto()));
		System.out.println("Pagamento Total: "+ String.format("R$ %.2f", aluguelCarro.getNotaFiscal().getPagamentoTotal()));

		sc.close();

	}

}
