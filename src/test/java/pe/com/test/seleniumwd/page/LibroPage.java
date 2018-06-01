package pe.com.test.seleniumwd.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pe.com.test.seleniumwd.driver.LibreriaVirtualDriver;

public class LibroPage {

	
	//Del libro crear
	private By LibroLink = By.xpath("//a[@href='/admin/libro/nuevo']");
	private By txtTitulo = By.name("titulo");
	private By txtPrecio = By.name("precio");
	private By txtisbn = By.name("isbn");
	private By txtSinopsis = By.id("sinopsis");
	private By checkBoxPrimerAutor = By.xpath("//*[@id=\"campo09\"]");
	private By guardarButton = By.id("guardarButton");
	private By mensaje = By.id("mensaje");
	
	private WebDriver webDriver = null;
	
	
	public LibroPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
		
	public String insertarLibro(String titulo, String precio, String isbn, String sinopsis, String mensajeEsperado) throws Exception {
		
		webDriver.findElement(LibroLink).click();
		Thread.sleep(3000);
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
		
		Thread.sleep(3000);
		
		return webDriver.findElement(mensaje).getText();
		}
	
	public void cerrarPagina(){
		LibreriaVirtualDriver.cerrarPagina(webDriver);
	}
	
	public WebDriver getWebDriver() {
		return webDriver;
	}

}
