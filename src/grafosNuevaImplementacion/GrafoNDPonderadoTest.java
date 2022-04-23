package grafosNuevaImplementacion;

import static org.junit.Assert.*;

import org.junit.Test;

public class GrafoNDPonderadoTest {

	@Test
	public void obtenerPesoTest() {
		GrafoNDPonderado g = new GrafoNDPonderado(4);
		
		g.agregarArista(2, 3, 30);
		
		assertEquals(30, g.obtenerPesoArista(2, 3));
	}
	
	@Test
	public void obtenerPesoInversoTest() {
		GrafoNDPonderado g = new GrafoNDPonderado(4);
		
		g.agregarArista(1, 2, 10);
		g.agregarArista(2, 1, 4);
		
		assertEquals(10, g.obtenerPesoArista(2, 1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void obtenerPesoAristaInexistenteTest() {
		GrafoNDPonderado g = new GrafoNDPonderado(6);
		
		g.obtenerPesoArista(2, 0);

	}
	
	@Test
	public void agregarPesoSinEspecificarTest() {
		GrafoNDPonderado g = new GrafoNDPonderado(4);
		
		g.agregarArista(2, 3);
		
		assertEquals(0, g.obtenerPesoArista(2, 3));

	}

	@Test(expected = IllegalArgumentException.class)
	public void obtenerPesoAristaEliminada() {
		GrafoNDPonderado g = new GrafoNDPonderado(9);
		
		g.agregarArista(0, 1, 2);
		g.eliminarArista(1, 0);
		
		g.obtenerPesoArista(0, 1);

	}
	
	@Test
	public void obtenerPesoGrafoTest() {
		GrafoNDPonderado g = new GrafoNDPonderado(4);
		
		g.agregarArista(0, 1, 5);
		g.agregarArista(1, 2, 3);
		g.agregarArista(0, 2, 2);
		g.agregarArista(2, 3, 2);

		assertEquals(12, g.sumatoriaPesos());
	}

}
