package com.ifpvg.tema1;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.*;

import java.io.*;
public class CrearEmpleXML {

	public static void main(String[] args) throws IOException {

		File fichero = new File ("AleatorioEmple.dat");
		RandomAccessFile file = new RandomAccessFile(fichero, "r");
		
		int id, dep, posicion = 0;
		Double salario;
		char apellido[] = new char [10], aux;
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document document = implementation.createDocument(null, "Empleados", null);
			document.setXmlVersion("1.0");
			
			
			do {
				file.seek(posicion);
				id = file.readInt();
				
				for (int i = 0; i < apellido.length; i++) {
					apellido[i] = file.readChar();
				}
				String apellidoS = new String (apellido);
				dep = file.readInt();
				salario = file.readDouble();
				if (id > 0) {
					Element raiz = document.createElement("empleado");
					document.getDocumentElement().appendChild(raiz);
					CrearElemento("id", Integer.toString(id), raiz, document); //añadir ID
					CrearElemento("apellido", apellidoS.trim(), raiz, document);// apellido
					CrearElemento("dep", Integer.toString(dep), raiz, document);
					CrearElemento("salario", Double.toString(salario), raiz, document);
				}
				posicion = posicion + 36;
				
			} while (file.getFilePointer() != file.length());
			
			Source source = new DOMSource(document);
			Result result = new StreamResult (new java.io.File("Empleados.xml"));
			
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			
		} catch (Exception e) {
			System.err.println("Error: "+e);
			file.close();
		}	
	}
	
	static void CrearElemento(String datoEmple, String valor, Element raiz, Document document) {
		Element elem = document.createElement(datoEmple);
		Text text = document.createTextNode(valor);
		raiz.appendChild(elem);
		elem.appendChild(text);
	}

}
