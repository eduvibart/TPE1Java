package ejercicio4;

public class FotografiaArtistica {

	public static void main(String[] args) {
		char A[]= {'.', 'f', 'a', '.', 'e', '.', '.', 'f'};
		int X=1;
		int Y=2;
		int N=A.length;
		System.out.println(fotografiaArtistica(A,N,X,Y));
	}
	
	public static int fotografiaArtistica(char A[], int N, int X, int Y) {
		int resultado=0;
		//recorro primero de izquierda a derecha
		for (int i = 0; i+X < N; i++) {
	        if (A[i] == 'f') {
	            for (int j = i + X; j <= i + Y && j < N; j++) {
	                if (A[j] == 'a') {
	                    for (int k = j + X; k <= j + Y && k < N; k++) {
	                        if (A[k] == 'e') {
	                            resultado++;
	                        }
	                    }
	                }
	            }
	        }
	    }
		//recorro de derecha a izquierda
		//for (int i =N-1;i)
		
		return resultado;
	}

}
