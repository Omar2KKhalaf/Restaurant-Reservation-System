package sample;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import org.xml.sax.SAXException;

import java.io.*;

public class Write {
    Document xmlFile;
    Element root;

    public Write() throws TransformerConfigurationException {
    }

    public void  method(ArrayList<Client> clients) throws ParserConfigurationException, IOException, TransformerException, SAXException {
        File tempFile = new File("Customers.xml");
        boolean exists = tempFile.exists();
        if(!exists) {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            xmlFile = documentBuilder.newDocument();
            root=xmlFile.createElement("users");
            xmlFile.appendChild(root);
        }else {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            xmlFile= builder.parse(tempFile);
            root=xmlFile.getDocumentElement();
        }
        for(Client x:clients){
        Element userElement=xmlFile.createElement("user");
        root.appendChild(userElement);
        Text nameClient=xmlFile.createTextNode(x.getName());
        Element name=xmlFile.createElement("name");
        name.appendChild(nameClient);
        userElement.appendChild(name);
        Element dishElements=xmlFile.createElement("dish");
        userElement.appendChild(dishElements);
        for(String y:x.getDishesClient()) {
            Text dishName=xmlFile.createTextNode(y);
            Element dish = xmlFile.createElement("nameOfDish");
            dish.appendChild(dishName);
            dishElements.appendChild(dish);
        }
        Text tableIdClient=xmlFile.createTextNode(String.valueOf(x.getTableId()));
        Element tableClient=xmlFile.createElement("table");
        tableClient.appendChild(tableIdClient);
        userElement.appendChild(tableClient);
        Element totalClient=xmlFile.createElement("TotalPrice");
        Text totalClientValue=xmlFile.createTextNode(String.format("%.3f",x.getTotalPrice()));
        totalClient.appendChild(totalClientValue);
        userElement.appendChild(totalClient);

    }
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(xmlFile);
        StreamResult streamResult = new StreamResult(new File("Customers.xml"));
        transformer.transform(domSource, streamResult);

    }
    public void  method(Client clients) throws ParserConfigurationException, IOException, TransformerException, SAXException {
        File tempFile = new File("Resturant.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            xmlFile= builder.parse(tempFile);
            root=xmlFile.getDocumentElement();
           NodeList root1 = root.getElementsByTagName("users");
        Node node=root1.item(0);
            Element userElement=xmlFile.createElement("user");
            node.appendChild(userElement);
            Text nameClient=xmlFile.createTextNode(clients.getName());
            Element name=xmlFile.createElement("name");
            name.appendChild(nameClient);
            userElement.appendChild(name);
            Element role=xmlFile.createElement("role");
            Text roletype=xmlFile.createTextNode("Client");
            role.appendChild(roletype);
            userElement.appendChild(role);
        Text username=xmlFile.createTextNode(clients.getUsername());
        Element newName=xmlFile.createElement("username");
        newName.appendChild(username);
        userElement.appendChild(newName);
        Text password=xmlFile.createTextNode(clients.getPasswordname());
        Element password1=xmlFile.createElement("password");
        password1.appendChild(password);
        userElement.appendChild(password1);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(xmlFile);
        StreamResult streamResult = new StreamResult(new File("Resturant.xml"));
        transformer.transform(domSource, streamResult);

    }
}

