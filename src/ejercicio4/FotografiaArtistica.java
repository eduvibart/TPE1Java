package ejercicio4;

import java.util.ArrayList;
import java.util.Scanner;

public class FotografiaArtistica {

	  public static void main(String[] args) {
	        ArrayList<Character> A = new ArrayList<>();
	        
	        Scanner scanner = new Scanner(System.in);
	        
	        System.out.println("Ingrese los valores del arreglo sin espacios (use '.', 'f', 'a' o 'e'):");
	        String entrada = scanner.nextLine();
	        
	        for (int i = 0; i < entrada.length(); i++) {
	            char caracter = entrada.charAt(i);
	            if (caracter == '.' || caracter == 'f' || caracter == 'a' || caracter == 'e') {
	                A.add(caracter);
	            } else {
	                System.out.println("Valor inválido. Se omitirá el carácter: " + caracter);
	            }
	        }

	        System.out.println("Ingrese el valor de X:");
	        int X = scanner.nextInt();

	        System.out.println("Ingrese el valor de Y:");
	        int Y = scanner.nextInt();
	        
	        int N = A.size();
	        System.out.println(fotografiaArtistica(A, N, X, Y));
	        
	        scanner.close();
	    }

    public static int fotografiaArtistica(ArrayList<Character> arreglo, int tam, int min, int max) {
        int resultado = 0;
        // Recorro primero de izquierda a derecha
        for (int indiceFot = 0; indiceFot + min < tam; indiceFot++) {
            if (arreglo.get(indiceFot) == 'f') {
                for (int indiceArt = indiceFot + min; indiceArt <= indiceFot + max && indiceArt < tam; indiceArt++) {
                    if (arreglo.get(indiceArt) == 'a') {
                        for (int indiceEscen = indiceArt + min; indiceEscen <= indiceArt + max && indiceEscen < tam; indiceEscen++) {
                            if (arreglo.get(indiceEscen) == 'e') {
                                resultado++;
                            }
                        }
                    }
                }
            }
        }
        // Recorro de derecha a izquierda
        for (int indiceFot = tam - 1; indiceFot - min > 0; indiceFot--) {

            if (arreglo.get(indiceFot) == 'f') {

                for (int indiceArt = indiceFot - min; indiceArt >= indiceFot - max && indiceArt >= 0; indiceArt--) {

                    if (arreglo.get(indiceArt) == 'a') {

                        for (int indiceEscen = indiceArt - min; indiceEscen >= indiceArt - max && indiceEscen >= 0; indiceEscen--) {

                            if (arreglo.get(indiceEscen) == 'e') {
                                resultado++;
                            }
                        }
                    }

                }
            }
        }

        return resultado;
    }

}

