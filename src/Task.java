
public class Task implements Runnable{

	private final String id;
	
	public Task (String id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread " + Thread.currentThread().getId() +
				" executing task " + id);
		
	}

}
