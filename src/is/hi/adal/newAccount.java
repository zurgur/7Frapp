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
        int account = makeNewAccount();
        if(account == 1)
        {
            insertNewMember();
            Parent root;
            Stage stage;
            stage = (Stage) signup.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("NewAccountSuccess.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if(account == 0)
        {
            System.out.println("vantar");
            errorMessage.setText("Please fill in all your information");
        }
        else if(account == -1)
        {
            System.out.println("password");
            errorMessage.setText("Passwords don't match each other");
        }

    }

    public int makeNewAccount()
    {
        String username = user.getText();
        String name = fullName.getText();
        String mail = email.getText();
        String phone = phoneNumber.getText();
        String pass = password.getText();
        String passAgain = passwordAgain.getText();

        String [] newAccount = {username, name, mail, phone, pass, passAgain};
        int count = 0;
        int tilfelli = 0;
        for(int i=0; i<newAccount.length; i++)
        {
            System.out.println("forlykkja");
            if(newAccount[i].length() != 0)
            {
                count += 1;
                System.out.println("lúppa"+i);
            }
            else System.out.println("ekkert");
        }
        System.out.println("count: " + count);
        System.out.println("password: " + pass);
        System.out.println("passwordAgain: " + passAgain);

        if(count == 6 && pass.equals(passAgain))
        {
            tilfelli = 1;
            System.out.println("tilfelli 1");
        }
        else if(count < 6)
        {
            tilfelli = 0;
            System.out.println("tilfelli 0");
        }
        else if(pass != passAgain)
        {
            tilfelli = -1;
            System.out.println("tilfelli -1");
        }
        System.out.println("tilfelli done");
        return tilfelli;
    }

    public void insertNewMember()
    {
        String username = user.getText();
        String name = fullName.getText();
        String mail = email.getText();
        String phone = phoneNumber.getText();
        String pass = password.getText();

        t.insertNewUser(username, pass, name, mail, phone);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }
}
