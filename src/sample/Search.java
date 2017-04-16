package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

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

    public void leitaAction(ActionEvent actionEvent){
        if(timi1Valin && timi2Valin){
            backAndForth();
        } else if(timi1Valin){
            oneWay();
        }

    }

    private void oneWay() {
        String departurText = departur.getText();
        String arivalText = arival.getText();
        String dateText = (date.getValue()).toString();
        ArrayList<String> tilEr = searchForFlight(departurText,arivalText,dateText);
        System.out.println("one way flug:");
        System.out.println(tilEr);
    }

    private void backAndForth() {
        String departurText = departur.getText();
        String arivalText = arival.getText();
        String dateText = (date.getValue()).toString();
        String date2Text = (date2.getValue()).toString();
        System.out.println("flug útt");
        ArrayList<String> utt = searchForFlight(departurText, arivalText, dateText);
        System.out.println(utt);
        System.out.println("flug heim:");
        ArrayList<String> heim = searchForFlight(arivalText,departurText,date2Text);
        System.out.println(heim);
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

}
