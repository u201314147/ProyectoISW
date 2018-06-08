package pe.com.test.seleniumwd.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pe.com.test.seleniumwd.driver.LibreriaVirtualDriver;

public class AutorElim {

	
	//Del autor crear
	private By txtNombre = By.name("nombres");
	private By txtApellidos = By.name("apellidos");
	private By txtNacionalidad = By.name("nacionalidad");
	private By guardarButton = By.id("guardarButton");
	private By mensajeEsperado = By.id("mensaje");
	
	//Del autor listado
	private By txtBuscarAutor = By.id("txtBuscarNombre");
	private By BuscarButton = By.id("BuscarButton");
	private By autorListadoLink = By.xpath("//a[@href='/admin/autor/listado']");
	private By autorListadoLinkEliminar = By.xpath("/html/body/div/div/div[2]/table/tbody/tr[1]/td[4]/a[1]");
	private WebDriver webDriver = null;
	
	
	public AutorElim(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public String eliminarAutor(String buscar) throws Exception {
	
	webDriver.findElement(autorListadoLink).click();
		
	Thread.sleep(1000);
		
	webDriver.findElement(txtBuscarAutor).sendKeys(buscar);
	
	Thread.sleep(1000);
	
	
	webDriver.findElement(BuscarButton).click();
	
	Thread.sleep(1000);
	webDriver.findElement(autorListadoLinkEliminar).click();
	
	Thread.sleep(1000);
	
	return webDriver.findElement(mensajeEsperado).getText();
}
	
	public void cerrarPagina(){
		LibreriaVirtualDriver.cerrarPagina(webDriver);
	}
	
	public WebDriver getWebDriver() {
		return webDriver;
	}

}
