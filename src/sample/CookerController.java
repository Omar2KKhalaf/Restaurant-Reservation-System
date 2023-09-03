package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;


public class CookerController {
    @FXML
    TextField textField;
    @FXML
    ListView<String> listView;
    @FXML
    Label labels;

    ArrayList<Client> users;
    Stage stage;
    CustomerLoad customerLoad=new CustomerLoad();


    public  void showCooker( Stage stage) throws IOException, SAXException, ParserConfigurationException {

        users=customerLoad.method();
        this.stage=stage;
    int i=1;
        listView.getItems().removeAll(listView.getItems());
    if(users!=null) {

        for (Client x : users) {
            listView.getItems().add("#" + i + "\n" + "Table number: " + x.getTableId() + "\n" + " orders : ");
            for (String y : x.getDishesClient()) {
                listView.getItems().add(y);
            }
            i++;
        }
    }else listView.getItems().add("No orders has been made");
    }
    public void buttonPressed () throws IOException, TransformerException, ParserConfigurationException, SAXException {

        stage.close();
    }

}
