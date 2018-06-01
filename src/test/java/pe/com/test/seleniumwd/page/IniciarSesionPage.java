package pe.com.test.seleniumwd.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pe.com.test.seleniumwd.driver.LibreriaVirtualDriver;

public class IniciarSesionPage {

	private By cajaUsuario = By.id("exampleInputEmail1");
	private By cajaClave = By.id("exampleInputPassword1");
	private By botonIniciarSesion = By.id("btnSubmit");
	private String urlInicial;
	private WebDriver webDriver = null;
	
	public IniciarSesionPage(String navegador, String urlInicial, boolean remoto){
		this.webDriver = LibreriaVirtualDriver.inicializarDriver(navegador, remoto);
		this.urlInicial = urlInicial;
	}
	
	public void iniciarSesion(String usuario, String clave) throws Exception{
		webDriver.get(urlInicial);
		webDriver.findElement(cajaUsuario).clear();
		webDriver.findElement(cajaUsuario).sendKeys(usuario);
		
		/*for (char c : usuario.toCharArray()) {
			webDriver.findElement(cajaUsuario).sendKeys(Character.toString(c));
		}*/
		webDriver.findElement(cajaClave).clear();
		webDriver.findElement(cajaClave).sendKeys(clave);
		webDriver.findElement(botonIniciarSesion).click();
		Thread.sleep(2000);
	}
	
	public void cerrarPagina(){
		LibreriaVirtualDriver.cerrarPagina(webDriver);
	}
	
	public WebDriver getWebDriver() {
		return webDriver;
	}
	
}
