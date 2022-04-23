package grafosNuevaImplementacion;

import static org.junit.Assert.*;

import org.junit.Test;




public class GrafoDPonderadoTest {

	@Test
	public void obtenerPesoTest() {
		GrafoDPonderado g = new GrafoDPonderado(4);
		
		g.agregarArista(1, 2, 10);
		
		assertEquals(10, g.obtenerPesoArista(1, 2));
	}
	
	@Test
	public void obtenerPesoInversoTest() {
		GrafoDPonderado g = new GrafoDPonderado(4);
		
		g.agregarArista(1, 2, 10);
		g.agregarArista(2, 1, 4);
		
		assertEquals(4, g.obtenerPesoArista(2, 1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void obtenerPesoAristaInexistenteTest() {
		GrafoDPonderado g = new GrafoDPonderado(6);
		
		g.obtenerPesoArista(4, 5);

	}
	
	@Test
	public void agregarPesoSinEspecificarTest() {
		GrafoDPonderado g = new GrafoDPonderado(4);
		
		g.agregarArista(0, 1);
		
		assertEquals(0, g.obtenerPesoArista(0, 1));

	}

	@Test(expected = IllegalArgumentException.class)
	public void obtenerPesoAristaEliminada() {
		GrafoDPonderado g = new GrafoDPonderado(9);
		
		g.agregarArista(6, 8, 5);
		g.eliminarArista(6, 8);
		
		g.obtenerPesoArista(6, 8);

	}
	
	@Test
	public void obtenerPesoGrafoTest() {
		GrafoDPonderado g = new GrafoDPonderado(4);
		
		g.agregarArista(0, 1, 5);
		g.agregarArista(1, 2, 3);
		g.agregarArista(0, 2, 2);
		g.agregarArista(2, 3, 2);

		assertEquals(12, g.sumatoriaPesos());
	}
	
	@Test
	public void agregarAristaReflexivaTest() {
		GrafoDPonderado g = new GrafoDPonderado(3);
		g.agregarArista(1, 0, 10);
		g.agregarArista(1, 1, 20);
		
		assertTrue(g.existeArista(1, 1));
	}
	
	@Test
	public void agregarAristasSimetricasTest() {
		GrafoDPonderado g = new GrafoDPonderado(4);
		g.agregarArista(3, 1, 4);
		g.agregarArista(1, 3, 8);
		
		assertTrue(g.existeArista(1, 3) && g.existeArista(3, 1));
	}
	
	@Test
	public void pesoPrimerAristaSimetricaTest() { 
		GrafoDPonderado g = new GrafoDPonderado(3);
		g.agregarArista(1, 0, 10);
		g.agregarArista(0, 1, 20);
		
		assertEquals(10, g.obtenerPesoArista(1, 0));
	}
	
	@Test
	public void pesoSegundaAristaSimetricaTest() { 
		GrafoDPonderado g = new GrafoDPonderado(3);
		g.agregarArista(1, 0, 10);
		g.agregarArista(0, 1, 20);
		
		assertEquals(20, g.obtenerPesoArista(0, 1));
	}
	
	@Test
	public void equalsTrueGrafoConPeso() {
		GrafoDPonderado g = new GrafoDPonderado(4);
		
		g.agregarArista(0, 1, 51);
		g.agregarArista(1, 2, 25);
		g.agregarArista(2, 3, 6);
		g.agregarArista(0, 3, 5);
		
		GrafoDPonderado otroGrafo = new GrafoDPonderado(4);
		otroGrafo.agregarArista(0, 1, 51);
		otroGrafo.agregarArista(1, 2, 25);
		otroGrafo.agregarArista(2, 3, 6);
		otroGrafo.agregarArista(0, 3, 5);
		assertTrue(g.equals(otroGrafo));
	}
	
	@Test
	public void equalsFalseGrafosConYSinPeso() {
		GrafoDPonderado g = new GrafoDPonderado(4);
		
		g.agregarArista(0, 2, 51);
		g.agregarArista(1, 2, 25);
		g.agregarArista(2, 3, 6);
		g.agregarArista(1, 3, 5);
		
		GrafoDPonderado otroGrafo = new GrafoDPonderado(4);
		otroGrafo.agregarArista(0, 2);
		otroGrafo.agregarArista(1, 2);
		otroGrafo.agregarArista(2, 3);
		otroGrafo.agregarArista(1, 3);
		assertFalse(g.equals(otroGrafo));
	}
}
