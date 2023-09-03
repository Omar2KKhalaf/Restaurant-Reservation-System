package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;

public class ShowPrevController {
    Client client;
    ArrayList<Client> users;
    @FXML
    ListView view1;
    Stage stage;
    public void show(Client client, ArrayList<Client> users, Stage stage) {
        this.client = client;
        this.users = users;
        this.stage=stage;
        view1.getItems().removeAll(view1.getItems());
        for (Client x : users) {
            if (x.getName().equals(client.getName())) {
                view1.getItems().add("name: " + x.getName() + " Table Id: "
                        + String.valueOf(x.getTableId()) + " Total Price: "+x.getTotalPrice() +" Order: ");
                for (String y : x.getDishesClient()) {
                    view1.getItems().add(y);
                }
            }
        }
    }
    public void buttonPressed () throws IOException, TransformerException, ParserConfigurationException, SAXException {

        stage.close();
    }
}
