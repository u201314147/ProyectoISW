package pe.com.test.seleniumwd.fuenteDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MySql {
	private static Connection cn = null;
	private static PreparedStatement pr = null;
	private static ResultSet rs = null;

	public static String[][] leerDataAutorMysql() {
		String[][]  datos = null;
		int i = 0;
		try {
			cn = obtenerConexion();
			pr = cn.prepareStatement("SELECT * FROM dataautor");
			rs = pr.executeQuery();
			datos = new String[numeroFilas(rs)][9];
			while (rs.next()) {
				datos[i][0] = rs.getString("Usuario");
				datos[i][1] = rs.getString("Clave");
				datos[i][2] = rs.getString("Nombres");
				datos[i][3] = rs.getString("Apellidos");
				datos[i][4] = rs.getString("Nacionalidad");
				datos[i][5] = rs.getString("ValorEsperado");
				datos[i][6] = rs.getString("ValorEsperado1");
				datos[i][7] = rs.getString("ValorEsperado2");
				datos[i][8] = rs.getString("ValorEsperado3");
				
				i++;	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				pr.close();
			} catch (Exception e) {
			}
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return datos;
	}
	
	public static String[][] leerDataAutorEditMysql() {
		String[][]  datos = null;
		int i = 0;
		try {
			cn = obtenerConexion();
			pr = cn.prepareStatement("SELECT * FROM dataautoredit");
			rs = pr.executeQuery();
			datos = new String[numeroFilas(rs)][6];
			while (rs.next()) {
				datos[i][0] = rs.getString("Usuario");
				datos[i][1] = rs.getString("Clave");
				datos[i][2] = rs.getString("Buscar");
				datos[i][2] = rs.getString("Nombres");
				datos[i][3] = rs.getString("Apellidos");
				datos[i][4] = rs.getString("Nacionalidad");
				datos[i][5] = rs.getString("ValorEsperado");
				i++;	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				pr.close();
			} catch (Exception e) {
			}
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return datos;
	}
	
	public static String[][] leerDataAutorElimMysql() {
		String[][]  datos = null;
		int i = 0;
		try {
			cn = obtenerConexion();
			pr = cn.prepareStatement("SELECT * FROM dataautorelim");
			rs = pr.executeQuery();
			datos = new String[numeroFilas(rs)][4];
			while (rs.next()) {
				datos[i][0] = rs.getString("Usuario");
				datos[i][1] = rs.getString("Clave");
				datos[i][2] = rs.getString("Buscar");
				datos[i][3] = rs.getString("ValorEsperado");
				i++;	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				pr.close();
			} catch (Exception e) {
			}
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return datos;
	}
	
	
	public static String[][] leerDataLibroMysql() {
		String[][]  datos = null;
		int i = 0;
		try {
			cn = obtenerConexion();
			pr = cn.prepareStatement("SELECT * FROM datalibro");
			rs = pr.executeQuery();
			datos = new String[numeroFilas(rs)][7];
			while (rs.next()) {
				datos[i][0] = rs.getString("Usuario");
				datos[i][1] = rs.getString("Clave");
				datos[i][2] = rs.getString("Titulo");
				datos[i][3] = rs.getString("Precio");
				datos[i][4] = rs.getString("isbn");
				datos[i][5] = rs.getString("sinopsis");
				datos[i][6] = rs.getString("MensajeEsperado");
				
				i++;	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				pr.close();
			} catch (Exception e) {
			}
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return datos;
	}
	
	public static String[][] leerDataLibroEditMysql() {
		String[][]  datos = null;
		int i = 0;
		try {
			cn = obtenerConexion();
			pr = cn.prepareStatement("SELECT * FROM datalibroedit");
			rs = pr.executeQuery();
			datos = new String[numeroFilas(rs)][8];
			while (rs.next()) {
				datos[i][0] = rs.getString("Usuario");
				datos[i][1] = rs.getString("Clave");
				datos[i][2] = rs.getString("BuscarPrecio");
				datos[i][3] = rs.getString("Titulo");
				datos[i][4] = rs.getString("Precio");
				datos[i][5] = rs.getString("isbn");
				datos[i][6] = rs.getString("sinopsis");
				datos[i][7] = rs.getString("MensajeEsperado");
				
				i++;	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				pr.close();
			} catch (Exception e) {
			}
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return datos;
	}
	
	public static String[][] leerDataLibroElimMysql() {
		String[][]  datos = null;
		int i = 0;
		try {
			cn = obtenerConexion();
			pr = cn.prepareStatement("SELECT * FROM datalibroelim");
			rs = pr.executeQuery();
			datos = new String[numeroFilas(rs)][4];
			while (rs.next()) {
				datos[i][0] = rs.getString("Usuario");
				datos[i][1] = rs.getString("Clave");
				datos[i][2] = rs.getString("BuscarPrecio");
				datos[i][3] = rs.getString("MensajeEsperado");
				i++;	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				pr.close();
			} catch (Exception e) {
			}
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return datos;
	}
	private static Connection obtenerConexion() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/libreriavirtualtest?useSSL=false";
		Connection conexion=DriverManager.getConnection(url,"root","");
		return conexion;	
	}
	
	private static int numeroFilas(ResultSet resultSet){
	    int totalFilas = 0;
	    try {
	        resultSet.last();
	        totalFilas = resultSet.getRow();
	        resultSet.beforeFirst();
	    } 
	    catch(Exception ex)  {
	        return 0;
	    }
	    return totalFilas ;    
	}
}
