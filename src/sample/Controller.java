package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.xml.sax.SAXException;
import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
public class Controller {
    private Validate validate;


    Users find;

    @FXML
    PasswordField textPass;
    @FXML
    TextField textUser;
    @FXML
    Button login;

    public void loginFunc() throws IOException, ParserConfigurationException, SAXException, TransformerException {
        String password = textPass.getText();
        String userName = textUser.getText();
        validate = new Validate();
        Write write=new Write();
        find = validate.validateUser(userName, password);
        if(find==null){
            JOptionPane.showMessageDialog(null, "Not found");
        }
        else{
            validate.window(find.getRole());
        }

    }
    public void signUP() throws IOException, TransformerException, ParserConfigurationException, SAXException {
        Stage primaryStage=new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newClient.fxml"));
        Parent root1 = fxmlLoader.load();
        NewClientController newClientController = fxmlLoader.getController();
        newClientController.text(primaryStage);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Client");
        primaryStage.setScene(new Scene(root1, 800, 500));
        primaryStage.show();
    }

}