package is.hi.adal;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by Brynja Palina on 4/11/2017.
 */
public class HomePage implements Initializable{

    @FXML
    private Label userLabel;

    @FXML
    private JFXButton signOut;

    @FXML
    private JFXButton search;

    @FXML
    private JFXButton myFlights;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void GetUser(String user)
    {
        userLabel.setText(user);
    }

    public void SignOut(ActionEvent event)
    {
        try
        {
            Stage stage;
            FXMLLoader loader = new FXMLLoader();
            Pane root = null;
            root = loader.load(getClass().getResource("start.fxml").openStream());
            stage = (Stage) signOut.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void SearchAction(ActionEvent actionEvent) throws IOException
    {
        Parent root;
        Stage stage;
        stage = (Stage) search.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("search.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}