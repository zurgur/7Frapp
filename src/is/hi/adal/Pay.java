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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
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

    tengingVidGagnagrunnFyrirPay t = new tengingVidGagnagrunnFyrirPay();

    public void LoginAction(ActionEvent actionEvent) throws IOException {
        int paying = paydo();
        if(paying == 1)
        {
            insertPayingInfo();
            Parent root;
            Stage stage;
            stage = (Stage) pay.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("finish.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if(paying == 0)
        {
            System.out.println("vantar");
            errorMessage.setText("Please fill in all your information");
        }
    }

    public int paydo()
    {
        String firstname = firstName.getText();
        String lastname = lastName.getText();
        String sex = gender.getText();
        String ssn = birthday.getText();
        String country = nationality.getText();

        String [] newAccount = {firstname, lastname, sex, ssn, country};
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

    public void insertPayingInfo()
    {
        //user gera if lykkju
        String firstname = firstName.getText();
        String lastname = lastName.getText();
        String sex = gender.getText();
        String ssn = birthday.getText();
        String country = nationality.getText();


        //t.insertNewBooking(firstname, lastname, sex, ssn, country);
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
        //í vinnslu
        /*ArrayList<Flight> out = Search.found1;
        ArrayList<Flight> home = Search.found2;
        int iu =  FlightsControler.outIndex;
        int ih = FlightsControler.homeIndex;
        System.out.println(iu);
        Label lbl = new Label("from: " + out.get(iu).getFrom()+" to: "+out.get(iu).getDestinasion() +
                " date: " + out.get(iu).getDate() + " " + out.get(iu).getTime() + " cost: " + out.get(iu).getCost() + " seats: "+ out.get(iu).getSeats());

        thuertadkaupa.getItems().add(lbl);

        lbl = new Label("from: " + home.get(ih).getFrom()+" to: "+home.get(ih).getDestinasion() +
                " date: " + home.get(ih).getDate()+ " " + home.get(ih).getTime() + " cost: " + home.get(ih).getCost() + " seats: "+ home.get(ih).getSeats());
        thuertadkaupa.getItems().add(lbl);*/
    }
}
