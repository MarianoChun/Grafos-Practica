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
		
		Grafo AGMResultante = new Prim(g).obtenerArbolGeneradorMinimo(0);
		
		assertEquals(AGMEsperado, AGMResultante);
	}
	
	@Test
	public void AGMPrimSegundoTest() {
		Grafo g = new Grafo(5, true);
		g.agregarArista(0, 1, 15);
		g.agregarArista(0, 2, 20);
		g.agregarArista(1, 2, 4);
		
		g.agregarArista(2, 3, 20);
		g.agregarArista(2, 4, 20);
		g.agregarArista(3, 4, 30);

		Grafo AGMEsperado = new Grafo(5, true);
		AGMEsperado.agregarArista(0, 1, 15);
		AGMEsperado.agregarArista(1, 2, 4);
		AGMEsperado.agregarArista(2, 3, 20);
		AGMEsperado.agregarArista(2, 4, 20);
		
		Grafo AGMResultante = new Prim(g).obtenerArbolGeneradorMinimo(0);
	
		assertEquals(AGMEsperado, AGMResultante);	
	}
	
	@Test
	public void AGMPrimPesoTest() {
		Grafo g = new Grafo(5, true);
		g.agregarArista(0, 1, 10);
		g.agregarArista(0, 2, 1);
		g.agregarArista(0, 3, 15);

		g.agregarArista(2, 3, 5);
		g.agregarArista(2, 4, 2);
		
		g.agregarArista(3, 1, 6);
		g.agregarArista(3, 4, 8);
		
		g.agregarArista(4, 1, 7);

		int pesoResultanteAGM = new Prim(g).obtenerArbolGeneradorMinimo(0).peso();
		assertEquals(14, pesoResultanteAGM);	
	}

}
