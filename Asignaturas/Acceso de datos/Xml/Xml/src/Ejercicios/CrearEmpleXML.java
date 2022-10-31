package Ejercicios;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class CrearEmpleXML {
    public CrearEmpleXML() {
        try {
            System.out.println("a");
            doStuff();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    private void doStuff() throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation= builder. getDOMImplementation();
        Document document=implementation.createDocument(null,"Empleados",null);

        Element raiz = document.createElement("empleado");
        document.getDocumentElement().appendChild(raiz);
        Element elem = document.createElement("id");
        document.getDocumentElement().appendChild(elem);
        Text text = document.createTextNode("1");
        elem.appendChild(text);
        elem = document.createElement("apellido");
        raiz.appendChild(elem);
        text = document.createTextNode("FERNÁNDEZ");
        elem.appendChild(text);
        elem = document.createElement("dep");
        raiz.appendChild(elem);
        text = document.createTextNode("10");
        elem.appendChild(text);
        elem = document.createElement("salario");
        raiz.appendChild(elem);
        text = document.createTextNode("1000.45");
        elem.appendChild(text);

        Guardar(document);

    }

    private void Guardar(Node document ) throws TransformerException {
        Source source = new DOMSource(document);
        Result result = new StreamResult(new java.io.File("Empleados.xml"));
// Se obtiene un TransformerFactory:
        Transformer transformer= TransformerFactory.newInstance().newTransformer();
        transformer.transform(source,result);
        Result console=new StreamResult(System.out);
        transformer.transform(source,console);

    }
}
