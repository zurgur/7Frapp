package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;


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


    public void leitaAction(ActionEvent actionEvent){

        String stuff = leita.getText();
        System.out.println(stuff);
        /*//String s = date.toString();
        String s = this.departur.getText();
        //String t = this.arival.getText();
        System.out.println(s);*/
    }
}
