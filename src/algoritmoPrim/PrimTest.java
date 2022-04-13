package algoritmoPrim;

import static org.junit.Assert.*;

import org.junit.Test;

import grafos.Grafo;

public class PrimTest {

	@Test
	public void AGMPrimPrimerTest() {
		Grafo g = new Grafo(9);
		g.agregarArista(0, 1);
		g.agregarArista(0, 2);
		g.agregarArista(0, 3);
		g.agregarArista(1, 3);
		g.agregarArista(1, 6);
		g.agregarArista(3, 6);
		g.agregarArista(3, 4);
		g.agregarArista(3, 5);
		g.agregarArista(3, 2);
		g.agregarArista(6, 5);
		g.agregarArista(6, 8);
		g.agregarArista(5, 7);
		g.agregarArista(5, 8);
		g.agregarArista(8, 7);
		g.agregarArista(7, 4);
		
		Grafo AGMEsperado = new Grafo(8);
		
	}

	@Test
	public void AGMPrimSegundoTest() {
		fail("Not yet implemented");
	}
}
