package sample;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TablesRead implements LoadingFiles{
    public ArrayList<Tables> method() throws ParserConfigurationException, IOException, SAXException {
        ArrayList<Tables> arrayList = new ArrayList<Tables>();
        File document = new File("Resturant.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document doc = builder.parse(document);
       // System.out.println("Root element " + doc.getDocumentElement().getNodeName());
        NodeList nodeList = doc.getElementsByTagName("table");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nNode = nodeList.item(i);
            // System.out.println("Node name "+nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nNode;
                Tables tables = new Tables(
                        Integer.parseInt(element.getElementsByTagName("number").item(0).getTextContent()),
                        Integer.parseInt(element.getElementsByTagName("number_of_seats").item(0).getTextContent()),
                        Boolean.parseBoolean(element.getElementsByTagName("smoking").item(0).getTextContent()));
                        arrayList.add(tables);
            }

        }
        return arrayList;
    }

}