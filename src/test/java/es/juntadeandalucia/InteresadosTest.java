package es.juntadeandalucia;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.AfterClass;
import org.junit.Test;

import es.juntadeandalucia.selenium.Interesados;

public class InteresadosTest {

	public static Interesados interesados = new Interesados();

	@Test
	public void CAP_F_048_modifyInterestedTest() throws MalformedURLException {
		assertTrue(interesados.doModifyInterested());
	}
	
	@AfterClass
	public static void tearDown(){
		interesados.tearDown();
	}
}
