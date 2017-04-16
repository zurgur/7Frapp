package is.hi.adal;

import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Alexander on 4/16/2017.
 */
public class FlightsControler implements Initializable{
    @FXML
    Button Continue;
    @FXML
    JFXListView outList;
    @FXML
    JFXListView homeList;

    private ArrayList<String> out = new ArrayList<>();

    private ArrayList<String> home = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        out = Search.found1;
        home = Search.found2;
        for(int i = 0; i<out.size();i++){
            try {
                Label lbl = new Label(out.get(i)+i);
                outList.getItems().add(lbl);
                System.out.println(i);
            }catch (Exception e){
                System.out.println("dem");
            }
        }
        if (home.size()>0){
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

    }


    public void setOut(ArrayList<String> out) {
        this.out = out;
    }

    public void setHome(ArrayList<String> home) {
        this.home = home;
    }
}
