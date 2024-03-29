package es.juntadeandalucia.selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import es.juntadeandalucia.selenium.SeleniumSetup;
import static es.juntadeandalucia.utils.Constants.*;

/**
 * @author fbaena
 * 
 * Class for the Interesados module
 */
public class Interesados {

	private final SeleniumSetup setup = SeleniumSetup.getInstance();
	
	private static final String SEARCH_INTERESADOS_URL = "faces/interesado/search.xhtml";
	private static final String ELEMENT_NOMBRE_CREATE = "create:interesadoBeanInteresadoNombre";
	private static final String ELEMENT_NUMID_CREATE = "create:interesadoBeanInteresadoNumeroIdentificativo";

	/**
	 * Selenium test case for CAP_F_048: Comprobar que podemos modificar interesados
	 * 
	 * @return
	 */
	public boolean doModifyInterested() throws MalformedURLException {
		setup.getDriver().manage().timeouts()
				.implicitlyWait(10, TimeUnit.SECONDS);
		setup.getDriver().findElement(By.linkText("Interesados")).click();
		setup.getDriver()
				.findElement(
						By.id("search:interesadoBeanPageItems:0:itemNombre"))
				.click();
		setup.getDriver().findElement(By.linkText("Editar")).click();
		setup.getDriver().findElement(By.id(ELEMENT_NOMBRE_CREATE)).click();
		setup.getDriver().findElement(By.id(ELEMENT_NOMBRE_CREATE)).clear();
		String nameTest = "John Doe Vagabundo";
		setup.getDriver().findElement(By.id(ELEMENT_NOMBRE_CREATE))
				.sendKeys(nameTest);
		setup.getDriver().findElement(By.id(ELEMENT_NUMID_CREATE)).click();
		setup.getDriver().findElement(By.id(ELEMENT_NUMID_CREATE)).clear();
		setup.getDriver().findElement(By.id(ELEMENT_NUMID_CREATE))
				.sendKeys("12345678Z");
		setup.getDriver().findElement(By.linkText("Guardar")).click();
		URL urlListado = new URL(URL_BASE + SEARCH_INTERESADOS_URL);
		setup.getDriver().navigate().to(urlListado);
		String checkName = setup
				.getDriver()
				.findElement(
						By.id("search:interesadoBeanPageItems:0:itemNombre"))
				.getText();

		return nameTest.equals(checkName);
	}
}
