package Fixed;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FixedMain {
	
	private static final int NUM_THREADS = 10;
	private static final int NUM_TERMOS = 1000;

	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		ExecutorService executor =
			Executors.newFixedThreadPool(NUM_THREADS);
		
		List<Future<BigDecimal>> results = new ArrayList<>();
		//BigDecimal result = BigDecimal.ZERO;
		for (int i = 1; i < NUM_TERMOS; ++i) {
			Callable<BigDecimal> calculator = new Fatorial(i);
			Future<BigDecimal> factorial = executor.submit(calculator);
			results.add(factorial);
		}
		
		int i = 0;
		try {
			List<BigDecimal> valores = new ArrayList<>();
			//valores.add(BigDecimal.ONE);
			for (Future<BigDecimal> result : results) {
			//	System.out.print("Factorial of " + numbers[i] + ": ");
				
				//System.out.print(result.get() + "\n");
				valores.add(result.get() );
				i++;
			}
			BigDecimal exit = BigDecimal.ZERO;
			for (BigDecimal e : valores) {
			exit = exit.add(e);
			}
			System.out.println("todas terminaram com o - valor = " + exit);
			System.out.println("número de threads = " + (Thread.activeCount()-1));
			System.out.println ("Número de Termos: " + NUM_TERMOS);
		} catch (ExecutionException | InterruptedException e) {
			e.printStackTrace();
		} finally {
			executor.shutdown();
			
			
		}
		
	}

}
