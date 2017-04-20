package is.hi.adal;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

/**
 * Created by Sunna on 14.4.2017.
 */
public class Pay {

    @FXML
    private JFXButton pay;
    @FXML
    private JFXTextField firstName;
    @FXML
    private JFXTextField lastName;
    @FXML
    private JFXTextField gender;
    @FXML
    private JFXTextField birthday;
    @FXML
    private JFXTextField nationality;
    @FXML
    private JFXTextField cardholder;
    @FXML
    private JFXTextField cardNumber;
    @FXML
    private JFXTextField cvc;
    @FXML
    private JFXButton goBack;
    @FXML
    private JFXTextField errorMessage;

    tengingVidGagnagrunnFyrirPay t = new tengingVidGagnagrunnFyrirPay();

    public void LoginAction(ActionEvent actionEvent) throws IOException {
        int paying = paydo();
        if(paying == 1)
        {
            insertPayingInfo();
            Parent root;
            Stage stage;
            stage = (Stage) pay.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("finish.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if(paying == 0)
        {
            System.out.println("vantar");
            errorMessage.setText("Please fill in all your information");
        }
    }

    public int paydo()
    {
        String firstname = firstName.getText();
        String lastname = lastName.getText();
        String sex = gender.getText();
        String ssn = birthday.getText();
        String country = nationality.getText();

        String [] newAccount = {firstname, lastname, sex, ssn, country};
        int count = 0;
        int caseR = 0;
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

        if(count == 6)
        {
            caseR = 1;
            System.out.println("tilfelli 1");
        }
        else if(count < 6)
        {
            caseR = 0;
            System.out.println("tilfelli 0");
        }
        return caseR;
    }

    public void insertPayingInfo()
    {
        //user gera if lykkju
        String firstname = firstName.getText();
        String lastname = lastName.getText();
        String sex = gender.getText();
        String ssn = birthday.getText();
        String country = nationality.getText();


       // t.insertNewBooking(firstname, lastname, sex, ssn, country);
    }

    public void FlightsAction(ActionEvent actionEvent) throws IOException
    {
        Parent root;
        Stage stage;
        stage = (Stage) goBack.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("flights.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }




}
