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
public class CustomerLoad {
    public ArrayList<Client> method() throws ParserConfigurationException, IOException, SAXException {
        File tempFile = new File("Customers.xml");
        boolean exists = tempFile.exists();
        if (exists) {
            ArrayList<Client> arrayList = new ArrayList<Client>();
            File document = new File("Customers.xml");
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
                    Client client = new Client();
                    client.setName(element.getElementsByTagName("name").item(0).getTextContent());


                    for (int k = 0; k < ((Element) nNode).getElementsByTagName("nameOfDish").getLength(); k++) {

                        client.getDishesClient().add(element.getElementsByTagName("nameOfDish").item(k).getTextContent());

                    }
                    client.setTableId(Integer.parseInt(element.getElementsByTagName("table").item(0).getTextContent()));
                    client.setTotalPrice(Double.parseDouble(element.getElementsByTagName("TotalPrice").item(0).getTextContent()));
                    arrayList.add(client);

                }
            }
            return arrayList;
        }

        else{
            return null;
        }
    }
}