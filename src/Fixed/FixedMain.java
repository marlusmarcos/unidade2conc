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
	
	private static final int NUM_THREADS = 3;

	
	public static void main(String[] args) {
		

		ExecutorService executor =
			Executors.newFixedThreadPool(NUM_THREADS);
		
		//List<Future<BigDecimal>> results = new ArrayList<>();
		BigDecimal result = BigDecimal.ZERO;
		for (int i = 1; i < 5; ++i) {
			Callable<Long> calculator = new Fatorial(i);
			Future<Long> factorial = executor.submit(calculator);
			results.add(factorial);
		}
		
		int i = 0;
		try {
			for (Future<Long> result : results) {
				System.out.print("Factorial of " + numbers[i] + ": ");
				System.out.print(result.get() + "\n");
				i++;
			}
		} catch (ExecutionException | InterruptedException e) {
			e.printStackTrace();
		} finally {
			executor.shutdown();
		}
	}

}
