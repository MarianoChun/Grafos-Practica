package algoritmoPrim;

import static org.junit.Assert.*;

import org.junit.Test;

import grafos.Grafo;

public class PrimTest {

	@Test
	public void AGMPrimPrimerTest() {
		Grafo g = new Grafo(5, true);
		g.agregarArista(0, 1, 7);
		g.agregarArista(0, 2, 5);
		g.agregarArista(0, 4, 8);
		
		g.agregarArista(1, 4, 11);
		g.agregarArista(1, 2, 2);
		g.agregarArista(1, 3, 8);
		
		g.agregarArista(2, 3, 3);
		g.agregarArista(3, 4, 15);
		
		
		Grafo AGMEsperado = new Grafo(5, true);
		AGMEsperado.agregarArista(0, 2, 5);	
		AGMEsperado.agregarArista(0, 4, 8);
		AGMEsperado.agregarArista(2, 1, 2);
		AGMEsperado.agregarArista(2, 3, 3);
		
		assertEquals(AGMEsperado, Prim.obtenerArbolGeneradorMinimo(g));
	}

	
}
