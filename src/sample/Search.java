package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

/**
 * Created by Alexander on 7.4.2017.
 */
public class Search {
    public Search (){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("search.fxml"));
        loader.setController(this);
        try{
            loader.load();
        }catch(Exception e){
            System.out.println(e.getMessage()+ "FXMLCreatePersonController failed");
        }
    }
    public void mySearchbtnA(ActionEvent actionEvent) {
        // String s = myDepartur.getText();
    }


}
