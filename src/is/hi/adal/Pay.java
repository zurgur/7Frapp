package is.hi.adal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Sigfús on 14.4.2017.
 */
public class Pay {

    @FXML
    private Button pay;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField gender;
    @FXML
    private TextField birthday;
    @FXML
    private TextField nationality;
    @FXML
    private TextField cardholder;
    @FXML
    private TextField cardNumber;
    @FXML
    private TextField cvc;
    @FXML
    private Button goBack;


    public void LoginAction(ActionEvent actionEvent) {
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
}
