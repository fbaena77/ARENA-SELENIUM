package es.juntadeandalucia.selenium;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;

import es.juntadeandalucia.selenium.SeleniumSetup;
import static es.juntadeandalucia.utils.Constants.*;

public class Login {

	private static final Logger LOGGER = Logger.getLogger(Login.class.getName());
	private final SeleniumSetup setup = SeleniumSetup.getInstance();
	
	public Login() {
		super();
	}
	
	public boolean doLogin(String user, String password) {
		boolean logged;
		setup.getDriver().navigate().to(URL_LOGIN);
		setup.getDriver().manage().window().setSize(new Dimension(1280, 1024));
		setup.getDriver().findElement(By.id("login")).sendKeys(user);
		setup.getDriver().findElement(By.id("password")).sendKeys(password);
		setup.getDriver().findElement(By.id("enviar")).click();

		for (int second = 0;; second++) {
			if (second >= 10)
				return false;
			String url = setup.getDriver().getCurrentUrl();
			logged = url.equals(URL_HOME);
			break;
		}
		return logged;
	}

	public boolean changeRoleTest() {
		setup.getDriver().navigate().to(URL_HOME);
		boolean changed = false;
		setup.getDriver().findElement(By.linkText("[Cambiar]")).click();
		try {
			setup.getDriver().findElement(By.linkText("Administrador Aren@")).click();
			changed = true;
		} catch (NoSuchElementException e) {
			changed = false;
			LOGGER.log(Level.SEVERE, "Error changeRoleTest()", e);
		}

		return changed;
	}

	public boolean checkChangeRoleButtonExist() {
		setup.getDriver().navigate().to(URL_HOME);
		return !setup.getDriver().findElements(By.linkText("[Cambiar]")).isEmpty();
	}
}
