package es.juntadeandalucia;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import es.juntadeandalucia.selenium.Login;
import static es.juntadeandalucia.utils.Constants.*;

/**
 * @author fbaena
 *
 */
public class LoginTest {
	
	public static Login login = new Login();

	@Test
	public void CAP_S_001_doLoginTest() throws Exception {
		assertTrue(login.doLogin(USER, PASSWORD));
	}

	//@Test
	public void changeRoleTest() {
		if (login.checkChangeRoleButtonExist()) {
			assertTrue(login.changeRoleTest());
		}
	}
}
