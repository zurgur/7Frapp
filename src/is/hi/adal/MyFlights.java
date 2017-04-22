package is.hi.adal;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.ResourceBundle;

/**
 * Created by Brynja Palina on 4/11/2017.
 */
public class MyFlights{

    private SimpleStringProperty to;
    private SimpleStringProperty from;
    private SimpleStringProperty date;
    private SimpleStringProperty seat;

    public MyFlights(String dest, String home, String when, String sit)
    {
        this.to = new SimpleStringProperty(dest);
        this.from = new SimpleStringProperty(home);
        this.date = new SimpleStringProperty(when);
        this.seat = new SimpleStringProperty(sit);
    }

    public String getTo()
    {
        return to.get();
    }

    public String getFrom()
    {
        return from.get();
    }

    public String getDate()
    {
        return date.get();
    }

    public String getSeat()
    {
        return seat.get();
    }

    public void setTo(String dest)
    {
        to.set(dest);
    }

    public void setFrom(String home)
    {
        from.set(home);
    }

    public void setDate(String when)
    {
        date.set(when);
    }

    public void setSeat(String sit)
    {
        seat.set(sit);
    }

}