package ejercicio5;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Laberinto problema = new Laberinto();

        char[][] mapa1 =  {
                {'E', '.', '.'},
                {'.', '.', '.'},
                {'.', '.', 'S'}
            };
            char[][] mapa2 = {
                {'E', '#', '.'},
                {'.', '#', '.'},
                {'.', '#', 'S'}
            };
            char[][] mapa3 = {
                {'E', '.', 'S'},
                {'.', '.', '.'},
                {'.', '.', 'S'}
            };

            char[][] mapa4 = {
                {'S', '.', 'b', '#', 'b'},
                {'#', '#', '#', '#', 'a'},
                {'.', '.', 'E', '#', '#'},
                {'c', '#', '#', '.', 'c'},
                {'#', 'a', '.', '.', '.'}
            };

            problema.setProblema(mapa4,5,5);
            Point inicio = problema.inicioLaberinto();
            System.out.println("La posicion de inicio es : " + "("+ inicio.x+","+inicio.y+")");
            System.out.println("El laberinto se puede resolver minimamente en: " + problema.recorrerLaberinto(inicio,-1,0) + " pasos");
        }

        public void imprimirMatriz(char [][]mapa){
            for (int fila = 0; fila < mapa.length; fila++) {
                for (int columna = 0; columna < mapa[fila].length; columna++) {
                    System.out.print(mapa[fila][columna] + " ");
                }
                System.out.println();
            }
        }
}
