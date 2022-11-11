package Fixed;

import java.util.concurrent.Callable;

public class Fatorial implements Callable<Long>{
	private int number;

	public Fatorial(int number) {
		this.number = number;
	}

	public Long call() {
		return fatorial(this.number);
	}

	public long fatorial(int x) {
        long valor = 1;
        for (int i = 1; i < x; i++) {
        	valor = valor * i;
        }
        return valor;
    }

}
