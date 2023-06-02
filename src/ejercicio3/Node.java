package ejercicio3;
import java.util.*;
public class Node {

	private int data;
	private Node left;
	private Node right;
	private static Scanner scanner = new Scanner(System.in);

	
	public Node(int data, Node left, Node right) {
		this.data=data;
		this.left=left;
		this.right=right;
	}
	
	public Node(int data) {
		this.data=data;
		this.left=null;
		this.right=null;
	}
	
	public Node getRight() {
		return right;
	}
	
	public void setRight(Node right) {
		this.right = right;
	}
	
	public Node getLeft() {
		return left;
	}
	
	public void setLeft(Node left) {
		this.left = left;
	}
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public static Node construirArbolBinario() {
        System.out.println("Ingrese el valor del nodo o -1 para un nodo nulo:");
        int valor = scanner.nextInt();

        if (valor == -1) {
            return null;
        }

        Node nodo = new Node(valor);

        System.out.println("Ingrese el subárbol izquierdo de " + valor + ":");
        nodo.left = construirArbolBinario();

        System.out.println("Ingrese el subárbol derecho de " + valor + ":");
        nodo.right = construirArbolBinario();

        return nodo;
    }
	
	public static void printBinaryTree(Node nodo, String espacio, boolean esUltimo) {
		
        if (nodo == null) {
            return;
        }

        System.out.print(espacio);
        
        if (esUltimo) {
        	
            System.out.print("└─");
            espacio += "   ";
            
        } else {
        	
            System.out.print("├─");
            espacio += "│  ";
        }

        System.out.println(nodo.data);

        printBinaryTree(nodo.left, espacio, false);
        printBinaryTree(nodo.right, espacio, true);
    }
	
	
}
