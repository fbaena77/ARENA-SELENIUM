package es.juntadeandalucia;

import static es.juntadeandalucia.utils.Constants.*;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import es.juntadeandalucia.selenium.Login;
import es.juntadeandalucia.selenium.Tramitadores;

/**
 * @author fbaena
 *
 */
public class TramitadoresTest {

	public static Tramitadores tramitadores = new Tramitadores();
	
	@BeforeClass
	public static void doLogin(){
		final Login login = new Login();
		assertTrue(login.doLogin(USER, PASSWORD));
	}
	
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
	public void createTramitadorMethodTest() {
		assertTrue(tramitadores.createTramitador("COD0", "TestCreateTramitadorMethod", "test@test.com"));
	}
	
	@Test
	public void emailRequiredTest() {
		assertTrue(tramitadores.checkEmailRequired("COD1", "TestEmailRequired"));
	}

	//@Test
	public void emailMaskTest() {
		assertTrue(tramitadores.checkEmailMask("COD2", "TestEmailMask", "test"));
	}

	@Test
	public void newTramitadorTest() {
		assertTrue(tramitadores.newTramitador("COD3", "TestNewTramitador", "test@test.com"));
	}
}
