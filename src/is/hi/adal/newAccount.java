package is.hi.adal;/**
 * Created by BrynjaPalina on 14/04/2017.
 */

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class newAccount extends Application {

    @FXML
    private JFXTextField user;

    @FXML
    private JFXTextField fullName;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField phoneNumber;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXPasswordField passwordAgain;

    @FXML
    private JFXButton signup;

    @FXML
    private JFXButton goback;


    public void LoginAction(ActionEvent actionEvent) throws IOException {
        Parent root;
        Stage stage;
        stage = (Stage) goback.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }
}
