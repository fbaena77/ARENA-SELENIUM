package es.juntadeandalucia.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import es.juntadeandalucia.selenium.SeleniumSetup;
import es.juntadeandalucia.selenium.Login;
import static es.juntadeandalucia.utils.Constants.*;

public class Tramitadores {

	private static final String ERROR = "error";
	private static final String GUARDAR = "Guardar";
	private static final String CREATE_TRAMITADOR_BEAN_TRAMITADOR_NOMBRE = "create:tramitadorBeanTramitadorNombre";
	private static final String CREATE_TRAMITADOR_BEAN_TRAMITADOR_CODIGO = "create:tramitadorBeanTramitadorCodigo";
	private static final String CREATE_TRAMITADOR_BEAN_TRAMITADOR_EMAIL = "create:tramitadorBeanTramitadorEmail";
	private static final String CREATE_TRAMITADOR_URL = "faces/tramitador/create.xhtml";
	private static final String SEARCH_TRAMITADOR_URL = "faces/tramitador/search.xhtml";
	private final SeleniumSetup setup = SeleniumSetup.getInstance();
	public final Login login = new Login();

	public Tramitadores() {
		login.doLogin(USER, PASSWORD);
		if (login.checkChangeRoleButtonExist()) {
			login.changeRoleTest();
		}
	}

	public boolean existEmailField() {
		String appUrl = URL_BASE + SEARCH_TRAMITADOR_URL;
		setup.getDriver().navigate().to(appUrl);
		boolean existsInSearch = !setup.getDriver().findElements(
				By.id("search:tramitadorBeanExampleEmail")).isEmpty();
		if (!existsInSearch) {
			return false;
		}
		appUrl = URL_BASE + CREATE_TRAMITADOR_URL;
		setup.getDriver().navigate().to(appUrl);
		return !setup.getDriver().findElements(
				By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_EMAIL)).isEmpty();
	}

	public boolean existOrganizacionField() {
		String appUrl = URL_BASE + SEARCH_TRAMITADOR_URL;
		setup.getDriver().navigate().to(appUrl);
		boolean existsInSearch = !setup.getDriver().findElements(
				By.id("search:tramitadorBeanExampleOrganizacion")).isEmpty();
		if (!existsInSearch) {
			return false;
		}
		appUrl = URL_BASE + CREATE_TRAMITADOR_URL;
		setup.getDriver().navigate().to(appUrl);
		return !setup.getDriver().findElements(
				By.id("create:tramitadorBeanTramitadorOrganizacion")).isEmpty();
	}

	public boolean existNivelField() {
		String appUrl = URL_BASE + SEARCH_TRAMITADOR_URL;
		setup.getDriver().navigate().to(appUrl);
		boolean existsInSearch = !setup.getDriver().findElements(
				By.id("search:tramitadorBeanExampleNivel")).isEmpty();
		if (!existsInSearch) {
			return false;
		}
		appUrl = URL_BASE + CREATE_TRAMITADOR_URL;
		setup.getDriver().navigate().to(appUrl);
		return !setup.getDriver().findElements(
				By.id("create:tramitadorBeanTramitadorNivel")).isEmpty();
	}

	public boolean checkEmailRequired() {
		String appUrl = URL_BASE + CREATE_TRAMITADOR_URL;
		setup.getDriver().navigate().to(appUrl);
		setup.getDriver().manage().window().setSize(new Dimension(1280, 1024));
		setup.getDriver().findElement(By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_CODIGO))
				.click();
		setup.getDriver().findElement(By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_CODIGO))
				.clear();
		setup.getDriver().findElement(By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_CODIGO))
				.sendKeys("COD2");
		setup.getDriver().findElement(By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_NOMBRE))
				.click();
		setup.getDriver().findElement(By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_NOMBRE))
				.clear();
		setup.getDriver().findElement(By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_NOMBRE))
				.sendKeys("TestEmailRequired");
		setup.getDriver().findElement(By.linkText(GUARDAR)).click();
		
		List<WebElement> findElementsError = setup.getDriver().findElements(By.className(ERROR));
		
		for(WebElement e: findElementsError) {
			if (e.getText().startsWith("arena-1002 create:tramitadorBeanTramitadorEmail")){
				return true;
			}
		}
		
		return false;
	}

	public boolean checkEmailMask() {
		String appUrl = URL_BASE + CREATE_TRAMITADOR_URL;
		setup.getDriver().navigate().to(appUrl);
		setup.getDriver().manage().window().setSize(new Dimension(1280, 1024));
		setup.getDriver().findElement(By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_CODIGO))
				.click();
		setup.getDriver().findElement(By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_CODIGO))
				.clear();
		setup.getDriver().findElement(By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_CODIGO))
				.sendKeys("CODIGO");
		setup.getDriver().findElement(By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_NOMBRE))
				.click();
		setup.getDriver().findElement(By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_NOMBRE))
				.clear();
		setup.getDriver().findElement(By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_NOMBRE))
				.sendKeys("TestNewTramitador");
		setup.getDriver().findElement(By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_EMAIL))
				.click();
		setup.getDriver().findElement(By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_EMAIL))
				.clear();
		setup.getDriver().findElement(By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_EMAIL))
				.sendKeys("test");
		setup.getDriver().findElement(By.linkText(GUARDAR)).click();
		
		List<WebElement> findElementsError = setup.getDriver().findElements(By.className(ERROR));
		
		for(WebElement e: findElementsError) {
			if (e.getText().startsWith("arena-1515 El modelo Regex")){
				return true;
			}
		}
		
		return false;
	}

	public boolean newTramitador() {
		String appUrl = URL_BASE + CREATE_TRAMITADOR_URL;
		setup.getDriver().navigate().to(appUrl);
		setup.getDriver().manage().window().setSize(new Dimension(1280, 1024));
		setup.getDriver().findElement(By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_CODIGO))
				.click();
		setup.getDriver().findElement(By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_CODIGO))
				.clear();
		setup.getDriver().findElement(By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_CODIGO))
				.sendKeys("CODIGO");
		setup.getDriver().findElement(By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_NOMBRE))
				.click();
		setup.getDriver().findElement(By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_NOMBRE))
				.clear();
		setup.getDriver().findElement(By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_NOMBRE))
				.sendKeys("TestNewTramitador");
		setup.getDriver().findElement(By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_EMAIL))
				.click();
		setup.getDriver().findElement(By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_EMAIL))
				.clear();
		setup.getDriver().findElement(By.id(CREATE_TRAMITADOR_BEAN_TRAMITADOR_EMAIL))
				.sendKeys("test@test.es");
		setup.getDriver().findElement(By.linkText(GUARDAR)).click();
		return setup.getDriver().findElements(By.className(ERROR)).isEmpty();
	}
}
