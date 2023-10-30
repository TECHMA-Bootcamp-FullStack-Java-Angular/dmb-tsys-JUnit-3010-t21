package geometria.dto.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import geometria.dto.Geometria;


public class GeometriaTest {

	
	Geometria geo;

	@BeforeEach
	public void before() {
		geo = new Geometria();
	}
	


	private final int DELTA = 1;
	
	
	// Contructores

	@Test
	void testGeometriaInt() {
		int id = 3;
		String figura = "Triangulo";
		double area = 0.00;
		Geometria geotest = new Geometria(3);

		assertEquals(id, geotest.getId());
		assertEquals(figura, geotest.getNom());
		assertEquals(area, geotest.getArea());
		
	}

	@Test
	void testGeometria() {
		Geometria geotest = new Geometria();
		String nombreEsperado = "Default";
		int idEsperada = 9;
		double areaEsperada = 0.00;
		assertEquals(nombreEsperado, geotest.getNom());
		assertEquals(idEsperada, geotest.getId());
		assertEquals(areaEsperada, geotest.getArea());
	}

	// Tests metodos

	@Test
	public void TestAreacuadrado() {
		int resultado = geo.areacuadrado(2);
		int esperado = 4;
		assertEquals(esperado, resultado , DELTA);
		assertNotEquals(++esperado, resultado);
	}

	@Test
	public void TestAreaCirculo() {
		double resultado = geo.areaCirculo(2);
		double esperado = 12.5664;
		assertEquals(esperado, resultado , DELTA);
		assertNotEquals(++esperado, resultado);
	}

	@Test
	public void TestAreaTriangulo() {
		int resultado = geo.areatriangulo(12, 15);
		int esperado = 90;
		assertEquals(esperado, resultado , DELTA);
		assertNotEquals(++esperado, resultado);
	}

	@Test
	public void TestAreaRectangulo() {
		int resultado = geo.arearectangulo(5, 10);
		int esperado = 50;
		assertEquals(esperado, resultado , DELTA);
		assertNotEquals(++esperado, resultado);
	}

	@Test
	public void TestAreaPentagono() {
		int resultado = geo.areapentagono(50, 2);
		int esperado = 50;
		assertEquals(esperado, resultado , DELTA);
		assertNotEquals(++esperado, resultado);
	}

	@Test
	public void TestAreaRombo() {
		int resultado = geo.arearombo(50, 2);
		int esperado = 50;
		assertEquals(esperado, resultado , DELTA);
		assertNotEquals(++esperado, resultado);
	}

	@Test
	public void TestAreaRomboide() {
		int resultado = geo.arearomboide(5, 10);
		int esperado = 50;
		assertEquals(esperado, resultado , DELTA);
		assertNotEquals(++esperado, resultado);
	}

	@Test
	public void TestAreaTrapecio() {
		int resultado = geo.areatrapecio(3, 3, 5);
		int esperado = 15;
		assertEquals(esperado, resultado , DELTA);
		assertNotEquals(++esperado, resultado);
	}

	@Test
	void testFigura() {

		String[] esperado = { "Cuadrado", "Circulo", "Triangulo", "Rectangulo", "Pentagono", "Rombo", "Romboide",
				"Trapecio", "Default" };

		for (int i = 0; i < esperado.length; i++) {
			assertEquals(esperado[i], geo.figura(i+1));
		}

	}
	
	// Getteres y Setters 

	@Test
	void testGetId() {
		int id = geo.getId();
		int esperado = 9;
		assertEquals(id, esperado);
		assertNotEquals(++id,esperado);
	}

	@Test
	void testSetId() {
		int newID = 5;
		geo.setId(newID);
		assertEquals(newID, geo.getId());
	}

	@Test
	void testGetNom() {
		String nom = geo.getNom();
		String esperado = "Default";
		assertEquals(nom, esperado);
	}

	@Test
	void testSetNom() {
		String newNom = geo.figura(geo.getId());
		geo.setNom(geo.figura(geo.getId()));
		assertEquals(newNom, geo.getNom());
	}

	@Test
	void testSetArea() {
		double area = 1.23;
		geo.setArea(area);
		assertEquals(area, geo.getArea());
	}

	@Test
	void testGetArea() {
		double esperado = 3.21;
		geo.setArea(esperado);
		double area = geo.getArea();
		assertEquals(area, esperado);
	}
	
	// ToSrting

	@Test
	void testToString() {
		geo.setArea(6.66);
		geo.setNom("Cuadrado");
		geo.setId(5);
		String esperado = "Geometria [id=5, nom=Cuadrado, area=6.66]";
		assertEquals(esperado, geo.toString());
	}
	
	

}
