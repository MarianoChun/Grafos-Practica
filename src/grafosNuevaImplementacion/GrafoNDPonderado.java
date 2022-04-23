package grafosNuevaImplementacion;

public class GrafoNDPonderado extends GrafoDPonderado{

	public GrafoNDPonderado(int vertices) {
		super(vertices);
	}

	@Override
	public void agregarArista(int i, int j) {
		verificarDistintos(i, j);
		verificarVertice(i);
		verificarVertice(j);
		
		if(!existeArista(i,j)) {
			agregarArista(i,j,0);
		}
		
	}
	
	@Override
	public void agregarArista(int i, int j, int peso) {
		verificarDistintos(i, j);
		verificarVertice(i);
		verificarVertice(j);
		
		if(!existeArista(i,j)) {
			A[i][j] = A[j][i] = true;
			pesosA[i][j] = pesosA[j][i] = peso;
		}
		
	}
	
	private void verificarDistintos(int i, int j) {
		if (i == j) {
			throw new IllegalArgumentException("Error: Los vertices deben ser distintos");
		}
	}
	
	@Override
	public void eliminarArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		
		if(existeArista(i,j)) {
			A[i][j] = A[j][i] = false;
		}
		
	}
	@Override
	public int sumatoriaPesos() {
		return super.sumatoriaPesos()/2;
	}
}
