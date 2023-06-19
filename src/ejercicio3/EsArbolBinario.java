package ejercicio3;

public class EsArbolBinario {

	public static void main(String[] args) {
		
		Node arbol = Node.construirArbolBinario();
		
		Node.imprimirArbol(arbol,"",true);
		
		if (esArbolBinario(arbol)) {
			System.out.println("El arbol ingresado es binario");
		}else {
			System.out.println("El arbol ingresado NO es binario");
		}
		
	}
	
	private static boolean esBinario(Node arbol, int min, int max) {
		
		if (arbol==null) {
			return true;
		}
		
		if ((arbol.getData()<min)||(arbol.getData()>max)) {
			return false;
		}
		
		return (esBinario(arbol.getLeft(),min,arbol.getData())) && (esBinario(arbol.getRight(),arbol.getData(),max));
		
	}
	
	public static boolean esArbolBinario(Node arbol) {
		
			return esBinario(arbol,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}

}
