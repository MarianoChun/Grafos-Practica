package grafosNuevaImplementacion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class GrafoAbstract {
	protected boolean [][] A;
	public GrafoAbstract(int vertices) {
		this.A = new boolean[vertices][vertices];
	}
	
	public abstract void agregarArista(int i, int j);
	
	public abstract void agregarArista(int i, int j, int peso);
	
	public abstract void eliminarArista(int i, int j);
	
	public abstract int obtenerPesoArista(int i, int j);
	
	public boolean existeArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		
		return A[i][j];
	}
	
	protected void verificarExisteArista(int i, int j) {
		if(!existeArista(i,j)) {
			throw new IllegalArgumentException("Ingrese una arista existente, la arista " + i +""+ j + " no existe");
		}
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

	public int tamano() {
		return A.length;
	}
	
	protected void verificarVertice(int i) {
		if(i < 0) {
			throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);
		}
		if(i >= A.length) {
			throw new IllegalArgumentException("Los vertices deben estar entre 0 v |V| - 1");
		}
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(A);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrafoAbstract other = (GrafoAbstract) obj;
		if (!Arrays.deepEquals(A, other.A))
			return false;
		return true;
	}
	
	
	
}
