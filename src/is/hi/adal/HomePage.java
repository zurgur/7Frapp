package is.hi.adal;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.table.TableColumn;

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

    /*@FXML private TableView<MyFlights> table;
    @FXML private TableColumn to;
    @FXML private TableColumn from;
    @FXML private TableColumn date;
    @FXML private TableColumn seat;

    public ObservableList <MyFlights> data = FXCollections.observableArrayList();

    tengingVidGagnagrunnFyrirUser t = new tengingVidGagnagrunnFyrirUser();

    */@Override
    public void initialize(URL location, ResourceBundle resources) {
       // t.getMyFlights(data, table);
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