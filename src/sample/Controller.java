package sample;

import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;
import java.io.IOException;


public class Controller {
    //búa til FXML hluti svo við getum notað þá ur skjalinu
    @FXML
    private Button Search;
    @FXML
    private Button Loggin;

    // handler sem fer í serch senuna
    public void searchAction(ActionEvent actionEvent) throws IOException {
        Parent root;
        Stage stage;
        stage = (Stage) Search.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("search.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void LoginAction(ActionEvent actionEvent) throws IOException {
        Parent root;
        Stage stage;
        stage = (Stage) Search.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
