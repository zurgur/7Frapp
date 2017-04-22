package is.hi.adal;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static javafx.application.Application.launch;

/**
 * Created by Sunna on 14.4.2017.
 */
public class Pay implements Initializable{

    @FXML
    private JFXButton pay;
    @FXML
    private JFXTextField firstName;
    @FXML
    private JFXTextField lastName;
    @FXML
    private JFXTextField gender;
    @FXML
    private JFXTextField birthday;
    @FXML
    private JFXTextField nationality;
    @FXML
    private JFXTextField cardholder;
    @FXML
    private JFXTextField cardNumber;
    @FXML
    private JFXTextField cvc;
    @FXML
    private JFXButton goBack;
    @FXML
    private JFXTextField errorMessage;
    @FXML
    private JFXButton signOut;
    @FXML
    private JFXListView thuertadkaupa;
    @FXML
    private Label userName;

    tengingVidGagnagrunnFyrirPay t = new tengingVidGagnagrunnFyrirPay();
    Connection con = t.Connect();

    public void LoginAction(ActionEvent actionEvent) throws IOException {
        //int paying = paydo();
        //if(paying == 1)
        //{
            try {
                insertPayingInfo();
            } catch (SQLException e) {
                e.printStackTrace();
            }/*
            Parent root;
            Stage stage;
            stage = (Stage) pay.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("finish.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();*/
        //}
        //else if(paying == 0)
        //{
          //  System.out.println("vantar");
            //errorMessage.setText("Please fill in all your information");
        //}
    }

    public int paydo()
    {
        String firstname = firstName.getText();
        String lastname = lastName.getText();
        String sex = gender.getText();
        String ssn = birthday.getText();
        String country = nationality.getText();
        String name = cardholder.getText();
        String numbers = cardNumber.getText();
        String backcard = cvc.getText();

        String [] newAccount = {firstname, lastname, sex, ssn, country, name, numbers, backcard};
        int count = 0;
        int caseR = 0;
        for(int i=0; i<newAccount.length; i++)
        {
            System.out.println("forlykkja");
            if(newAccount[i].length() != 0)
            {
                count += 1;
                System.out.println("lúppa"+i);
            }
            else System.out.println("ekkert");
        }
        System.out.println("count: " + count);

        if(count == 6)
        {
            caseR = 1;
            System.out.println("tilfelli 1");
        }
        else if(count < 6)
        {
            caseR = 0;
            System.out.println("tilfelli 0");
        }
        return caseR;
    }

    public void insertPayingInfo() throws SQLException {
        //user gera if lykkju
        String firstname = firstName.getText();
        String lastname = lastName.getText();
        String sex = gender.getText();
        String ssn = birthday.getText();
        String country = nationality.getText();
        // vantar að kalla á flugin sem valin voru
        Flight from = Search.found1.get(FlightsControler.outIndex);
        Flight to = Search.found2.get(FlightsControler.homeIndex);
        // er að fara viltaust í töfluna, þarf að setja uster fyrst og svo þetta dót og svo flugin eftir það
        //  ER BARA COMMENTAÐ ÚT ÞVÍ ANNARS RNNAR VERKEFNIÐ EKKI

       // t.insertNewBooking(firstname, lastname, sex, ssn, country);

        String t1 = "INSERT INTO Booking " +
                "VALUES ( '" + userName.getText() +"','"+firstname+"','"+lastname+"','"+sex+"','"+ssn+"','"+country+"'," +
                "'"+from.getFrom()+"','"+from.getDestinasion()+"','"+from.getDate()+"');";
        Statement statement = con.createStatement();
        statement.execute(t1);

        String t2 = "INSERT INTO Booking" +
                " VALUES ('" + userName.getText() +"','"+firstname+"','"+lastname+"','"+sex+"','"+ssn+"','"+country+"'," +
                "'"+to.getFrom()+"','"+to.getDestinasion()+"','"+to.getDate()+"');";
        statement = con.createStatement();
        statement.execute(t2);

    }

    public void FlightsAction(ActionEvent actionEvent) throws IOException
    {
        Parent root;
        Stage stage;
        stage = (Stage) goBack.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("flights.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SignOut(ActionEvent event)
    {
        Login.username = null;
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

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(Login.username != null && !Login.username.isEmpty()){
            userName.setText(Login.username);
        }
        //í vinnslu
        ArrayList<Flight> out = Search.found1;
        ArrayList<Flight> home = Search.found2;
        int iu =  FlightsControler.outIndex;
        int ih = FlightsControler.homeIndex;
        if(iu>=0) {
            Label lbl = new Label("from: " + out.get(iu).getFrom() + " to: " + out.get(iu).getDestinasion() +
                    " date: " + out.get(iu).getDate() + " " + out.get(iu).getTime() + " cost: " + out.get(iu).getCost() + " seats: " + out.get(iu).getSeats());

            thuertadkaupa.getItems().add(lbl);
        }
        if(ih>=0) {
            Label lbl = new Label("from: " + home.get(ih).getFrom() + " to: " + home.get(ih).getDestinasion() +
                    " date: " + home.get(ih).getDate() + " " + home.get(ih).getTime() + " cost: " + home.get(ih).getCost() + " seats: " + home.get(ih).getSeats());
            thuertadkaupa.getItems().add(lbl);
        }
    }
}
