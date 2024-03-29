package es.juntadeandalucia.selenium;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import es.juntadeandalucia.selenium.SeleniumSetup;
import static es.juntadeandalucia.utils.Constants.*;

/**
 * @author fbaena
 * 
 *         Class for the Tramitadores module
 */
public class Tramitadores {

	private static final Logger LOGGER = Logger.getLogger(Tramitadores.class.getName());
	private final SeleniumSetup setup = SeleniumSetup.getInstance();

	private static final String ERROR = "error";
	private static final String GUARDAR = "Guardar";
	private static final String CREATE_TRAMITADOR_BEAN_TRAMITADOR_NOMBRE = "create:tramitadorBeanTramitadorNombre";
	private static final String CREATE_TRAMITADOR_BEAN_TRAMITADOR_CODIGO = "create:tramitadorBeanTramitadorCodigo";
	private static final String CREATE_TRAMITADOR_BEAN_TRAMITADOR_EMAIL = "create:tramitadorBeanTramitadorEmail";
	private static final String CREATE_TRAMITADOR_URL = "faces/tramitador/create.xhtml";
	private static final String SEARCH_TRAMITADOR_URL = "faces/tramitador/search.xhtml";

	/**
	 * Selenium test case for checking if Email field exists
	 * 
	 * @return
	 */
	public boolean existEmailField() {
		String appUrl = URL_BASE + SEARCH_TRAMITADOR_URL;
		setup.getDriver().navigate().to(appUrl);
		boolean existsInSearch = !setup.getDriver()
				.findElements(By.id("search:tramitadorBeanExampleEmail"))
				.isEmpty();
		if (!existsInSearch) {
			return false;
		}
		appUrl = URL_BASE + CREATE_TRAMITADOR_URL;
		setup.getDriver().navigate().to(appUrl);
		return !setup.getDriver()
				.findElements(By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_EMAIL))
				.isEmpty();
	}

	/**
	 * Selenium test case for checking if Organizacion field exists
	 * 
	 * @return
	 */
	public boolean existOrganizacionField() {
		String appUrl = URL_BASE + SEARCH_TRAMITADOR_URL;
		setup.getDriver().navigate().to(appUrl);
		boolean existsInSearch = !setup
				.getDriver()
				.findElements(By.id("search:tramitadorBeanExampleOrganizacion"))
				.isEmpty();
		if (!existsInSearch) {
			return false;
		}
		appUrl = URL_BASE + CREATE_TRAMITADOR_URL;
		setup.getDriver().navigate().to(appUrl);
		return !setup
				.getDriver()
				.findElements(
						By.id("create:tramitadorBeanTramitadorOrganizacion"))
				.isEmpty();
	}

	/**
	 * Selenium test case for checking if Nivel field exists
	 * 
	 * @return
	 */
	public boolean existNivelField() {
		String appUrl = URL_BASE + SEARCH_TRAMITADOR_URL;
		setup.getDriver().navigate().to(appUrl);
		boolean existsInSearch = !setup.getDriver()
				.findElements(By.id("search:tramitadorBeanExampleNivel"))
				.isEmpty();
		if (!existsInSearch) {
			return false;
		}
		appUrl = URL_BASE + CREATE_TRAMITADOR_URL;
		setup.getDriver().navigate().to(appUrl);
		return !setup.getDriver()
				.findElements(By.id("create:tramitadorBeanTramitadorNivel"))
				.isEmpty();
	}

	/**
	 * Selenium test case for checking if Email field is mandatory when
	 * registering a new Tramitador
	 * 
	 * @return
	 */
	public boolean checkEmailRequired(String code, String name) {
		createTramitador(code, name, "");
		List<WebElement> findElementsError = setup.getDriver().findElements(
				By.className(ERROR));

		for (WebElement e : findElementsError) {
			if (e.getText().startsWith(
					"arena-1002 create:tramitadorBeanTramitadorEmail")) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Selenium test case for checking if Email field has a mask
	 * 
	 * @return
	 */
	public boolean checkEmailMask(String code, String name, String email) {
		createTramitador(code, name, email);
		List<WebElement> findElementsError = setup.getDriver().findElements(
				By.className(ERROR));
		for (WebElement e : findElementsError) {
			if (e.getText().startsWith("arena-1515 El modelo Regex")) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Selenium test case for checking if a new Tramitador is able to be
	 * registered
	 * 
	 * @return
	 */
	public boolean newTramitador(String code, String name, String email) {
		createTramitador(code, name, email);
		return setup.getDriver().findElements(By.className(ERROR)).isEmpty();
	}

	public boolean createTramitador(String code, String name, String email) {
		try {
			String appUrl = URL_BASE + CREATE_TRAMITADOR_URL;
			setup.getDriver().navigate().to(appUrl);
			setup.getDriver().manage().window()
					.setSize(new Dimension(1280, 1024));
			setup.getDriver()
					.findElement(
							By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_CODIGO))
					.click();
			setup.getDriver()
					.findElement(
							By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_CODIGO))
					.clear();
			setup.getDriver()
					.findElement(
							By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_CODIGO))
					.sendKeys(code);
			setup.getDriver()
					.findElement(
							By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_NOMBRE))
					.click();
			setup.getDriver()
					.findElement(
							By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_NOMBRE))
					.clear();
			setup.getDriver()
					.findElement(
							By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_NOMBRE))
					.sendKeys(name);

			if (!email.isEmpty()) {
				setup.getDriver()
						.findElement(
								By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_EMAIL))
						.click();
				setup.getDriver()
						.findElement(
								By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_EMAIL))
						.clear();
				setup.getDriver()
						.findElement(
								By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_EMAIL))
						.sendKeys(email);
			}
			setup.getDriver().findElement(By.linkText(GUARDAR)).click();
			return true;
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error createTramitador()", e);
			return false;
		}
	}
}
