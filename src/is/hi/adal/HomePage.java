package is.hi.adal;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    private TableView<UserFlight> myTable;
    @FXML
    private TableColumn<UserFlight, String> fra;
    @FXML
    private TableColumn<UserFlight, String> til;
    @FXML
    private TableColumn<UserFlight, String> dagur;
    @FXML
    private TableColumn<UserFlight, String> saeti;

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
            ArrayList<UserFlight> stuff = new ArrayList<>();

            while( rs.next() ) {
                String from = rs.getString("from");
                String to= rs.getString("to");
                String date = rs.getString("date");
                String seat = rs.getString("seat");
                stuff.add(new UserFlight(from,to,date,seat));
            }
            ObservableList<UserFlight> list = FXCollections.observableArrayList(stuff);
            fra.setCellValueFactory(new PropertyValueFactory<UserFlight,String>("from"));
            til.setCellValueFactory(new PropertyValueFactory<UserFlight,String>("to"));
            dagur.setCellValueFactory(new PropertyValueFactory<UserFlight,String>("date"));
            saeti.setCellValueFactory(new PropertyValueFactory<UserFlight,String>("seat"));
            myTable.setItems(list);
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