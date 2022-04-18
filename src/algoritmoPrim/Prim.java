package algoritmoPrim;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import grafos.Grafo;

public class Prim {
	private Set<Integer> V = new HashSet<Integer>();
	private Grafo E; // AGM
	private Grafo g; // input
	
	public Prim(Grafo g) {
		if(!g.esGrafoConPeso()) {
			throw new IllegalArgumentException("El grafo debe tener peso");
		}
		E = new Grafo(g.tamano(), true);
		this.g = g;
	}
	public Grafo obtenerArbolGeneradorMinimo(int vertice){
		V.add(vertice);
		int i = 1;
		int uMin = vertice;
		int vMin = 0;
		int pesoMin;
		Set<Integer> vecinosU;
		
		while(i <= g.tamano() - 1) {
			pesoMin = Integer.MAX_VALUE;

			for(int u : V) {
				vecinosU = g.vecinos(u);
				if(!V.containsAll(vecinosU)) {		
					int[] aristaMin = obtenerVecinoMenorPeso(g, u, vecinosU);
					pesoMin = Math.min(pesoMin, aristaMin[2]);
					if(pesoMin == aristaMin[2]) {
						uMin = aristaMin[0];
						vMin = aristaMin[1];
					}
				}
			}

			E.agregarArista(uMin, vMin, pesoMin);
			V.add(vMin);
			i++;
		}	
		return E;	
	}

	private int[] obtenerVecinoMenorPeso(Grafo g, int vertice, Set<Integer> vecinos) {
		int vecinoMinimo = 0;
		int pesoMenor = Integer.MAX_VALUE;
		int pesoVecinoActual;
		for(int vecino : vecinos) {
			if(!esVerticeMarcado(vecino)) {
				pesoVecinoActual = g.obtenerPesoArista(vertice, vecino);
				pesoMenor = Math.min(pesoMenor, pesoVecinoActual);
				if(pesoMenor == pesoVecinoActual) {
					vecinoMinimo = vecino;
				}
			}
		}
		
		return  new int[]{vertice, vecinoMinimo, pesoMenor};
	}
	
	private boolean esVerticeMarcado(int vertice) {
		return V.contains(vertice);
	}


}
