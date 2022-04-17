package grafosDirigidos;

import java.util.HashSet;
import java.util.Set;

public class GrafoDirigido {
	private boolean [][] A;
	private int [][] pesosA;
	
	public GrafoDirigido(int vertices) {
		A = new boolean[vertices][vertices];
		pesosA = new int[vertices][vertices];
	}
	
	public void agregarArista(int i, int j, int peso) {
		verificarVertice(i);
		verificarVertice(j);

		A[i][j] = true;		
		pesosA[i][j] = peso;
	}

	public void eliminarArista(int i, int j) {
		verificarExisteArista(i,j);
		verificarVertice(i);
		verificarVertice(j);
		A[i][j] = false;
		
	}
	
	public boolean existeArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		return A[i][j];
	}

	public int obtenerPesoArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarExisteArista(i, j);
		
		return pesosA[i][j];
	}
	
	public Set<Integer> vecinos(int i){
		verificarVertice(i);
		Set<Integer> vecinos = new HashSet<Integer>();
		for (int col = 0; col < this.tamano();col++) if(i != col) {
			if (this.existeArista(i, col)) {
				vecinos.add(col);
			}
		}
		return vecinos;
	}
	// Testear
	public int peso() {
		int sumatoriaPesos = 0;
		for(int col = 0; col < A.length;col++) {
			for(int fila = 0; fila < A.length;fila++) {
				if(existeArista(col, fila)) {
					sumatoriaPesos += obtenerPesoArista(col, fila);
				}
			}
		}
		return sumatoriaPesos/2;
	}
	
	private void verificarExisteArista(int i, int j) {
		if(!existeArista(i,j)) {
			throw new IllegalArgumentException("Ingrese una arista existente, la arista " + i +""+ j + " no existe");
		}
	}

	public int tamano() {
		return A.length;
	}
	
	private void verificarVertice(int i) {
		if(i < 0) {
			throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);
		}
		if(i >= A.length) {
			throw new IllegalArgumentException("Los vertices deben estar entre 0 v |V| - 1");
		}
		
	}
}
