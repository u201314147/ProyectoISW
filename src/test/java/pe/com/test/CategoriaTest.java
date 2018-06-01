package pe.com.test;

import org.testng.annotations.Test;

import pe.com.core.business.CategoriaBusiness;
import pe.com.core.entity.Categoria;
import pe.com.test.bean.CategoriaBean;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

public class CategoriaTest {

	private final CategoriaBusiness categoriaBusiness 
											= new CategoriaBusiness();
	private static Categoria categoria;
	
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Inicio de la Clase");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Fin de la Clase");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Antes de cada Test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Despues de cada Test");
	}
	
	
	@DataProvider(name = "datosDeCategoria")
	public static Object[][] datosDeCategoria(){
		return new Object[][] {
			{new CategoriaBean("Categoria 01")},
			{new CategoriaBean("Categoria 02")},
			{new CategoriaBean("Categoria 03")}
		};
	}
	
	@Test
	public void insertar() {
		try {
			//Entrada
			System.out.println("Met. Insertar");
			categoria = new Categoria();
			categoria.setNombre("Chocolates");
			//Ejecutar
			categoriaBusiness.insertar(categoria);
			//Verificar
			Assert.assertTrue(categoria.getIdCategoria()>0);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	@Test
	@Parameters({"nombreInsertar"})
	public void insertarConParametro(String nomInsertar) {
		try {
			//Entrada
			System.out.println("Met. Insertar con Parametro");
			categoria = new Categoria();
			categoria.setNombre(nomInsertar);
			//Ejecutar
			categoriaBusiness.insertar(categoria);
			//Verificar
			Assert.assertTrue(categoria.getIdCategoria()>0);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	@Test(dataProvider="datosDeCategoria")
	public void insertarDataProvider(CategoriaBean categoriaBean) {
		try {
			//Entrada
			System.out.println("Met. Insertar");
			categoria = new Categoria();
			categoria.setNombre(categoriaBean.getNombre());
			//Ejecutar
			categoriaBusiness.insertar(categoria);
			//Verificar
			Assert.assertTrue(categoria.getIdCategoria()>0);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(dependsOnMethods= {"insertar"}, timeOut=2000)
	public void actualizar() {
		try {
			System.out.println("Met. Actualizar");
			categoria.setNombre("Menestras");
			categoriaBusiness.actualizar(categoria);
			Assert.assertTrue(categoria.getIdCategoria()>0);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(timeOut=2000)
	public void metodoFueraDeTiempo() {
		try {
			Assert.assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	

}
