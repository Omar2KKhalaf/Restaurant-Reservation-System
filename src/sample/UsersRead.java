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

public class UsersRead implements LoadingFiles {

    public  ArrayList<Users> method() throws ParserConfigurationException, IOException, SAXException {
        ArrayList<Users> arrayList = new ArrayList<Users>();
        File document = new File("Resturant.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document doc = builder.parse(document);
        //System.out.println("Root element " + doc.getDocumentElement().getNodeName());
        NodeList nodeList = doc.getElementsByTagName("user");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nNode = nodeList.item(i);
            // System.out.println("Node name "+nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nNode;
                if (element.getElementsByTagName("role").item(0).getTextContent() .equals("Manager")) {
                    Users manager = new Manager(
                            element.getElementsByTagName("name").item(0).getTextContent(),
                            element.getElementsByTagName("password").item(0).getTextContent(),
                            element.getElementsByTagName("username").item(0).getTextContent());
                    arrayList.add(manager);

                } else if (element.getElementsByTagName("role").item(0).getTextContent() .equals("Cooker")) {
                    Users cooker = new Cooker(element.getElementsByTagName("name").item(0).getTextContent(),
                            element.getElementsByTagName("password").item(0).getTextContent(),
                            element.getElementsByTagName("username").item(0).getTextContent());
                    arrayList.add(cooker);
                } else if (element.getElementsByTagName("role").item(0).getTextContent() .equals("Waiter")) {
                    Users waiter = new Waiter(element.getElementsByTagName("name").item(0).getTextContent(),
                            element.getElementsByTagName("password").item(0).getTextContent(),
                            element.getElementsByTagName("username").item(0).getTextContent());
                    arrayList.add(waiter);
                } else {
                    Users client = new Client(element.getElementsByTagName("name").item(0).getTextContent(),
                            element.getElementsByTagName("password").item(0).getTextContent(),
                            element.getElementsByTagName("username").item(0).getTextContent());
                    arrayList.add(client);
                }
            }
        }
        return arrayList;
    }
}