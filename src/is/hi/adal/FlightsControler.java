package is.hi.adal;

import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    //inizalize array lista
    private ArrayList<String> out = new ArrayList<>();

    private ArrayList<String> home = new ArrayList<>();

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
                System.out.println(i);
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
                    System.out.println(i);
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
}
