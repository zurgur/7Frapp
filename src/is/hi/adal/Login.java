package is.hi.adal;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Alexander on 4/11/2017.
 */
public class Login{
    //búa til FXML hluti svo við getum notað þá ur skjalinu

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

    tengingVidGagnagrunn t = new tengingVidGagnagrunn();
    //ArrayList<String> userName = t.getUsername();
    ArrayList<String> til = t.getTo();
    ArrayList<String> data = t.getDate();
    ArrayList<String> time = t.getTime();

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
