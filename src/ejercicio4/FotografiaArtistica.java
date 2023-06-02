package ejercicio4;

public class FotografiaArtistica {

	public static void main(String[] args) {
		char A[]= {'.', 'f', 'a', 'a', '.', 'e', '.', 'f'};
		//int X=;
		//int Y=

	}
	
	public static int fotografiaArtistica(char A[], int N, int X, int Y) {
		int resultado=0;
		int i=0;
		//recorro primero de izquierda a derecha
		while ((i<N)&&(X+i<N)) {
			if (A[i]=='f') {
				int posicionValidaArtista=i+X;
				while ((posicionValidaArtista<i+Y)&&(posicionValidaArtista<N)) {
					if (A[posicionValidaArtista]=='a') {
						int posicionValidaEscenario=posicionValidaArtista+X;
						while ((posicionValidaEscenario<posicionValidaArtista+Y)&&(posicionValidaEscenario<N)) {
							if (A[posicionValidaEscenario]=='e') {
								resultado++;
							}
							posicionValidaEscenario++;
						}
					}
					posicionValidaArtista++;
				}
			}
			i++;
		}
		//recorro de derecha a izquierda
		i=N-1;
		while((0<=i)&&(i-X>=0)) {
			if (A[i]=='f') {
				int posicionValidaArtista=i-X;
				while ((posicionValidaArtista>=0)&&(posicionValidaArtista>i-Y)) {
					if (A[posicionValidaArtista]=='a') {
						int posicionValidaEscenario=posicionValidaArtista-X;
						while((posicionValidaEscenario>posicionValidaArtista-Y)&&(posicionValidaEscenario>0)) {
							if (A[posicionValidaEscenario]=='e') {
								resultado++;
							}
							posicionValidaEscenario--;
						}
					}
					posicionValidaArtista--;
				}
			}
			i--;
		}
		
		return resultado;
	}

}
