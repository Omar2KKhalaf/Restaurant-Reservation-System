package sample;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;

public class DisplayOrder {
    ArrayList<Dishes> mainCourse;
    ArrayList<Dishes> Appetizers;
    ArrayList<Dishes> Desert;
    Client client;
    Stage stage;
    ArrayList<Client> newArray;
    ArrayList<Tables> tables;
    public void display(ArrayList<Dishes> mainCourse,ArrayList<Dishes> Appetizers,ArrayList<Dishes> Desert,Client client,ArrayList<Client> newArray,
                        ArrayList<Tables> tables,Stage stage){
        this.mainCourse=mainCourse;
        this.Appetizers=Appetizers;
        this.Desert=Desert;
        this.stage=stage;
        this.newArray=newArray;
        this.tables=tables;
        this.client=client;
    }
    public void newPressed() throws IOException, ParserConfigurationException, SAXException {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("Client.fxml"));
        Parent root1 =fxmlLoader.load() ;
       ClientController clientController=fxmlLoader.getController();
        client.getDishesClient().clear();
        clientController.arGet(mainCourse,Appetizers,Desert,tables,client,stage);
        Scene scene=new Scene(root1,800,500);
        stage.setScene(scene);
    }
    public void showOrder() throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ShowPrev.fxml"));
        Parent root1 =fxmlLoader.load() ;
        Scene scene=new Scene(root1,800,500);
        ShowPrevController showPrevController=fxmlLoader.getController();
        showPrevController.show(client,newArray,stage);
        stage.setScene(scene);

    }
    public void buttonPressed () throws IOException, TransformerException, ParserConfigurationException, SAXException {

        //JOptionPane.showMessageDialog(null, "Total money is : " + String.format("%.2f", client.getTotalPrice()));
        // write.method(users);
        stage.close();
    }
}
