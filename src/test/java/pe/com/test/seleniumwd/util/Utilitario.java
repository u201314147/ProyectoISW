package pe.com.test.seleniumwd.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public final class Utilitario {

	public static void caputarPantallarError(String rutaCarpeta, String mensajeError, WebDriver webDriver) {
		try {
			String nombreArchivo = new SimpleDateFormat("ddMMyyyy-hhmmssSSS").format(new Date());
			File capturaDePantalla = ((TakesScreenshot)webDriver ).getScreenshotAs(OutputType.FILE);
			new File(rutaCarpeta).mkdirs();
			FileUtils.copyFile(capturaDePantalla, new File(rutaCarpeta + "\\" + nombreArchivo + ".jpg"));
			File archivoMensajeError = new File(rutaCarpeta + "\\" + nombreArchivo + ".txt");
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(archivoMensajeError));
			bufferedWriter.write(mensajeError);
			bufferedWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Utilitario() {

	}
}
