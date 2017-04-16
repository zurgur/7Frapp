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
    //búa til FXML hluti svo við getum notað þá ur skjalinu
    @FXML
    Button leita;
    @FXML
    TextField departur;
    @FXML
    TextField arival;
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

    tengingVidGagnagrunn t = new tengingVidGagnagrunn();
    ArrayList<String> fra = t.getFrom();
    ArrayList<String> til = t.getTo();
    ArrayList<String> data = t.getDate();
    ArrayList<String> time = t.getTime();
    Boolean timi1Valin = false;
    Boolean timi2Valin = false;
    public static ArrayList<String> found1;
    public static ArrayList<String> found2;

    public void leitaAction(ActionEvent actionEvent) throws IOException {
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

    private void oneWay() throws IOException {
        String departurText = departur.getText();
        String arivalText = arival.getText();
        String dateText = (date.getValue()).toString();
        found1 = searchForFlight(departurText,arivalText,dateText);

        System.out.println("one way flug:");
        System.out.println(found1);
        startList();
    }

    private void startList() throws IOException {
        Parent root;
        Stage stage;
        stage = (Stage) leita.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Flights.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    private void backAndForth() throws IOException {
        String departurText = departur.getText();
        String arivalText = arival.getText();
        String dateText = (date.getValue()).toString();
        String date2Text = (date2.getValue()).toString();
        System.out.println("flug útt");
        found1 = searchForFlight(departurText, arivalText, dateText);
        System.out.println(found1);
        System.out.println("flug heim:");
        found2 = searchForFlight(arivalText,departurText,date2Text);
        System.out.println(found2);
        startList();
    }

    public void setTimi1Action(ActionEvent actionEvent){
        timi1Valin = true;
    }
    public void setTimi2Action(ActionEvent actionEvent){
        timi2Valin = true;
    }

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
}
