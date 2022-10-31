package Ejercicios;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class LecturaEmpleadosXML {
    public LecturaEmpleadosXML(){
        try {
            LeerXml();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void LeerXml() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("Empleados.xml"));
        var nodeName =document.getDocumentElement().getNodeName();
        var nodeList = document.getElementsByTagName("empleado");

        for (int i = 0; i <nodeList.getLength() ; i++) {
            System.out.println(nodeList.item(i));
        }

    }
}
