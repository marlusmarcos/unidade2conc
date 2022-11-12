package Fixed;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.concurrent.Callable;

public class Fatorial implements Callable<BigDecimal>{
	private int number;

	public Fatorial(int number) {
		this.number = number;
	}

	public BigDecimal call() {
		BigDecimal fat = (fatorial(this.number));
		//BigDecimal ONE = BigDecimal.ONE;
		//System.out.println("Thread: " + Thread.currentThread().getName());
		//System.out.println (" - valor: " + BigDecimal.valueOf(1).divide(fat, 4, RoundingMode.HALF_UP));
		return (BigDecimal.valueOf(1).divide(fat, 200, RoundingMode.HALF_UP));
	}

	public BigDecimal fatorial(int x) {
		BigDecimal valor = BigDecimal.ONE;
        for (int i = 1; i < x; i++) {
        	valor = valor.multiply(BigDecimal.valueOf(i));
        }
        return valor;
    }

}
