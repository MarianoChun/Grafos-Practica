package algoritmoBFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import grafos.Grafo;


public class BFS {

	private static Queue<Integer> L = new LinkedList<Integer>();
	private static Set<Integer> marcados = new HashSet<Integer>();

	
	public static boolean esConexo(Grafo g) {
		if(g == null) {
			throw new IllegalArgumentException("Se ingreso un grafo null");
		}
		if(g.tamano() == 0) {
			return true;
		}
		return g.tamano() == alcanzables(g, 0).size();
	}
	
	public static Set<Integer> alcanzables(Grafo g, int vertice) {
		L.add(vertice);
		int i; 
		while (!L.isEmpty()) {
			i = L.remove();
			marcarVertice(i);
			agregarVecinosNoMarcados(g, i);
		}
		return marcados;
	}

	private static void marcarVertice(int v) {
		marcados.add(v);
	}

	private static void agregarVecinosNoMarcados(Grafo g, int v) {
		Set<Integer> vecinos = g.vecinos(v);
		for(int vecino : vecinos) {
			if(!estaVerticeMarcado(vecino)) {
				L.add(vecino);
			}
		}
		
		
	}

	private static boolean estaVerticeMarcado(int v) {
		return marcados.contains(v);
	}
	
	
}
