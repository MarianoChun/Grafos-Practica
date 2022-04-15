package grafos;

import java.util.HashSet;
import java.util.Set;

public class Grafo {
	// Representado en matriz de adyacencia
	// MatrizDeAdyacencia = A
	private boolean [][] A;
	private int [][] pesosA;
	private boolean esConPeso;
	public Grafo(int vertices) {
		A = new boolean[vertices][vertices];
	}
	
	public Grafo(int vertices, boolean esConPeso) {
		A = new boolean[vertices][vertices];
		if(esConPeso) {
			pesosA = new int[vertices][vertices];
		}
		this.esConPeso = esConPeso;
	}
	
	public void agregarArista(int i, int j) {
		verificarDistintos(i, j);
		verificarVertice(i);
		verificarVertice(j);
		A[i][j] = A[j][i] = true;
	}
	
	public void agregarArista(int i, int j, int peso) {
		verificarDistintos(i, j);
		verificarVertice(i);
		verificarVertice(j);
		verificarGrafoConPeso();
		A[i][j] = A[j][i] = true;
		
		pesosA[i][j] = pesosA[j][i] = peso;
	}

	private void verificarGrafoConPeso() {
		if(!esConPeso) {
			throw new IllegalArgumentException("Las aristas del grafo no tiene peso");
		}
	}
	
	public int obtenerPesoArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarExisteArista(i, j);
		verificarGrafoConPeso();
		
		return pesosA[i][j];
	}

	private void verificarExisteArista(int i, int j) {
		if(!existeArista(i,j)) {
			throw new IllegalArgumentException("Ingrese una arista existente, la arista " + i +""+ j + " no existe");
		}
	}

	public void eliminarArista(int i, int j) {
		verificarDistintos(i, j);
		verificarVertice(i);
		verificarVertice(j);
		A[i][j] = A[j][i] = false;
		
		if(esGrafoConPeso()) {
			pesosA[i][j] = pesosA[j][i] = 0;
		}
	}
	private boolean esGrafoConPeso() {
		return esConPeso;
	}

	public boolean existeArista(int i, int j) {

		verificarVertice(i);
		verificarVertice(j);
		return A[i][j];
	}

	public int tamano() {
		return A.length;
	}
	public Set<Integer> vecinos(int i){
		// Siempre conviene que los valores de retorno sean interfaces de java (Set, List, etc)
		// Ya que podemos utilizar ya sea un HashSet, TreeSet, etc.
		// Esto nos brinda flexibilidad de estructuras de datos
		verificarVertice(i);
		Set<Integer> vecinos = new HashSet<Integer>();
		for (int col = 0; col < this.tamano();col++) if(i != col) {
			if (this.existeArista(i, col)) {
				vecinos.add(col);
			}
		}
		return vecinos;
	}
	
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
	private void verificarDistintos(int i, int j) {
		if (i == j) {
			throw new IllegalArgumentException("Error: Los vertices deben ser distintos");
		}
	}
	
	private void verificarVertice(int i) {
		if(i < 0) {
			throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);
		}
		if(i > A.length) {
			throw new IllegalArgumentException("Los vertices deben estar entre 0 v |V| - 1");
		}
		
	}

}

