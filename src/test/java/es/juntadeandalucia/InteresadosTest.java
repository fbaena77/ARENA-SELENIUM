package es.juntadeandalucia;

import static es.juntadeandalucia.utils.Constants.PASSWORD;
import static es.juntadeandalucia.utils.Constants.USER;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.BeforeClass;
import org.junit.Test;

import es.juntadeandalucia.selenium.Interesados;
import es.juntadeandalucia.selenium.Login;

/**
 * @author fbaena
 *
 */
public class InteresadosTest {

	public static Interesados interesados = new Interesados();

	@BeforeClass
	public static void doLogin(){
		final Login login = new Login();
		assertTrue(login.doLogin(USER, PASSWORD));
	}

	@Test
	public void CAP_F_048_modifyInterestedTest() throws MalformedURLException {
		assertTrue(interesados.doModifyInterested());
	}
}
