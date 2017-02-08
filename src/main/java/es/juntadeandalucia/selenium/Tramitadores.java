package es.juntadeandalucia.selenium;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import es.juntadeandalucia.selenium.SeleniumSetup;
import es.juntadeandalucia.selenium.Login;
import static es.juntadeandalucia.utils.Constants.*;

public class Tramitadores extends SeleniumSetup {

	private static final String CREATE_TRAMITADOR_URL = "faces/tramitador/create.xhtml";
	private static final String SEARCH_TRAMITADOR_URL = "faces/tramitador/search.xhtml";

	public final Login login = new Login();

	public Tramitadores() {
		login.doLogin(USER, PASSWORD);
		if (login.checkChangeRoleButtonExist()) {
			login.changeRoleTest();
		}
	}

	public boolean existEmailField() {
		String appUrl = URL_BASE + SEARCH_TRAMITADOR_URL;
		driver.navigate().to(appUrl);
		boolean existsInSearch = !driver.findElements(
				By.id("search:tramitadorBeanExampleEmail")).isEmpty();
		if (!existsInSearch) {
			return false;
		}
		appUrl = URL_BASE + CREATE_TRAMITADOR_URL;
		driver.navigate().to(appUrl);
		return !driver.findElements(
				By.id("create:tramitadorBeanTramitadorEmail")).isEmpty();
	}

	public boolean existOrganizacionField() {
		String appUrl = URL_BASE + SEARCH_TRAMITADOR_URL;
		driver.navigate().to(appUrl);
		boolean existsInSearch = !driver.findElements(
				By.id("search:tramitadorBeanExampleOrganizacion")).isEmpty();
		if (!existsInSearch) {
			return false;
		}
		appUrl = URL_BASE + CREATE_TRAMITADOR_URL;
		driver.navigate().to(appUrl);
		return !driver.findElements(
				By.id("create:tramitadorBeanTramitadorOrganizacion")).isEmpty();
	}

	public boolean existNivelField() {
		String appUrl = URL_BASE + SEARCH_TRAMITADOR_URL;
		driver.navigate().to(appUrl);
		boolean existsInSearch = !driver.findElements(
				By.id("search:tramitadorBeanExampleNivel")).isEmpty();
		if (!existsInSearch) {
			return false;
		}
		appUrl = URL_BASE + CREATE_TRAMITADOR_URL;
		driver.navigate().to(appUrl);
		return !driver.findElements(
				By.id("create:tramitadorBeanTramitadorNivel")).isEmpty();
	}

	public boolean checkEmailRequired() {
		String appUrl = URL_BASE + CREATE_TRAMITADOR_URL;
		driver.navigate().to(appUrl);
		driver.manage().window().setSize(new Dimension(1280, 1024));
		driver.findElement(By.id("create:tramitadorBeanTramitadorCodigo"))
				.click();
		driver.findElement(By.id("create:tramitadorBeanTramitadorCodigo"))
				.clear();
		driver.findElement(By.id("create:tramitadorBeanTramitadorCodigo"))
				.sendKeys("COD2");
		driver.findElement(By.id("create:tramitadorBeanTramitadorNombre"))
				.click();
		driver.findElement(By.id("create:tramitadorBeanTramitadorNombre"))
				.clear();
		driver.findElement(By.id("create:tramitadorBeanTramitadorNombre"))
				.sendKeys("TestEmailRequired");
		driver.findElement(By.linkText("Guardar")).click();
		
		List<WebElement> findElementsError = driver.findElements(By.className("error"));
		
		for(WebElement e: findElementsError) {
			if (e.getText().startsWith("arena-1002 create:tramitadorBeanTramitadorEmail")){
				return true;
			}
		}
		
		return false;
	}

	public boolean checkEmailMask() {
		String appUrl = URL_BASE + CREATE_TRAMITADOR_URL;
		driver.navigate().to(appUrl);
		driver.manage().window().setSize(new Dimension(1280, 1024));
		driver.findElement(By.id("create:tramitadorBeanTramitadorCodigo"))
				.click();
		driver.findElement(By.id("create:tramitadorBeanTramitadorCodigo"))
				.clear();
		driver.findElement(By.id("create:tramitadorBeanTramitadorCodigo"))
				.sendKeys("CODIGO");
		driver.findElement(By.id("create:tramitadorBeanTramitadorNombre"))
				.click();
		driver.findElement(By.id("create:tramitadorBeanTramitadorNombre"))
				.clear();
		driver.findElement(By.id("create:tramitadorBeanTramitadorNombre"))
				.sendKeys("TestNewTramitador");
		driver.findElement(By.id("create:tramitadorBeanTramitadorEmail"))
				.click();
		driver.findElement(By.id("create:tramitadorBeanTramitadorEmail"))
				.clear();
		driver.findElement(By.id("create:tramitadorBeanTramitadorEmail"))
				.sendKeys("test");
		driver.findElement(By.linkText("Guardar")).click();
		
		List<WebElement> findElementsError = driver.findElements(By.className("error"));
		
		for(WebElement e: findElementsError) {
			if (e.getText().startsWith("arena-1515 El modelo Regex")){
				return true;
			}
		}
		
		return false;
	}

	public boolean newTramitador() {
		String appUrl = URL_BASE + CREATE_TRAMITADOR_URL;
		driver.navigate().to(appUrl);
		driver.manage().window().setSize(new Dimension(1280, 1024));
		driver.findElement(By.id("create:tramitadorBeanTramitadorCodigo"))
				.click();
		driver.findElement(By.id("create:tramitadorBeanTramitadorCodigo"))
				.clear();
		driver.findElement(By.id("create:tramitadorBeanTramitadorCodigo"))
				.sendKeys("CODIGO");
		driver.findElement(By.id("create:tramitadorBeanTramitadorNombre"))
				.click();
		driver.findElement(By.id("create:tramitadorBeanTramitadorNombre"))
				.clear();
		driver.findElement(By.id("create:tramitadorBeanTramitadorNombre"))
				.sendKeys("TestNewTramitador");
		driver.findElement(By.id("create:tramitadorBeanTramitadorEmail"))
				.click();
		driver.findElement(By.id("create:tramitadorBeanTramitadorEmail"))
				.clear();
		driver.findElement(By.id("create:tramitadorBeanTramitadorEmail"))
				.sendKeys("test@test.es");
		driver.findElement(By.linkText("Guardar")).click();
		return driver.findElements(By.className("error")).isEmpty();
	}
}
