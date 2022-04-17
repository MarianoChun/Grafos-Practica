package grafosDirigidos;

import static org.junit.Assert.*;

import org.junit.Test;

public class GrafoDirigidoTest {

	@Test
	public void agregarAristaReflexivaTest() {
		GrafoDirigido g = new GrafoDirigido(3);
		g.agregarArista(1, 0, 10);
		g.agregarArista(1, 1, 20);
		
		assertTrue(g.existeArista(1, 1));
	}
	
	@Test
	public void agregarAristasSimetricasTest() {
		GrafoDirigido g = new GrafoDirigido(4);
		g.agregarArista(3, 1, 4);
		g.agregarArista(1, 3, 8);
		
		assertTrue(g.existeArista(1, 3) && g.existeArista(3, 1));
	}
	
	@Test
	public void pesoPrimerAristaSimetricaTest() { 
		GrafoDirigido g = new GrafoDirigido(3);
		g.agregarArista(1, 0, 10);
		g.agregarArista(0, 1, 20);
		
		assertEquals(10, g.obtenerPesoArista(1, 0));
	}
	
	@Test
	public void pesoSegundaAristaSimetricaTest() { 
		GrafoDirigido g = new GrafoDirigido(3);
		g.agregarArista(1, 0, 10);
		g.agregarArista(0, 1, 20);
		
		assertEquals(20, g.obtenerPesoArista(0, 1));
	}

}
