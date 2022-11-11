import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadPoolMain {

	private static final int NUM_THREADS = 50;

	private static final int NUM_TASKS = 100;


	public static void main(String[] args) {
		ExecutorService executor =
			Executors.newFixedThreadPool(NUM_THREADS);
		
		for (int i = 0; i < NUM_TASKS; i++) {
			Runnable task = new Task(String.valueOf(i));
			executor.execute(task);
		}
		
		executor.shutdown();
	}
}