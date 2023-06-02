package ejercicio2;
import java.util.*;

public class Fibonacci {
	
	final static int MAX=90;
	final static int MIN=0;

	public static void main(String[] args) {
		
			try (Scanner scanner = new Scanner(System.in)) {
				System.out.println("Ingrese un número entero entre "+MAX+" y "+MIN);
				
				int numero = scanner.nextInt();
				if ((numero>MAX)||(numero<MIN)) {
					System.out.println("El numero no se encuentra en el rango permitido");
				}else {
			        System.out.println("El numero de Fibonacci para "+numero+" es "+fibonacci(numero));
				}
			}
	}
	
	public static int fibonacci(int n) {
		
		if (n<=1) {
			return 1;
		}
		
		int resultado=1;
		int contador=2;
		int anterior=1;
		int anteriorAnterior=1;
		
		while (contador<=n) {
			anteriorAnterior=anterior;
			anterior=resultado;
			resultado=anteriorAnterior+anterior;
			contador++;
		}
		return resultado;
	}
}
