package grafosNuevaImplementacion;

import java.util.Arrays;

public class GrafoDirigidoPonderado extends GrafoAbstract{
	private int[][] pesosA;
	public GrafoDirigidoPonderado(int vertices) {
		super(vertices);
		this.pesosA = new int[vertices][vertices];
	}

	@Override
	public void agregarArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		
		if(!existeArista(i,j)) {
			agregarArista(i,j,0);
		}
		
	}

	@Override
	public void agregarArista(int i, int j, int peso) {
		verificarVertice(i);
		verificarVertice(j);
		
		if(!existeArista(i,j)) {
			A[i][j] = true;
			pesosA[i][j] = peso;
		}
		
	}

	@Override
	public void eliminarArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		
		if(existeArista(i,j)) {
			A[i][j] = false;
		}
		
	}

	@Override
	public int obtenerPesoArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarExisteArista(i, j);
		
		return pesosA[i][j];
	}
	
	public int sumatoriaPesos() {
		int sumatoriaPesos = 0;
		for(int col = 0; col < A.length;col++) {
			for(int fila = 0; fila < A.length;fila++) {
				if(existeArista(col, fila)) {
					sumatoriaPesos += obtenerPesoArista(col, fila);
				}
			}
		}
		return sumatoriaPesos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.deepHashCode(pesosA);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrafoDirigidoPonderado other = (GrafoDirigidoPonderado) obj;
		if (!Arrays.deepEquals(pesosA, other.pesosA))
			return false;
		return true;
	}
	
	
}
