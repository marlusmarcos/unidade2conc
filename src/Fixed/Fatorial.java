package Fixed;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.Callable;

public class Fatorial implements Callable<BigDecimal>{
	private int number;

	public Fatorial(int number) {
		this.number = number;
	}

	public BigDecimal call() {
		BigDecimal fat = BigDecimal.valueOf(fatorial(this.number));
		BigDecimal ONE = BigDecimal.ONE;
		return (ONE.divide(fat));
	}

	public int fatorial(int x) {
		int valor = 1;
        for (int i = 1; i < x; i++) {
        	valor += valor * i;
        }
        return valor;
    }

}
