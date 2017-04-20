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
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
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
    @FXML
    ToggleButton sortPrice;
    @FXML
    ToggleButton sortSeats;
    //inizalize array lista
    private ArrayList<Flight> out = new ArrayList<>();

    private ArrayList<Flight> home = new ArrayList<>();
    private Object outObject;
    private Object homeObject;
    private int outIndex;
    private int homeIndex;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // læt listana vilja stæka :)
        homeList.setExpanded(Boolean.TRUE);
        outList.setExpanded(Boolean.TRUE);
        //set inn á listana
        setLists();

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

    public void sortPriceAction(ActionEvent actionEvent) {
        if(sortPrice.isSelected() && !out.isEmpty()){
            Collections.sort(out, (o1, o2) -> {
                if(o1.getCost() == o2.getCost()){ return 0;}
                else if(o1.getCost()> o2.getCost()){return 10;}
                else return -10;
            });
        }
        if(sortPrice.isSelected() && !home.isEmpty()){
            Collections.sort(home, (o1, o2) -> {
                if(o1.getCost() == o2.getCost()){ return 0;}
                else if(o1.getCost()> o2.getCost()){return 10;}
                else return -10;
            });
            setLists();
        }
    }
    public void sortSeatsAction(ActionEvent actionEvent) {
        if(sortSeats.isSelected() && !out.isEmpty()){
            Collections.sort(out, (o1, o2) -> {
                if(o1.getSeats() == o2.getSeats()){ return 0;}
                else if(o1.getSeats()> o2.getSeats()){return -10;}
                else return 10;
            });
        }
        if(sortSeats.isSelected() && !home.isEmpty()){
            Collections.sort(home, (o1, o2) -> {
                if(o1.getSeats() == o2.getSeats()){ return 0;}
                else if(o1.getSeats()> o2.getSeats()){return -10;}
                else return 10;
            });
            setLists();
        }
    }
    public void setLists(){
        //lætt out og hom hafa rétt gögn :)
        out = Search.found1;
        home = Search.found2;
        outList.getItems().clear();
        homeList.getItems().clear();
        //fer í gegnum array listan og set í lista
        for(int i = 0; i<out.size();i++){
            try {
                Label lbl = new Label("from: " + out.get(i).getFrom()+" to: "+out.get(i).getDestinasion() +
                        " date: " + out.get(i).getDate() + " " + home.get(i).getTime() + " cost: " + out.get(i).getCost() + " seats: "+ out.get(i).getSeats());

                outList.getItems().add(lbl);
            }catch (Exception e){
                System.out.println("dem");
            }
        }
        //sama og fyrir ofan nema ég gái hvort það passi við
        if (Search.timi2Valin){
            for(int i = 0; i<home.size();i++){
                try {
                    Label lbl = new Label("from: " + home.get(i).getFrom()+" to: "+home.get(i).getDestinasion() +
                            " date: " + home.get(i).getDate()+ " " + home.get(i).getTime() + " cost: " + home.get(i).getCost() + " seats: "+ home.get(i).getSeats());
                    homeList.getItems().add(lbl);
                }catch (Exception e){
                    System.out.println("dem");
                }
            }
        }
    }


}
