package es.juntadeandalucia;

import static es.juntadeandalucia.utils.Constants.URL_LOGIN;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import es.juntadeandalucia.selenium.SeleniumSetup;

/**
 * @author fbaena
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ LoginTest.class, InteresadosTest.class,
		TramitadoresTest.class })
public class JunitTestSuite {

	private static SeleniumSetup setup;
	
	@BeforeClass
	public static void setUpClass(){
		setup = SeleniumSetup.getInstance();
		setup.getDriver().get(URL_LOGIN);
	}
	
	@AfterClass
	public static void tearDownClass() {
		setup.tearDown();
	}

}
