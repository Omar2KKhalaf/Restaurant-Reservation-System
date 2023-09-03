package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;


public class ManagerController {
    CustomerLoad customerLoad=new CustomerLoad();
    CalculateAmount calculateAmount=new CalculateAmount();
    ArrayList<Client> users;
    Stage stage;
    @FXML
    TextField textField;
    @FXML
    ListView<String> listView;
    @FXML
    Label labels;
    public void showManager(Stage stage) throws IOException, SAXException, ParserConfigurationException {
        String s="";
        labels.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        users=customerLoad.method();
        this.stage=stage;
        listView.getItems().removeAll(listView.getItems());
        int i=1;
        int j=1;
       if(users!=null){
        for(Client x:users){

                    for(String y:x.getDishesClient()){
                        s=s+y+"\n";
                    }
            listView.getItems().add("Customer "+ i + "\n"+"Name: "+x.getName()+"\n"+"Table Id: "+x.getTableId()+"\n"+
                    "Total amount: "+x.getTotalPrice()+ "\n"+" order:\n"+s);
                s="";
            i++;
                    calculateAmount.setTotalDay(x.getTotalPrice());
        }
        labels.setText(String.valueOf(calculateAmount.getTotalDay()));
    }else {
           listView.getItems().add("No orders has been made");
           labels.setText(String.valueOf(calculateAmount.getTotalDay()));
       }
    }
    public void buttonPressed () throws IOException, TransformerException, ParserConfigurationException, SAXException {

        stage.close();
    }
}
