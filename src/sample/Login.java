package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;
import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Created by Alexander on 4/11/2017.
 */
public class Login{
    //búa til FXML hluti svo við getum notað þá ur skjalinu
    @FXML
    private Button tilBaka;

    @FXML
    private JFXTextField user;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton login;

    @FXML
    private JFXButton signup;

    @FXML
    private JFXButton goback;

    @FXML
    void makeLogin(ActionEvent event)
    {
        String username = user.getText();
        String pass = password.getText();
        if(username.equals("Genuine") && pass.equals("coder"))
        {
            System.out.println("Welcome");
        }
        else
        {
            System.out.println("Wrong password");
        }
    }



    public void searchAction(ActionEvent actionEvent) throws IOException{
        Parent root;
        Stage stage;
        stage = (Stage) tilBaka.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("start.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void StartAction(ActionEvent actionEvent) throws IOException {
        Parent root;
        Stage stage;
        stage = (Stage) goback.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("start.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
