package pe.com.test.seleniumwd.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pe.com.test.seleniumwd.driver.LibreriaVirtualDriver;

public class LibroEdit {

	
	//Del libro crear
	private By LibroLink = By.xpath("//a[@href='/admin/libro/nuevo']");
	private By txtTitulo = By.name("titulo");
	private By txtPrecio = By.name("precio");
	private By txtisbn = By.name("isbn");
	private By txtSinopsis = By.id("sinopsis");
	private By checkBoxPrimerAutor = By.xpath("//*[@id=\"campo09\"]");
	private By guardarButton = By.id("guardarButton");
	private By mensaje = By.xpath("/html/body/div[3]/div/div[2]/div[1]");
	
	//Del libro listado
	private By LibroLinkListado = By.xpath("//a[@href='/admin/libro/listado']");
	private By txtBuscarPrecio = By.id("precio");
	private By linkEditar = By.xpath("/html/body/div[3]/div/div[2]/table/tbody/tr/td[6]/a[2]");
	private By BtnBuscar = By.xpath("/html/body/div[3]/div/div[2]/div[2]/form/button");
	
	private WebDriver webDriver = null;
	
	
	public LibroEdit(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
		
	public String editarLibro(String buscarPrecio, String titulo, String precio, String isbn, String sinopsis)  throws Exception {
	
		
		webDriver.findElement(LibroLinkListado).click();
		Thread.sleep(1000);	
		
		webDriver.findElement(txtBuscarPrecio).clear();
		webDriver.findElement(txtBuscarPrecio).sendKeys(buscarPrecio);
		
		Thread.sleep(1000);	
		
		webDriver.findElement(BtnBuscar).click();
	
		
		Thread.sleep(1000);	
		
		webDriver.findElement(linkEditar).click();
		
		Thread.sleep(1000);	
		
		
		webDriver.findElement(txtTitulo).clear();
		webDriver.findElement(txtTitulo).sendKeys(titulo);
		webDriver.findElement(txtPrecio).clear();
		webDriver.findElement(txtPrecio).sendKeys(precio);
		webDriver.findElement(txtisbn).clear();
		webDriver.findElement(txtisbn).sendKeys(isbn);
		webDriver.findElement(txtSinopsis).clear();
		webDriver.findElement(txtSinopsis).sendKeys(sinopsis);
		
		
		
		webDriver.findElement(checkBoxPrimerAutor).click();
		webDriver.findElement(guardarButton).click();
		
	
		Thread.sleep(1000);
	
		String texto = webDriver.findElement(mensaje).getText();
		
		webDriver.findElement(txtBuscarPrecio).clear();
		webDriver.findElement(txtBuscarPrecio).sendKeys(precio);
		
		Thread.sleep(1000);	
		
		webDriver.findElement(BtnBuscar).click();
	
		
		
		return texto;
		}
	
	public void cerrarPagina(){
		LibreriaVirtualDriver.cerrarPagina(webDriver);
	}
	
	public WebDriver getWebDriver() {
		return webDriver;
	}

}
