package grafos;

import static org.junit.Assert.*;

import org.junit.Test;

public class GrafosConPesoTest {

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
}
