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
import pe.com.test.seleniumwd.util.Utilitario;

public class AutorWebDriverTest {

	private String urlInicial = "http://localhost:8080/admin/login";
	private AutorPage autorPage;
	private IniciarSesionPage iniciarSesionPage;
	private String rutaCarpetaError = "C:\\CapturasPantallas\\Autores";

	@BeforeTest
	@Parameters({ "navegador", "remoto" })
	public void inicioClase(String navegador, int remoto) throws Exception {
		this.iniciarSesionPage = new IniciarSesionPage(navegador, this.urlInicial, remoto == 1);
		this.autorPage = new AutorPage(this.iniciarSesionPage.getWebDriver());
	}

	@DataProvider(name = "datosEntrada")
	public static Object[][] datosPoblados(ITestContext context) {
		Object[][] datos = null;
		String fuenteDatos = context.getCurrentXmlTest().getParameter("fuenteDatos");
		System.out.println("Fuente de Datos: " + fuenteDatos);
		switch(fuenteDatos){
			case "BD":
				datos = MySql.leerDataAutorMysql();
				break;
			case "Excel":
				String rutaArchivo = context.getCurrentXmlTest().getParameter("rutaArchivo");
				datos = Excel.leerExcel(rutaArchivo);
				break;
		}
		return datos;
	}
	
	
	@Test(dataProvider = "datosEntrada")
	public void insertarAutores(String usuario, String clave, String nombre, String apellido, String nacionalidad, String valorEsperado, String valorEsperado1, String valorEsperado2, String valorEsperado3) throws Exception {
		try {
			iniciarSesionPage.iniciarSesion(usuario, clave);
			String valorObtenido = autorPage.insertarAutor(nombre.trim(), apellido.trim(), nacionalidad.trim(), valorEsperado1.trim(), valorEsperado2.trim(), valorEsperado3.trim());
			Assert.assertEquals(valorObtenido, valorEsperado);
			
		
		}catch(AssertionError e){
			Utilitario.caputarPantallarError(rutaCarpetaError, e.getMessage(), autorPage.getWebDriver());
			Assert.fail(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	/*
	@DataProvider(name = "datosEntradaActualizar")
	public static Object[][] datosPobladosActualizar(ITestContext context) {
		return new String[][] {
			{"admin", 
				"clave", 
				"Menestras",
				"Menestras 2", 
				"Se actualizó de manera correcta la Categoría"}
		};
	}
	
	@Test(dataProvider = "datosEntradaActualizar", 
			dependsOnMethods= {"insertarCategoria"})
	public void actualizarCategoria(String usuario, String clave, 
			String nombreBuscar, String nombreActualizar, 
			String valorEsperado) throws Exception {
		try {
			iniciarSesionPage.iniciarSesion(usuario, clave);
			String valorObtenido = categoriaPage.actualizar(
					nombreBuscar, nombreActualizar);
			Assert.assertEquals(valorObtenido, valorEsperado);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	*/


	@AfterTest
	public void tearDown() throws Exception {
		autorPage.cerrarPagina();
	}

}
