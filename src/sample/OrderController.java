package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;

public class OrderController {
    ArrayList<Dishes> mainCourse;
    ArrayList<Dishes> Appetizers;
    ArrayList<Dishes> Desert;
    CalculateAmount calculateAmount;
    Client client;
    Stage stage;
    ArrayList<Client> users=new ArrayList<>();
    Write write=new Write();
    int flag=-1;
    @FXML
    ComboBox comboBox;
    @FXML
    ComboBox combo2;
    @FXML
    ComboBox combo3;
    @FXML
    Label label;
    @FXML
    Label labels;
    @FXML
    Label labelName;

    public OrderController() throws TransformerConfigurationException {
    }


    public void arGet(ArrayList<Dishes> mainCourse, ArrayList<Dishes> Appetizers, ArrayList<Dishes> Desert,Client client1,Stage stage
    ) throws IOException, SAXException, ParserConfigurationException {
        calculateAmount = new CalculateAmount();
        this.mainCourse = mainCourse;
        this.Appetizers = Appetizers;
        this.Desert = Desert;
        client=client1;
        this.stage=stage;
        labelName.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        label.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        comboBox.getItems().removeAll(comboBox.getItems());
        comboBox.getItems().add("Main Courses : ");
        for(Dishes x:mainCourse){
            comboBox.getItems().add(x.getName());
        }

        comboBox.valueProperty().addListener((observable, oldValue, newValue) -> {

            if(!newValue.equals("Main Courses : ")){
                client.getDishesClient().add((String) newValue);
                for (Dishes x : mainCourse) {

                    if (x.getName().equals(newValue)) {
                        calculateAmount.setTotalMainCourse(x.getPrice());
                        label.setText(String.valueOf(x.getPrice()));
                        labelName.setText(x.getName());
                    }
                }
                comboBox.valueProperty().setValue("Main Courses : ");
            }
        });
        combo2.getItems().removeAll(combo2.getItems());
        combo2.getItems().add("Appetizers : ");
        for(Dishes x:Appetizers){
            combo2.getItems().add(x.getName());
        }
        combo2.valueProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue.equals("Appetizers : ")) {
                client.getDishesClient().add((String) newValue);
                for (Dishes x : Appetizers) {
                    if (x.getName().equals(newValue)) {

                        calculateAmount.setTotalAppetizers(x.getPrice());
                        label.setText(String.valueOf(x.getPrice()));
                        labelName.setText(x.getName());
                    }
                }
                combo2.valueProperty().setValue("Appetizers : ");

            }
        });
        combo3.getItems().removeAll(combo3.getItems());
        combo3.getItems().add("Deserts : ");
        for(Dishes x:Desert){
            combo3.getItems().add(x.getName());
        }
        combo3.valueProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue.equals("Deserts : ")) {
                client.getDishesClient().add((String) newValue);
                for (Dishes x : Desert) {
                    if (x.getName().equals(newValue)) {
                        calculateAmount.setTotalDesert(x.getPrice());
                        label.setText(String.valueOf(x.getPrice()));
                        labelName.setText(x.getName());
                    }
                }
                combo3.valueProperty().setValue("Deserts : ");
            }
        });
        stage.setOnCloseRequest(windowEvent -> {
            if(flag==0){
                users.add(client);
                try {
                    write.method(users);
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (TransformerException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                }
            }
        });



    }
    public void save() throws ParserConfigurationException, TransformerException, SAXException, IOException {
        client.setTotalPrice(calculateAmount.getTotalMainCourse()+calculateAmount.getTotalAppetizers()+calculateAmount.getTotalDesert());
        if(client.getTotalPrice()!=0) {
           flag=0;
            labels.setText("Your order have been successfully made your table number is:" + client.getTableId());
        }else {
            JOptionPane.showMessageDialog(null, "you must order at least one dish try again please");
            stage.close();
        }
    }
    public void buttonPressed () throws IOException, TransformerException, ParserConfigurationException, SAXException {
        if(client.getTotalPrice()!=0) {
            flag=1;
            users.add(client);
            write.method(users);
            JOptionPane.showMessageDialog(null, "Total money is : " + String.format("%.2f", client.getTotalPrice()));
        }else  JOptionPane.showMessageDialog(null, "you must Save before logout");
        stage.close();
    }
}