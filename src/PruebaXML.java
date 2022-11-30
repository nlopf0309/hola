

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class PruebaXML {
    public static void main (String[] args) {
        try {
            DocumentBuilderFactory factory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse(new
                    File("Curriculum.xml"));
            NodeList listavc = documento.getElementsByTagName("Practice");
            for (int i = 0; i < listavc.getLength(); i ++) {
                Node nodo = listavc.item(i);
                if(nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) nodo ;
                    NodeList hijos = e.getChildNodes ();
                    for (int j = 0; j < hijos.getLength(); j ++) {
                        Node hijo = hijos.item( j );
                        if(hijo.getNodeType() == Node.ELEMENT_NODE) {
                            Element eHijo = (Element) hijo;
                            System.out.println ("Propiedad: " +
                                    hijo.getNodeName() + ",Valor: " + hijo.getTextContent ());
                        }
                    }
                    System.out.println("");
                }
            }
        } catch (ParserConfigurationException | SAXException |
                 IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
