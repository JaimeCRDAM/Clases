package com.ifpvg.tema1;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class Conversor {

	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub
		String hojaEstilo = "empleadosPlantilla.xsl";
		String datosAlumnos = "Empleados.xml";
		File pagHTML = new File("mipaginaE.html");
		FileOutputStream os = new FileOutputStream(pagHTML);
		Source estilos = new StreamSource(hojaEstilo);
		Source datos= new StreamSource(datosAlumnos);
		StreamResult result = new StreamResult(os);
		try {
			Transformer transformer = TransformerFactory.newInstance().newTransformer(estilos);
			transformer.transform(datos, result);
					
		
		} catch (Exception e) { 
			System.out.println("Error: " +e);
			// TODO: handle exception
		}
		
		os.close();

	}


}
