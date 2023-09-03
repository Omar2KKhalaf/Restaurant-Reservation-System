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
import java.util.*;


public class DishesRead {
    public List<ArrayList<Dishes>> method() throws ParserConfigurationException, IOException, SAXException {
        List<ArrayList<Dishes>> ar=new ArrayList<>();
        ArrayList<Dishes> mainCourse = new ArrayList<Dishes>();
        ArrayList<Dishes> appetizers = new ArrayList<Dishes>();
        ArrayList<Dishes> desert = new ArrayList<Dishes>();
        File document = new File("Resturant.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document doc = builder.parse(document);
       // System.out.println("Root element " + doc.getDocumentElement().getNodeName());
        NodeList nodeList = doc.getElementsByTagName("dish");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nNode = nodeList.item(i);
            // System.out.println("Node name "+nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nNode;
                Dishes dishes=new Dishes(
                        element.getElementsByTagName("name").item(0).getTextContent(),
                        Integer.parseInt(element.getElementsByTagName("price").item(0).getTextContent()),
                        element.getElementsByTagName("type").item(0).getTextContent());
                if(dishes.getType().equals("main_course"))
                mainCourse.add(dishes);

                else if(dishes.getType().equals("desert")){
                    desert.add(dishes);
                }
                else{
                    appetizers.add(dishes);
                }
            }

        }
        ar.add(mainCourse);
        ar.add(appetizers);
        ar.add(desert);
        return ar;

    }
}
