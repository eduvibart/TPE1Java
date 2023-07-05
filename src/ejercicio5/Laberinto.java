package ejercicio5;

import java.awt.*;

public class Laberinto {

    private int C;
    private int F;
    private char[][] mapa;
    private boolean[][] pisados;

    /**
     * @param mapa en mapa se debe pasar el laberinto, en fomra de matriz de caracteres, ya cargada.
     * @param c refiere a las columnas de la matriz del laberinto
     * @param f son las filas de la matriz del laberinto
     */
    public void setProblema(char[][] mapa, int f, int c) {
        this.C=c;
        this.F=f;
        this.mapa = mapa;
        pisados = new boolean[C][F];
    }

    public Point inicioLaberinto() {
        for (int i = 0; i < F; i++) {
            for (int j = 0; j < C; j++) {
                if (mapa[i][j] == 'E') {
                    //int entradaFila = i;
                    //int entradaColumna = j;
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    public int recorrerLaberinto(Point actual, int mejorSolucion, int pasos){
        int fActual = actual.x;
        int cActual = actual.y;
        pisados[fActual][cActual] = true;
            if (mapa[fActual][cActual] == 'S'){
                mejorSolucion =  pasos;
                pisados[fActual][cActual] = false;
                return mejorSolucion;
            }
            if (mapa[fActual][cActual] >= 'a'&& mapa[fActual][cActual] <='z')
                for (int i = 0; i < F; i++) {
                    for (int j = 0; j < C; j++) {
                        if ( !pisados[i][j] && mapa[fActual][cActual] == mapa[i][j]){
                            int soluParcial = recorrerLaberinto(new Point(i,j), mejorSolucion, pasos+1);
                            mejorSolucion = mejorSolucion == -1 || soluParcial < mejorSolucion ? soluParcial : mejorSolucion;
                        }
                    }
                }
            int soluParcial;
            if (fActual + 1 < F && !pisados[fActual+1][cActual] && mapa[fActual+1][cActual] != '#' && (mejorSolucion == -1 || mejorSolucion > pasos+1)){
                actual.setLocation(fActual+1, cActual);
                soluParcial = recorrerLaberinto(actual, mejorSolucion, pasos+1);
                mejorSolucion = mejorSolucion == -1 || soluParcial < mejorSolucion ? soluParcial : mejorSolucion;
            }
            if (fActual - 1 >= 0 && !pisados[fActual-1][cActual] && mapa[fActual-1][cActual] != '#'&& (mejorSolucion == -1 || mejorSolucion > pasos+1)){
                actual.setLocation(fActual-1, cActual);
                soluParcial = recorrerLaberinto(actual, mejorSolucion, pasos+1);
                mejorSolucion = mejorSolucion == -1 || soluParcial < mejorSolucion ? soluParcial : mejorSolucion;
            }
            if (cActual + 1 < C && !pisados[fActual][cActual+1] && mapa[fActual][cActual+1] != '#'&& (mejorSolucion == -1 || mejorSolucion > pasos+1)){
                actual.setLocation(fActual, cActual+1);
                soluParcial = recorrerLaberinto(actual, mejorSolucion, pasos+1);
                mejorSolucion = mejorSolucion == -1 || soluParcial < mejorSolucion ? soluParcial : mejorSolucion;
            }
            if (cActual - 1 >= 0 && !pisados[fActual][cActual-1] && mapa[fActual][cActual-1] != '#'&& (mejorSolucion == -1 || mejorSolucion > pasos+1)){
                actual.setLocation(fActual, cActual-1);
                soluParcial = recorrerLaberinto(actual, mejorSolucion, pasos+1);
                mejorSolucion = mejorSolucion == -1 || soluParcial < mejorSolucion ? soluParcial : mejorSolucion;
            }
        pisados[fActual][cActual] = false;
        return mejorSolucion;
    }
}