package is.hi.adal;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
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
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.io.IOException;


/**
 * Created by Alexander on 4/11/2017.
 */
public class Login implements Initializable{
    //búa til FXML hluti svo við getum notað þá ur skjalinu
    @FXML
    private JFXTextField user;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXTextField errorMessage;

    @FXML
    private JFXButton login;

    @FXML
    private JFXButton signup;

    @FXML
    private JFXButton goback;

    @FXML
    private JFXCheckBox showPassword;

    @FXML
    private Label isConnected;

    Connection connection;
    //bæti við hér
    public static String username;
    //búinn að bæta við

    //If there is no connection to the database the system will shut down
    public Login ()
    {
        connection = tengingVidGagnagrunnFyrirUser.Connect();
        if(connection == null)
        {
            System.exit(1);
        }
    }
    //Checks if database is connected
    public boolean isDbConnected()
    {
        try
        {
            return !connection.isClosed();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    //Sets text about whether the database is connected or not
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        if(isDbConnected())
        {
            isConnected.setText("Connected");
        }
        else
        {
            isConnected.setText("Not Connected");
        }
    }

    //Checks if username and password written in textfile is in database
    public boolean isLogin(String user, String pass) throws SQLException
    {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM User WHERE username = ? AND password = ?";
        try
        {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);

            resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(Exception e)
        {
            return false;
        }

        finally
        {
            preparedStatement.close();
            resultSet.close();
        }
    }

    public void makeLogin(ActionEvent event) throws IOException
    {
        try {
            if(isLogin(user.getText(), password.getText()))
            {
                //Bætti við hér
                username = user.getText();
                //Búinn að bæta við
                Stage stage;
                FXMLLoader loader = new FXMLLoader();
                Pane root = loader.load(getClass().getResource("HomePage.fxml").openStream());
                stage = (Stage) login.getScene().getWindow();
                HomePage homepage = (HomePage)loader.getController();
                homepage.GetUser(user.getText());
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            else
            {
                errorMessage.setText("Username and/or password is incorrect");
            }
        } catch (SQLException e) {
            errorMessage.setText("Username and/or password is incorrect");
            e.printStackTrace();
        }
    }


    public void StartAction(ActionEvent actionEvent) throws IOException
    {
        Parent root;
        Stage stage;
        stage = (Stage) goback.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("start.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SignUpAction(ActionEvent actionEvent) throws IOException
    {
        Parent root;
        Stage stage;
        stage = (Stage) signup.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("newAccountGUI.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public String getUser()
    {
        String users;
        users = user.getText();
        return users;
    }


}
