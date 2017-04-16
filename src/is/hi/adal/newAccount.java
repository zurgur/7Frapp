package is.hi.adal;

/**
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
import sample.tengingVidGagnagrunnFyrirUser;

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

    @FXML
    private JFXTextField errorMessage;

    tengingVidGagnagrunnFyrirUser t = new tengingVidGagnagrunnFyrirUser();

    public void LoginAction(ActionEvent actionEvent) throws IOException {
        Parent root;
        Stage stage;
        stage = (Stage) goback.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SuccessAction(ActionEvent actionEvent) throws IOException {
        makeNewAccount();
        Parent root;
        Stage stage;
        stage = (Stage) signup.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("NewAccountSuccess.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void makeNewAccount()
    {
        errorMessage.setText("");

        String username = user.getText();
        String name = fullName.getText();
        String mail = email.getText();
        String phone = phoneNumber.getText();
        String pass = password.getText();
        String passAgain = passwordAgain.getText();

        String [] newAccount = {username, name, mail, phone, pass, passAgain};
        int count = 0;

        for(int i=0; i< newAccount.length; i++)
        {
            if(newAccount[i] != null)
            {
                count += 1;
            }
            i++;
        }

        if(count == 6 && pass == passAgain)
        {
            t.insertNewUser(username, pass, name, mail, phone);
        }
        else if(count != 6)
        {
            errorMessage.setText("Please fill in all your information");
        }
        else if(pass != passAgain)
        {
            errorMessage.setText("Passwords don't match each other");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }
}
