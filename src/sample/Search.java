package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import sample.tengingVidGagnagrunn.*;

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

    tengingVidGagnagrunn t = new tengingVidGagnagrunn();
    ArrayList<String> fra = t.getFrom();
    ArrayList<String> til = t.getTo();

    public void leitaAction(ActionEvent actionEvent){
        String departurText = departur.getText();
        String arivalText = arival.getText();
        String dateText = (date.getValue()).toString();
        ArrayList<String> tilEr = searchForFlight(departurText,arivalText,dateText);
        System.out.println(tilEr);

    }
    public ArrayList<String> searchForFlight(String departure, String arrival,String date){
        //prufa verður að hafa try og catch fyrir SQLite tengniguna
        // fer í gegn um arry-ana
        ArrayList<String> fraTil = new ArrayList<>();
        for(int i = 0; i<fra.size();i++){
            String s = fra.get(i);
            String t = til.get(i);
            if(s.equalsIgnoreCase(departure)&& t.equalsIgnoreCase(arrival)){
                fraTil.add(departure +" "+ arrival);
            }

        }
        return fraTil;
    }
}
