package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;
public class ClientController {
    ArrayList<Dishes> mainCourse;
    ArrayList<Dishes> Appetizers;
    ArrayList<Dishes> Desert;
    ArrayList<Tables> tables;
    ArrayList<Users> users=new ArrayList<>();
    ArrayList<Client> newArray;
    CalculateAmount calculateAmount;
    Client client;
    Write write=new Write();
    Stage stage;
    CustomerLoad customerLoad=new CustomerLoad();
    @FXML
    Label labels;
    @FXML
    Button button2;
    @FXML
    TextField textField;
    @FXML
    CheckBox checkBox;

    public ClientController() throws TransformerConfigurationException {
    }

    public void arGet(ArrayList<Dishes> mainCourse, ArrayList<Dishes> Appetizers, ArrayList<Dishes> Desert,
                      ArrayList<Tables> tables, Client client,Stage stage) throws IOException, SAXException, ParserConfigurationException {
    calculateAmount = new CalculateAmount();
    this.mainCourse = mainCourse;
    this.Appetizers = Appetizers;
    this.Desert = Desert;
    this.tables=tables;
    this.client=client;
    this.stage=stage;
    newArray= customerLoad.method();
}
public  void check() throws ParserConfigurationException, TransformerException, SAXException, IOException {
    Sorting sorting=new Sorting();
    tables=sorting.sorting(tables);
        if(newArray!=null){
    for(Client x:newArray) {
        for (Tables y : tables) {
            if (y.getTableId() == x.getTableId()) {
                y.setReservationTable(true);
            }
        }
    }
        }
        try {
           int numberOfSeats = Integer.parseInt(textField.getText());
            Validate validate=new Validate(true);
            int check=validate.check(client,numberOfSeats,tables,checkBox.isSelected());
            switch (check){
                case 1:{
                    FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("Order.fxml"));
                    Parent root1 =fxmlLoader.load() ;
                    OrderController orderController=fxmlLoader.getController();
                    orderController.arGet(mainCourse,Appetizers,Desert,client,stage);
                    Scene scene=new Scene(root1,800,500);
                    stage.setScene(scene);
                    break;
                }
                case 0:{
                    labels.setText("No table available");
                    break;
                }
            }
        }
        catch (Exception e){
            labels.setText("Please enter a number");
        }
    }
    public void buttonPressed () throws IOException, TransformerException, ParserConfigurationException, SAXException {
        stage.close();
    }
}
