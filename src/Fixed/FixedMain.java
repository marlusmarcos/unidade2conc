package Fixed;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FixedMain {
	
//	private static final int NUM_THREADS = 10;
//	private static final int NUM_TERMOS = 1000;

	
	public static void main(String[] args) {
		
		//RECEBENDO VALORES VIA LINHA DE COMANDO
		Scanner ler = new Scanner(System.in);
		System.out.println ("DIGITE A QUANTIDADE DE THREADS!");
		int NUM_THREADS = ler.nextInt();
		System.out.println ("AGORA, DIGITE A QUANTIDADE DE TERMOS!");
		int NUM_TERMOS = ler.nextInt();
		
		
		ExecutorService executor =
			Executors.newFixedThreadPool(NUM_THREADS);
		
		//guarda os resultados em uma lista de bigdecimal chamada results
		List<Future<BigDecimal>> results = new ArrayList<>();

		//faz o calculo de cada termo e adiciona seu valor na lista de results
		for (int i = 1; i < NUM_TERMOS; ++i) {
			Callable<BigDecimal> calculator = new Fatorial(i);
			Future<BigDecimal> factorial = executor.submit(calculator);
			results.add(factorial);
		}
		
		int i = 0;
		try {
			List<BigDecimal> valores = new ArrayList<>();

			//pega os valores da lista de resultados e guarda em uma list
			for (Future<BigDecimal> result : results) {

				valores.add(result.get() );
				i++;
			}
			//somar o número de euller
			BigDecimal exit = BigDecimal.ZERO;
			for (BigDecimal e : valores) {
			exit = exit.add(e);
			}
			System.out.println("todas terminaram com o valor de euller = " + exit);
			System.out.println("número de threads = " + (Thread.activeCount()-1));
			System.out.println ("Número de Termos: " + NUM_TERMOS);
		} catch (ExecutionException | InterruptedException e) {
			e.printStackTrace();
		} finally {
			executor.shutdown();
			
			
		}
		
	}

}
