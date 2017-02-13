package es.juntadeandalucia.utils;

import es.juntadeandalucia.selenium.SeleniumSetup;

/**
 * @author fbaena
 * 
 * Constants class
 */
public final class Constants {

	private static final SeleniumSetup setup = SeleniumSetup.getInstance();

	public static final String URL_BASE = setup.getConfig().getProperty(
			"url.base");
	public static final String URL_LOGIN = setup.getConfig().getProperty(
			"url.login");
	public static final String URL_HOME = setup.getConfig().getProperty(
			"url.home");
	public static final String USER = setup.getConfig().getProperty("user");
	public static final String PASSWORD = setup.getConfig().getProperty(
			"password");

	private Constants() {

	}
}
