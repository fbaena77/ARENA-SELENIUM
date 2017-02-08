package es.juntadeandalucia.utils;

import es.juntadeandalucia.selenium.SeleniumSetup;

public final class Constants {

	public static final String URL_BASE = SeleniumSetup.getConfig()
			.getProperty("url.base");
	public static final String URL_LOGIN = SeleniumSetup.getConfig()
			.getProperty("url.login");
	public static final String URL_HOME = SeleniumSetup.getConfig()
			.getProperty("url.home");
	public static final String USER = SeleniumSetup.getConfig().getProperty(
			"user");
	public static final String PASSWORD = SeleniumSetup.getConfig()
			.getProperty("password");
}
