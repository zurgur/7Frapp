package is.hi.adal;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

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
    private JFXListView myList;
    private tengingVidGagnagrunn con = new tengingVidGagnagrunn();

    /*@FXML private TableView<MyFlights> table;
    @FXML private TableColumn to;
    @FXML private TableColumn from;
    @FXML private TableColumn date;
    @FXML private TableColumn seat;

    public ObservableList <MyFlights> data = FXCollections.observableArrayList();

    tengingVidGagnagrunnFyrirUser t = new tengingVidGagnagrunnFyrirUser();

    */@Override
    public void initialize(URL location, ResourceBundle resources) {
       String user = userLabel.getText();
        java.sql.Connection tengng = con.connection();
        String select = "SELECT * FROM UserFlight WHERE username =\"" + user +"\" ";


        Statement statement = null;
        try {
            statement = tengng.createStatement();
            String s = "SELECT * " +
                    "FROM UserFlight"; //+

            //executar og finnur allt í töfnunni
            statement.execute(s);
            //hluur sem er með því sem kom út
            ResultSet rs = statement.getResultSet();
            //while sem fer í geggn um result göggnin
            while( rs.next() ) {
                String name = rs.getString("username");
                String from = rs.getString("from");
                System.out.println(name + from);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


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