package es.juntadeandalucia;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import es.juntadeandalucia.selenium.Tramitadores;

public class TramitadoresTest {

	public static Tramitadores tramitadores = new Tramitadores();
	
	@Test
	public void existEmailFieldTest() {
		assertTrue(tramitadores.existEmailField());
	}

	@Test
	public void existOrganizacionFieldTest() {
		assertTrue(tramitadores.existOrganizacionField());
	}

	@Test
	public void existNivelFieldTest() {
		assertTrue(tramitadores.existNivelField());
	}

	@Test
	public void emailRequiredTest() {
		assertTrue(tramitadores.checkEmailRequired());
	}

	//@Test
	public void emailMaskTest() {
		assertTrue(tramitadores.checkEmailMask());
	}

	@Test
	public void newTramitadorTest() {
		assertTrue(tramitadores.newTramitador());
	}
}
