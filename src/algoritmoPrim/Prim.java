package algoritmoPrim;

import java.util.HashSet;
import java.util.Set;

import grafos.Grafo;

public class Prim {
	private static Set<Integer> V = new HashSet<Integer>();
	private static Grafo E;
	
	public static Grafo obtenerArbolGeneradorMinimo(Grafo g, int vertice){
		E = new Grafo(g.tamano(), true);
		V.add(vertice);
		int i = 1;
		int vecinoMenorPeso;
		int pesoAristaNueva;
		
		while(i <= g.tamano() - 1) {
			vecinoMenorPeso = obtenerVecinoConAristaMenorPeso(g, vertice);
			pesoAristaNueva = g.obtenerPesoArista(vertice, vecinoMenorPeso);
			E.agregarArista(vertice, vecinoMenorPeso, pesoAristaNueva);
			V.add(vecinoMenorPeso);
			vertice = vecinoMenorPeso;
			i++;
		}	
		return E;	
	}
	private static int obtenerVecinoConAristaMenorPeso(Grafo g, int vertice) {
		Set<Integer> vecinos = g.vecinos(vertice);
		int pesoMin = Integer.MAX_VALUE;
		int vecinoMin = vertice;
		int pesoVecinoActual;
		
		for (int vecino : vecinos){
			if(!V.contains((Integer)vecino)) {
				pesoVecinoActual = g.obtenerPesoArista(vertice, vecino);
				pesoMin = Math.min(pesoVecinoActual, pesoMin);
				if(pesoMin == pesoVecinoActual) {
					vecinoMin = vecino;
				}
			}
		}

		return vecinoMin;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
