package es.juntadeandalucia.selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import es.juntadeandalucia.selenium.Login;
import es.juntadeandalucia.selenium.SeleniumSetup;
import static es.juntadeandalucia.utils.Constants.*;

public class Interesados extends SeleniumSetup {

	private final String SEARCH_INTERESADOS_URL = "faces/interesado/search.xhtml";
	public final Login login = new Login();

	public Interesados() {
		login.doLogin(USER, PASSWORD);
		if (login.checkChangeRoleButtonExist()) {
			login.changeRoleTest();
		}
	}

	public boolean doModifyInterested() throws MalformedURLException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Interesados")).click();
		driver.findElement(By.id("search:interesadoBeanPageItems:0:itemNombre"))
				.click();
		driver.findElement(By.linkText("Editar")).click();
		driver.findElement(By.id("create:interesadoBeanInteresadoNombre"))
				.click();
		driver.findElement(By.id("create:interesadoBeanInteresadoNombre"))
				.clear();
		String nameTest = "John Doe Vagabundo";
		driver.findElement(By.id("create:interesadoBeanInteresadoNombre"))
				.sendKeys(nameTest);
		driver.findElement(
				By.id("create:interesadoBeanInteresadoNumeroIdentificativo"))
				.click();
		driver.findElement(
				By.id("create:interesadoBeanInteresadoNumeroIdentificativo"))
				.clear();
		driver.findElement(
				By.id("create:interesadoBeanInteresadoNumeroIdentificativo"))
				.sendKeys("12345678Z");
		driver.findElement(By.linkText("Guardar")).click();
		URL urlListado = new URL(URL_BASE + SEARCH_INTERESADOS_URL);
		driver.navigate().to(urlListado);
		String checkName = driver.findElement(
				By.id("search:interesadoBeanPageItems:0:itemNombre")).getText();

		return nameTest.equals(checkName);
	}
}
