package grafos;

import static org.junit.Assert.*;

import org.junit.Test;

public class EdicionDeAristasTest {
	@Test(expected = IllegalArgumentException.class)
	public void primerVerticeNegativoTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(-1, 3);
	}
	@Test(expected = IllegalArgumentException.class)
	public void segundoVerticeNegativoTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(4, -1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void primerVerticeExcedido() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(5, 2);
	}
	@Test(expected = IllegalArgumentException.class)
	public void segundoVerticeExcedido() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(1, 6);
	}
	@Test(expected = IllegalArgumentException.class)
	public void agregarLoopTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(1, 1);
	}
	@Test
	public void aristaExistenteTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2,3);
		
		assertTrue(grafo.existeArista(2, 3));

	}
	public void aristaExistenteOpuestaTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2,3);
		
		assertTrue(grafo.existeArista(3, 2));

	}
	@Test
	public void aristaInexistenteTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2,3);
		
		assertFalse(grafo.existeArista(4, 2));

	}
	
	@Test
	public void eliminarAristaExistenteTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 4);
		
		grafo.eliminarArista(2, 4);
		assertFalse(grafo.existeArista(2, 4));
	}
	
	@Test
	public void agregarAristaDosVecesTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2,3);
		grafo.agregarArista(2,3);
		// Los casos de test funcionan como documentacion del codigo en produccion
		assertTrue(grafo.existeArista(2, 3));

	}
	@Test
	public void eliminarAristaInexistenteTest() {
		Grafo grafo = new Grafo(5);
		
		grafo.eliminarArista(2, 4);
		assertFalse(grafo.existeArista(2, 4));
	}
	/*
	@Test
	public void obtenerVecinosTest() {
		Grafo grafo = new Grafo(5);
		
		grafo.agregarArista(2,3);
		grafo.agregarArista(4,2);
		
		assertEquals(2, grafo.vecinos(2).size());
	}
	*/

	
	@Test
	public void test() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2,3);
		grafo.agregarArista(2,4);
		// No es buena idea tener todos los casos de test en un mismo test
		// Una buena practica seria tener un assert por cada test hecho
		assertTrue(grafo.existeArista(2, 3));
		assertTrue(grafo.existeArista(3, 2));
		
		assertFalse(grafo.existeArista(1, 3));
		assertFalse(grafo.existeArista(2, 1));
	}

}
