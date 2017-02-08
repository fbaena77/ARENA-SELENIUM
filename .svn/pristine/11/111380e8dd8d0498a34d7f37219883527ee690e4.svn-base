package es.juntadeandalucia.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;

import es.juntadeandalucia.selenium.SeleniumSetup;
import static es.juntadeandalucia.utils.Constants.*;

public class Login extends SeleniumSetup {

	public Login() {
		super();
	}

	public boolean doLogin(String user, String password) {
		boolean logged = false;
		driver.navigate().to(URL_LOGIN);
		driver.manage().window().setSize(new Dimension(1280, 1024));
		driver.findElement(By.id("login")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("enviar")).click();

		for (int second = 0;; second++) {
			if (second >= 10)
				return false;
			String url = driver.getCurrentUrl();
			logged = url.equals(URL_HOME);
			break;
		}
		return logged;
	}

	public boolean changeRoleTest() {
		driver.navigate().to(URL_HOME);
		boolean changed = false;
		driver.findElement(By.linkText("[Cambiar]")).click();
		try {
			driver.findElement(By.linkText("Administrador Aren@")).click();
			changed = true;
		} catch (NoSuchElementException e) {
			changed = false;
		}

		return changed;
	}

	public boolean checkChangeRoleButtonExist() {
		driver.navigate().to(URL_HOME);
		return !driver.findElements(By.linkText("[Cambiar]")).isEmpty();
	}
}
