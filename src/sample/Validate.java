package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Validate {
    List<ArrayList<Dishes>> arrayListDishes;
    ArrayList<Dishes> mainCourse;
    ArrayList<Dishes> appetizers;
    ArrayList<Dishes> desert;
    ArrayList<Users> arrayListUsers;
    ArrayList<Tables> arrayListTab;
    CustomerLoad customerLoad = new CustomerLoad();
    ArrayList<Client> newArray;
    Users find;

    public Validate() throws IOException, SAXException, ParserConfigurationException {
        UsersRead usersRead = new UsersRead();
        arrayListUsers = usersRead.method();
        TablesRead tablesRead = new TablesRead();
        arrayListTab = tablesRead.method();
        DishesRead dishesRead = new DishesRead();
        arrayListDishes = dishesRead.method();
        mainCourse = arrayListDishes.get(0);
        appetizers = arrayListDishes.get(1);
        desert = arrayListDishes.get(2);


    }
    public Validate(boolean x){

    }

    public Users validateUser(String userName, String password) throws IOException {
        boolean found = false;

        for (Users x : arrayListUsers) {
            if (x.getUsername().equals(userName)) {
                if (x.getPasswordname().equals(password)) {

                    find = x;
                    found = true;
                }
                if (found) {
                    return find;
                }

            }
        }
        return null;
    }

    public void window(String role) throws IOException, ParserConfigurationException, SAXException {
        boolean z = true;
        if (role.equals("Manager")) {

            Stage primaryStage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Manager.fxml"));
            Parent root1 = fxmlLoader.load();
            ManagerController managerController = fxmlLoader.getController();
            managerController.showManager(primaryStage);
            primaryStage.setResizable(false);
            primaryStage.setTitle("Manager");
            primaryStage.setScene(new Scene(root1, 800, 500));
            primaryStage.show();

        } else if (role.equals("Cooker")) {
            Stage primaryStage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Cooker.fxml"));
            Parent root1 = fxmlLoader.load();
            CookerController cookerController = fxmlLoader.getController();
            cookerController.showCooker(primaryStage);
            primaryStage.setResizable(false);
            primaryStage.setTitle("Cooker");
            primaryStage.setScene(new Scene(root1, 800, 500));
            primaryStage.show();
        } else if (role.equals("Waiter")) {
            Stage primaryStage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Waiter.fxml"));
            Parent root1 = fxmlLoader.load();
            WaiterController waiterController = fxmlLoader.getController();
            waiterController.showWaiter(primaryStage);
            primaryStage.setResizable(false);
            primaryStage.setTitle("Waiter");
            primaryStage.setScene(new Scene(root1, 800, 500));
            primaryStage.show();
        } else {
            newArray = customerLoad.method();
            Stage primaryStage = new Stage();
            if (newArray != null) {
                for (Users x : newArray) {
                    if (find.getName().equals(x.getName())) {
                        z = false;
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Display.fxml"));
                        Parent root1 = fxmlLoader.load();
                        DisplayOrder displayOrder = fxmlLoader.getController();
                        displayOrder.display(mainCourse, appetizers, desert, (Client) find, newArray, arrayListTab, primaryStage);
                        primaryStage.setResizable(false);
                        primaryStage.setTitle("Client");
                        primaryStage.setScene(new Scene(root1, 800, 500));
                        primaryStage.show();
                    }

                }
            }
            if (z) {
                // Stage primaryStage=new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Client.fxml"));
                Parent root1 = fxmlLoader.load();
                ClientController clientController = fxmlLoader.getController();
                clientController.arGet(mainCourse, appetizers, desert, arrayListTab, (Client) find, primaryStage);
                primaryStage.setResizable(false);
                primaryStage.setTitle("Client");
                primaryStage.setScene(new Scene(root1, 800, 500));
                primaryStage.show();
            }
        }
    }

    public ArrayList<Tables> getTables() {
        return arrayListTab;
    }

    public int check(Client client, int numberOfSeats, ArrayList<Tables> tables, boolean checkBox) {
        for (Tables x : tables) {

            if (numberOfSeats <= x.getNumberOfSeats() && numberOfSeats > 0) {
                if (checkBox) {
                    if (!x.isReservationTable() && String.valueOf(x.isArea()).equals("true")) {
                        client.setTableId(x.getTableId());
                        return 1;
                    }
                } else if (!x.isReservationTable() && String.valueOf(x.isArea()).equals("false")) {
                    x.setReservationTable(Boolean.parseBoolean("True"));
                    client.setTableId(x.getTableId());
                    return 1;
                }
            }
        }
        return 0;
    }
}
