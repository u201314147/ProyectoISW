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

	
	
	//De
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
	
	
	if(valorEsperado1!="") //para que no inicie esta prueba ya que si se espera llenar el campo
	{Assert.assertEquals(valorEsperado1, webDriver.findElement(mensaje1).getText());}
	if(valorEsperado2!="") //para que no inicie esta prueba ya que si se espera llenar el campo
	{Assert.assertEquals(valorEsperado2, webDriver.findElement(mensaje2).getText());}
	if(valorEsperado3!="") //para que no inicie esta prueba ya que si se espera llenar el campo
	{Assert.assertEquals(valorEsperado3, webDriver.findElement(mensaje3).getText());}
	Thread.sleep(1000);
	
	if(valorEsperado1=="" && valorEsperado2=="" && valorEsperado3 =="")
	return webDriver.findElement(mensajeEsperado).getText();
	else
		return "";
}
	
	public void cerrarPagina(){
		LibreriaVirtualDriver.cerrarPagina(webDriver);
	}
	
	public WebDriver getWebDriver() {
		return webDriver;
	}

}
