package ejercicio2;
import java.util.*;

public class Fibonacci {
	


	public static void main(String[] args) {
		
			try (Scanner scanner = new Scanner(System.in)) {
				System.out.println("Ingrese un numero entero");
				
				int numero = scanner.nextInt();
				
			    System.out.println("El numero de Fibonacci para "+numero+" es "+fibonacci(numero));
				
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
