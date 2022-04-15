package algoritmoPrim;

import static org.junit.Assert.*;

import org.junit.Test;

import grafos.Grafo;

public class PrimTest {

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

		
		assertEquals(16, Prim.obtenerArbolGeneradorMinimo(g, 0).peso());
		
	}
}
