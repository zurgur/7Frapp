package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Alexander on 4/11/2017.
 */
public class Login{
    //búa til FXML hluti svo við getum notað þá ur skjalinu

    @FXML
    private TextField user;

    @FXML
    private PasswordField password;

    @FXML
    private Button login;

    @FXML
    private Button signup;

    @FXML
    private Button goback;

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

    public void StartAction(ActionEvent actionEvent) throws IOException {
        Parent root;
        Stage stage;
        stage = (Stage) goback.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("start.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SignUpAction(ActionEvent actionEvent) throws IOException {
        Parent root;
        Stage stage;
        stage = (Stage) signup.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("newAccountGUI.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
