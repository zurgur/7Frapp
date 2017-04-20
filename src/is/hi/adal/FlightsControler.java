package is.hi.adal;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Alexander on 4/16/2017.
 */
public class FlightsControler implements Initializable{
    //FXML til þess að tengjast því sem er á skjá
    @FXML
    Button Continue;
    @FXML
    JFXListView outList;
    @FXML
    JFXListView homeList;
    @FXML
    Button back;
    @FXML
    JFXButton signOut;
    //inizalize array lista
    private ArrayList<String> out = new ArrayList<>();

    private ArrayList<String> home = new ArrayList<>();
    private Object outObject;
    private Object homeObject;
    private int outIndex;
    private int homeIndex;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //lætt out og hom hafa rétt gögn :)
        out = Search.found1;
        home = Search.found2;
        //fer í gegnum array listan og set í lista
        for(int i = 0; i<out.size();i++){
            try {
                Label lbl = new Label(out.get(i)+i);
                outList.getItems().add(lbl);
            }catch (Exception e){
                System.out.println("dem");
            }
        }
        //sama og fyrir ofan nema ég gái hvort það passi við
        if (Search.timi2Valin){
            for(int i = 0; i<home.size();i++){
                try {
                    Label lbl = new Label(home.get(i));
                    homeList.getItems().add(lbl);
                }catch (Exception e){
                    System.out.println("dem");
                }
            }
        }
        // læt listana vilja stæka :)
        homeList.setExpanded(Boolean.TRUE);
        outList.setExpanded(Boolean.TRUE);

    }


    public void setOut(ArrayList<String> out) {
        this.out = out;
    }

    public void setHome(ArrayList<String> home) {
        this.home = home;
    }

    //fall fyrir til bakka takkan og fer til baka á search skjá
    public void BackAction(ActionEvent actionEvent) throws IOException {
        Parent root;
        Stage stage;
        stage = (Stage) back.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("search.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    //yfir í pay :)
    public void ContinueAction(ActionEvent actionEvent) throws IOException {
        outObject = outList.getSelectionModel().getSelectedItem();
        homeObject = homeList.getSelectionModel().getSelectedItem();
        outIndex = outList.getSelectionModel().getSelectedIndex();
        homeIndex = homeList.getSelectionModel().getSelectedIndex();
        //yfir í pay
        //sunna over end out :)
        Parent root;
        Stage stage;
        stage = (Stage) back.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("pay.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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

    public Object getOutObject() {
        return outObject;
    }

    public Object getHomeObject() {
        return homeObject;
    }

    public int getOutIndex() {
        return outIndex;
    }

    public int getHomeIndex() {
        return homeIndex;
    }
}
