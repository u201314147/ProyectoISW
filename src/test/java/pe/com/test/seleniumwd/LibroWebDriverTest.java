package pe.com.test.seleniumwd;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pe.com.test.seleniumwd.fuenteDatos.Excel;
import pe.com.test.seleniumwd.fuenteDatos.MySql;
import pe.com.test.seleniumwd.page.AutorPage;
import pe.com.test.seleniumwd.page.IniciarSesionPage;
import pe.com.test.seleniumwd.page.LibroPage;
import pe.com.test.seleniumwd.util.Utilitario;

public class LibroWebDriverTest {

	private String urlInicial = "http://localhost:8080/admin/login";
	private LibroPage libroPage;
	private IniciarSesionPage iniciarSesionPage;
	private String rutaCarpetaError = "C:\\CapturasPantallas\\Autores";

	@BeforeTest
	@Parameters({ "navegador", "remoto" })
	public void inicioClase(String navegador, int remoto) throws Exception {
		this.iniciarSesionPage = new IniciarSesionPage(navegador, this.urlInicial, remoto == 1);
		this.libroPage = new LibroPage(this.iniciarSesionPage.getWebDriver());
	}

	@DataProvider(name = "datosEntrada")
	public static Object[][] datosPoblados(ITestContext context) {
		Object[][] datos = null;
		String fuenteDatos = context.getCurrentXmlTest().getParameter("fuenteDatos");
		System.out.println("Fuente de Datos: " + fuenteDatos);
		switch(fuenteDatos){
			case "BD":
				datos = MySql.leerDataLibroMysql();
			break;
			case "Excel":
				String rutaArchivo = context.getCurrentXmlTest().getParameter("rutaArchivo");
				datos = Excel.leerExcel(rutaArchivo);
				break;
		}
		return datos;
	}
	
	
	@Test(dataProvider = "datosEntrada")
	public void insertarLibro(String usuario, String clave, String titulo, String precio, String isbn, String sinopsis, String mensajeEsperado) throws Exception {
		try {
			iniciarSesionPage.iniciarSesion(usuario, clave);
			String valorObtenido = libroPage.insertarLibro(titulo.trim(), precio.trim(), isbn.trim(), sinopsis.trim());
			Assert.assertEquals(valorObtenido, mensajeEsperado);

		}catch(AssertionError e){
			Utilitario.caputarPantallarError(rutaCarpetaError, e.getMessage(), libroPage.getWebDriver());
			Assert.fail(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}


	@AfterTest
	public void tearDown() throws Exception {
		libroPage.cerrarPagina();
	}

}
