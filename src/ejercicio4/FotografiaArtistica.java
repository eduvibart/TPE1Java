package ejercicio4;

public class FotografiaArtistica {

	public static void main(String[] args) {
		char A[]= {'.', 'f', 'a', 'e', 'e', 'a', '.', 'f'};
		int X=1;
		int Y=2;
		int N=A.length;
		System.out.println(fotografiaArtistica(A,N,X,Y));
	}
	
	public static int fotografiaArtistica(char arreglo[], int tam, int min, int max) {
		int resultado=0;
		//recorro primero de izquierda a derecha
		for (int indiceFot = 0; indiceFot+min < tam; indiceFot++) {
	        if (arreglo[indiceFot] == 'f') {
	            for (int indiceArt = indiceFot + min; indiceArt <= indiceFot + max && indiceArt < tam; indiceArt++) {
	                if (arreglo[indiceArt] == 'a') {
	                    for (int indiceEscen = indiceArt + min; indiceEscen <= indiceArt + max && indiceEscen < tam; indiceEscen++) {
	                        if (arreglo[indiceEscen] == 'e') {
	                            resultado++;
	                        }
	                    }
	                }
	            }
	        }
	    }
		//recorro de derecha a izquierda
		for (int indiceFot = tam-1; indiceFot-min>0; indiceFot--) {
			
			if (arreglo[indiceFot]=='f') {
				
				for (int indiceArt=indiceFot-min;indiceArt>=indiceFot-max && indiceArt>=0; indiceArt--) {
					
	                if (arreglo[indiceArt] == 'a') {
	                	
	                	for (int indiceEscen = indiceArt-min;indiceEscen>=indiceArt-max && indiceEscen>=0;indiceEscen--) {
	                		
	                		if (arreglo[indiceEscen] == 'e') {
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
