package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class NewClientController {
    @FXML
    TextField textField;
    @FXML
    TextField textField1;
    @FXML
    TextField textField2;
    Stage stage;
    @FXML
    Label label;
    public void text(Stage stage){
        this.stage=stage;
    }
    public void setTextField() throws TransformerException, ParserConfigurationException, SAXException, IOException {
        String name=textField.getText();
        String username=textField1.getText();
        String pass=textField2.getText();
        if(!(name.equals("") || username.equals("")||pass.equals(""))) {
            Client client = new Client(name, pass, username);
            Write write = new Write();
            write.method(client);
            stage.close();
        }else
            JOptionPane.showMessageDialog(null, "Invalid data");
        stage.close();
    }
    public void close(){
        stage.close();
    }
}
