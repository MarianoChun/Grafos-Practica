package grafos;

import static org.junit.Assert.*;

import org.junit.Test;

public class GrafosTest {

	@Test
	public void obtenerPesoTest() {
		Grafo g = new Grafo(4,true);
		
		g.agregarArista(1, 2, 10);
		
		assertEquals(10, g.obtenerPesoArista(1, 2));
	}
	
	@Test
	public void obtenerPesoInversoTest() {
		Grafo g = new Grafo(4,true);
		
		g.agregarArista(1, 2, 10);
		
		assertEquals(10, g.obtenerPesoArista(2, 1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void obtenerPesoAristaInexistenteTest() {
		Grafo g = new Grafo(6,true);
		
		g.obtenerPesoArista(4, 5);

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void agregarPesoAGrafoSinPesosTest() {
		Grafo g = new Grafo(4,false);
		
		g.agregarArista(0, 1, 12);

	}

	@Test(expected = IllegalArgumentException.class)
	public void obtenerPesoAristaEliminada() {
		Grafo g = new Grafo(9,true);
		
		g.agregarArista(6, 8, 5);
		g.eliminarArista(8, 6);
		
		g.obtenerPesoArista(6, 8);

	}
	
	@Test
	public void obtenerPesoGrafoTest() {
		Grafo g = new Grafo(4,true);
		
		g.agregarArista(0, 1, 5);
		g.agregarArista(1, 2, 3);
		g.agregarArista(0, 2, 2);
		g.agregarArista(2, 3, 2);

		assertEquals(12, g.peso());
	}
	
	@Test
	public void equalsTrueGrafoConPeso() {
		Grafo g = new Grafo(4,true);
		
		g.agregarArista(0, 1, 51);
		g.agregarArista(1, 2, 25);
		g.agregarArista(2, 3, 6);
		g.agregarArista(0, 3, 5);
		
		Grafo otroGrafo = new Grafo(4, true);
		otroGrafo.agregarArista(0, 1, 51);
		otroGrafo.agregarArista(1, 2, 25);
		otroGrafo.agregarArista(2, 3, 6);
		otroGrafo.agregarArista(0, 3, 5);
		assertTrue(g.equals(otroGrafo));
	}
	
	@Test
	public void equalsFalseGrafosConYSinPeso() {
		Grafo g = new Grafo(4,true);
		
		g.agregarArista(0, 2, 51);
		g.agregarArista(1, 2, 25);
		g.agregarArista(2, 3, 6);
		g.agregarArista(1, 3, 5);
		
		Grafo otroGrafo = new Grafo(4, false);
		otroGrafo.agregarArista(0, 2);
		otroGrafo.agregarArista(1, 2);
		otroGrafo.agregarArista(2, 3);
		otroGrafo.agregarArista(1, 3);
		assertFalse(g.equals(otroGrafo));
	}
}
