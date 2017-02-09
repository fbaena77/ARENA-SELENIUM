package es.juntadeandalucia.selenium;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import static es.juntadeandalucia.utils.Constants.*;

public class SeleniumSetup {

	private static final Logger LOGGER = Logger.getLogger(SeleniumSetup.class
			.getName());
	private static Properties config = new Properties();
	private WebDriver driver;
	private static SeleniumSetup instance = null;

	private SeleniumSetup() {
		InputStream input = null;

		try {
			input = SeleniumSetup.class.getClassLoader().getResourceAsStream(
					"app.properties");

			getConfig().load(input);

		} catch (IOException ex) {
			LOGGER.log(Level.SEVERE,
					"Error al leer la configuración de la aplicación", ex);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					LOGGER.log(Level.SEVERE,
							"Error al cerrar el fichero de configuración", e);
				}
			}

		}
		System.setProperty("phantomjs.binary.path", "bin/phantomjs");
		driver = new PhantomJSDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static SeleniumSetup getInstance() {
		if (instance == null) {
			instance = new SeleniumSetup();
		}
		return instance;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public void tearDown() {
		driver.close();
		driver.quit();
	}

	public Properties getConfig() {
		return config;
	}
}
