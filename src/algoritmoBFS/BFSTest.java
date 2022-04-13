package algoritmoBFS;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import grafos.Grafo;

public class BFSTest {

	@Test
	public void esConexoTest() {
		Grafo g = new Grafo(5);
		g.agregarArista(0, 1);
		g.agregarArista(1, 2);
		g.agregarArista(2, 3);
		g.agregarArista(3, 4);
		
		assertEquals(true, BFS.esConexo(g));
	}
	
	@Test
	public void noEsConexoTest() {
		Grafo g = new Grafo(6);
		g.agregarArista(0, 1);
		g.agregarArista(2, 3);
		
		assertEquals(false, BFS.esConexo(g));
	}
	
	@Test
	public void vacioTest() {
		Grafo g = new Grafo(0);
		
		assertEquals(true, BFS.esConexo(g));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void esConexoNullTest() {
		BFS.esConexo(null);
	}
	
	@Test
	public void alcanzablesTest() {
		Grafo g = new Grafo(6);
		g.agregarArista(0,1);
		g.agregarArista(1,2);
		g.agregarArista(2,3);
		g.agregarArista(3,5);
	
		Set<Integer> esperados = new HashSet<Integer>();
		esperados.add(0);
		esperados.add(1);
		esperados.add(2);
		esperados.add(3);
		esperados.add(5);
		
		assertEquals(esperados, BFS.alcanzables(g, 1));
	}


}
