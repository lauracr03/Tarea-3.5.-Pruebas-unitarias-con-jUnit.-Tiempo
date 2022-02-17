package com.edd.jlpl.tiempo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TiempoTest {

	private Tiempo tiempo10_20_30;
	private Tiempo tiempo60_60_60;

	@BeforeEach
	void setUp() throws Exception {
		tiempo10_20_30 = new Tiempo(0,10,20,30);
		tiempo60_60_60 = new Tiempo(0,60,60,60);
	}
	
	@Test
	void testTiempo() {
		assertDoesNotThrow(()->{
			
			Tiempo tiempo = new Tiempo (0,0,0,61);
			assertEquals(1, tiempo.getSegundos());
			assertEquals(1, tiempo.getMinutos());
			assertEquals(0, tiempo.getHoras());
			assertEquals(0, tiempo.getDias());
			
			tiempo = new Tiempo (0,24,60,61);
			assertEquals(1, tiempo.getSegundos());
			assertEquals(1, tiempo.getMinutos());
			assertEquals(1, tiempo.getHoras());
			assertEquals(1, tiempo.getDias());
		
		});
	}

	@Test
	void testGetHoras() {
		assertEquals(10, tiempo10_20_30.getHoras());
	}

	@Test
	void testGetMinutos() {
		assertEquals(20, tiempo10_20_30.getMinutos());
	}

	@Test
	void testGetSegundos() {
		assertEquals(30, tiempo10_20_30.getSegundos());
	}
	
	@Test
	void testGetDias() {
		assertEquals(0, tiempo10_20_30.getDias());
	}

	@Test
	void testNormaliza() {
		assertEquals(0, tiempo60_60_60.getSegundos());
		assertEquals(1, tiempo60_60_60.getMinutos());
	}

	@Test
	void testSumaTiempo() {
		assertDoesNotThrow(()->{
			Tiempo tiempo = tiempo10_20_30.suma(tiempo60_60_60);
			assertEquals(30, tiempo.getSegundos());
			assertEquals(21, tiempo.getMinutos());
			assertEquals(23, tiempo.getHoras());
		});
	}

	@Test
	void testSumaIntIntInt() {
		assertDoesNotThrow(()->{
			int dias = 1;
			int horas = 2;
			int minutos = 5;
			int segundos = 10;
			tiempo10_20_30.suma(dias, horas, minutos, segundos);
			assertEquals(40, tiempo10_20_30.getSegundos());
			assertEquals(25, tiempo10_20_30.getMinutos());
			assertEquals(12, tiempo10_20_30.getHoras());
			assertEquals(1, tiempo10_20_30.getDias());
		});
		
	}

	@Test
	void testToString() {
		assertDoesNotThrow(()->{
			System.out.println(tiempo10_20_30);
		});
	}

}
