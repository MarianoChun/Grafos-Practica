package grafos;

import java.util.Set;

public class AlgoritmosVertices {
	
	public static boolean verticeEsUniversal(Grafo g, int vertice) {
		return g.tamano()-1 == g.vecinos(vertice).size();
	}
	
	public static boolean estanVerticesDistancia2(Grafo g, int i, int j) {
		if(g.existeArista(i, j)) { 
			return false;
		}
		
		Set<Integer> vecinos = g.vecinos(i); // O(n)
		for(int vecino : vecinos) { // O(n)
			if(g.existeArista(vecino, j)) { // Son vecinos, por lo tanto siendo vecino = k. existe arista ik y arista kj, debido a esto, i esta a distancia 2 de j
				return true;
			}
		}
		return false;
	}
}
