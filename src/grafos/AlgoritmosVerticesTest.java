package grafos;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlgoritmosVerticesTest {

	@Test
	public void verticeUniversalTest() {
		Grafo g = new Grafo(5);
		g.agregarArista(0, 1);
		g.agregarArista(0, 2);
		g.agregarArista(0, 3);
		g.agregarArista(0, 4);
		
		assertEquals(true, AlgoritmosVertices.verticeEsUniversal(g, 0));
	}
	
	@Test
	public void verticeNoUniversalTest() {
		Grafo g = new Grafo(5);
		g.agregarArista(0, 1);
		g.agregarArista(0, 2);
		g.agregarArista(3, 2);
		
		assertEquals(false, AlgoritmosVertices.verticeEsUniversal(g, 0));
	}
	
	@Test
	public void verticesEstanADistancia2Test() {
		Grafo g = new Grafo(6);
		g.agregarArista(1, 2);
		g.agregarArista(2, 3);
		
		assertEquals(true, AlgoritmosVertices.estanVerticesDistancia2(g, 1, 3));
	}
	
	@Test
	public void verticesEstanADistancia1Test() {
		Grafo g = new Grafo(4);
		g.agregarArista(0, 1);
		g.agregarArista(1, 2);
		g.agregarArista(2, 3);
		g.agregarArista(3, 1);
		
		assertEquals(false, AlgoritmosVertices.estanVerticesDistancia2(g, 0, 1));
	}
	
	@Test
	public void verticesNoEstanADistancia3Test() {
		Grafo g = new Grafo(4);
		g.agregarArista(0, 1);
		g.agregarArista(1, 2);
		g.agregarArista(2, 3);
		
		
		assertEquals(false, AlgoritmosVertices.estanVerticesDistancia2(g, 0, 3));
	}
}
