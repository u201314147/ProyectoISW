package pe.com.test.seleniumwd.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pe.com.test.seleniumwd.driver.LibreriaVirtualDriver;

public class AutorPage {

	
	//Del autor crear
	private By autorLink = By.xpath("//a[@href='/admin/autor/nuevo']");
	private By txtNombre = By.name("nombres");
	private By txtApellidos = By.name("apellidos");
	private By txtNacionalidad = By.name("nacionalidad");
	private By guardarButton = By.id("guardarButton");
	private By mensajeEsperado = By.id("mensaje");
	
	private By mensaje1 = By.xpath("/html/body/div/div/div[2]/form/div[1]/div");
	private By mensaje2= By.xpath("/html/body/div/div/div[2]/form/div[2]/div");
	private By mensaje3= By.xpath("/html/body/div/div/div[2]/form/div[3]/div");

	//Del autor listado
	private By autorListadoLink = By.xpath("//a[@href='/admin/autor/listado']");
	
	private WebDriver webDriver = null;
	
	
	public AutorPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public String insertarAutor(String nombre, String apellido, String nacionalidad, String valorEsperado1, String valorEsperado2, String valorEsperado3) throws Exception {
	
	webDriver.findElement(autorLink).click();
	Thread.sleep(3000);
	webDriver.findElement(txtNombre).clear();
	webDriver.findElement(txtNombre).sendKeys(nombre);

	webDriver.findElement(txtApellidos).clear();
	webDriver.findElement(txtApellidos).sendKeys(apellido);

	webDriver.findElement(txtNacionalidad).clear();
	webDriver.findElement(txtNacionalidad).sendKeys(nacionalidad);

	webDriver.findElement(guardarButton).click();
	
	Assert.assertEquals(valorEsperado1, mensaje1);
	Assert.assertEquals(valorEsperado2, mensaje2);
	Assert.assertEquals(valorEsperado3, mensaje3);
	
	Thread.sleep(3000);
	
	return webDriver.findElement(mensajeEsperado).getText();
}
	
	public void cerrarPagina(){
		LibreriaVirtualDriver.cerrarPagina(webDriver);
	}
	
	public WebDriver getWebDriver() {
		return webDriver;
	}

}
