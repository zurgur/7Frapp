package is.hi.adal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Alexander on 7.4.2017.
 */
public class Search {
    //búa til FXML hluti svo við getum notað þá ur fxml skjalinu
    @FXML
    Button leita;
    @FXML
    TextField departur;
    @FXML
    TextField arrival;
    @FXML
    DatePicker date;
    @FXML
    RadioButton morgun;
    @FXML
    RadioButton hadeigi;
    @FXML
    RadioButton kvöld;
    @FXML
    DatePicker date2;
    @FXML
    Button back;
    //tengjumst gagnagrunninum sem er sqlite
    tengingVidGagnagrunn t = new tengingVidGagnagrunn();
    //gerum Array lista fyrir gögninn í sql-inu
    ArrayList<String> fra = t.getFrom();
    ArrayList<String> til = t.getTo();
    ArrayList<String> data = t.getDate();
    ArrayList<String> time = t.getTime();
    //boolean sem gefa til kyna að dagsetning hefur verið valin
    Boolean timi1Valin = false;
    //geri public því ég nota þessar breytur í lista fallinu (ég veit það er ekki sniðugt)
    public  static Boolean timi2Valin = false;
    public static ArrayList<String> found1;
    public static ArrayList<String> found2;

    //fall þegar ýtt er á search
    public void leitaAction(ActionEvent actionEvent) throws IOException {
        //ef báðir tímar eru valdir þá vil notandi fara farm og til bakka annars bara eina leið
        if(timi1Valin && timi2Valin){
            backAndForth();
        } else if(timi1Valin){
            oneWay();
        }else {
            //kóði fyrir puopup sem byður notanda um að velja dag.
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("errorNoDate.fxml"));
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(leita.getScene().getWindow());
            stage.showAndWait();
        }

    }

    //fall fyrir one way flug :)
    private void oneWay() throws IOException {
        //nær í gögnn sem notandi hefur vaðið
        String departurText = departur.getText();
        String arivalText = arrival.getText();
        String dateText = (date.getValue()).toString();
        //setur viðeigandi gögn á réttan stað
        found1 = searchForFlight(departurText,arivalText,dateText);
        //staratar lista skráni
        startList();
    }
    //fall sem breitir yfir í glugga fyrir lista skrána
    private void startList() throws IOException {
        Parent root;
        Stage stage;
        stage = (Stage) leita.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Flights.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //fall flug framm og til baka sjá fall að ofan því þau eru næstum því eins :)
    private void backAndForth() throws IOException {
        String departurText = departur.getText();
        String arivalText = arrival.getText();
        String dateText = (date.getValue()).toString();
        String date2Text = (date2.getValue()).toString();
        found1 = searchForFlight(departurText, arivalText, dateText);
        found2 = searchForFlight(arivalText,departurText,date2Text);
        startList();
    }
    //events sem setja timi1Valin í true þegar það er ýtt á þau
    public void setTimi1Action(ActionEvent actionEvent){
        timi1Valin = true;
    }
    public void setTimi2Action(ActionEvent actionEvent){
        timi2Valin = true;
    }

    //fal sem skilar flugum sem passa við gögnin sem eru gefin
    public ArrayList<String> searchForFlight(String departure, String arrival,String date){
        //prufa verður að hafa try og catch fyrir SQLite tengniguna
        // fer í gegn um arry-ana
        ArrayList<String> fraTil = new ArrayList<>();
        for(int i = 0; i<fra.size();i++){
            String Str = time.get(0).substring(0,2);
            int tim = Integer.parseInt(Str);
            if (tim<=10 && morgun.isSelected() && (fra.get(i)).equalsIgnoreCase(departure)&&
                    (til.get(i)).equalsIgnoreCase(arrival) && (data.get(i)).equals(date)){
                fraTil.add(departure +" "+ arrival + " " + data.get(i) + " " + time.get(i));

            }else if(tim>=10 && tim<=17 && hadeigi.isSelected() && (fra.get(i)).equalsIgnoreCase(departure)&&
                    (til.get(i)).equalsIgnoreCase(arrival) && (data.get(i)).equals(date)){
                fraTil.add(departure +" "+ arrival + " " + data.get(i) + " " + time.get(i));

            }else if(tim>=17 && tim<=23 && kvöld.isSelected() && (fra.get(i)).equalsIgnoreCase(departure)&&
                    (til.get(i)).equalsIgnoreCase(arrival) && (data.get(i)).equals(date)){
                fraTil.add(departure +" "+ arrival + " " + data.get(i) + " " + time.get(i));

            }else if ((fra.get(i)).equalsIgnoreCase(departure)&& (til.get(i)).equalsIgnoreCase(arrival)
                    && (data.get(i)).equals(date)){
                fraTil.add(departure +" "+ arrival + " " + data.get(i) + " " + time.get(i));
            }
        }
        return fraTil;
    }

    public ArrayList<String> getFound1() {
        return found1;
    }

    public ArrayList<String> getFound2() {
        return found2;
    }

    //fall sem fer til baka á start skjáinn
    public void goBack(ActionEvent actionEvent) throws IOException {
        //setur tima1 og 2 í fals til þess að núll stilla
        timi1Valin = false;
        timi2Valin = false;
        Parent root;
        Stage stage;
        stage = (Stage) back.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("start.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
