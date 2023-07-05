package ejercicio1;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PalabraMasUsada {

	public static void main(String[] args) {
		
		try (Scanner lector = new Scanner(System.in)) {
			
			System.out.println("Ingrese el nombre del archivo del cual se quiere leer");
			String nombreArchivo = lector.nextLine();
			String dir = System.getProperty("user.dir");
			String ruta = dir + File.separator + "src" + File.separator+ "ejercicio1" + File.separator + "entradas" + File.separator + nombreArchivo + ".txt";

			
			StringBuilder entrada = new StringBuilder();

			try (BufferedReader reader = new BufferedReader(new FileReader(new File(ruta)))) {
				
			    String line;
			    
			    while ((line = reader.readLine()) != null) {
			        entrada.append(line).append("\n");
			    }
			    
			} catch (IOException e) {
			    e.printStackTrace();
			}

			String texto = entrada.toString();
			System.out.println("La palabra mas repetida es: "+"'"+ palabraMasUsada(3, texto)+"'");
		}
		
	}

	public static String palabraMasUsada(int N, String texto) {
		
		String resultado = "";
		texto+=" ";
		StringBuilder palabraActual = new StringBuilder();
		int cantidadMax = 0;
		HashMap<String,Integer> palabras=new HashMap<String,Integer>();
		
		for (char letra : texto.toCharArray())  {
			
			if ((!Character.isLetter(letra)) && (palabraActual.length()>=N)){
				
				String palabraMinus = palabraActual.toString().toLowerCase();
				
				if ( palabras.containsKey(palabraMinus)) {
					
					int cantidad = palabras.getOrDefault(palabraMinus,0) + 1;
					
					if (cantidad>cantidadMax) {
						
						cantidadMax=cantidad;
						resultado=palabraMinus;
					}
					
					palabras.put(palabraMinus, cantidad);
					
					
				} else {
					
					palabras.put(palabraMinus, 1);
					
				}
				palabraActual.delete(0, palabraActual.length());
			} else if ((!Character.isLetter(letra)) && (palabraActual.length()<N)) {
				palabraActual.delete(0, palabraActual.length());
			}else {
				palabraActual.append(letra);
			}
		}
		return resultado;
		
	}
	
}
