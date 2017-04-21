package is.hi.adal;

/**
 * Created by Brynja Palina on 4/11/2017.
 */

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

//fuking magic
public class tengingVidGagnagrunnFyrirUser {

    public static Connection Connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:flight.sqlite");
            return conn;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    // adds new user to database
    public void insertNewUser(String username, String password, String name, String email, String phoneNumber) {
        String sql = "INSERT INTO User(username, password, name, email, phoneNumber) VALUES(?,?,?,?,?)";

        try (Connection conn = this.Connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, name);
            pstmt.setString(4, email);
            pstmt.setString(5, phoneNumber);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getMyFlights(ObservableList<MyFlights> data, TableView<MyFlights> table)
    {
        String sql = "SELECT * FROM Booking";

        try {
            Connection conn = this.Connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            Statement statement = conn.createStatement();
            statement.execute(sql);
            ResultSet rs;
            rs = pstmt.executeQuery();

            while(rs.next())
            {
                data.add(new MyFlights(
                        rs.getString("to"),
                        rs.getString("from"),
                        rs.getString("date"),
                        rs.getString("seat")
                ));
                table.setItems(data);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

   /* public <ArrayList> getFlightInfo()
    {
        String sql = "SELECT ";

        try (Connection conn = this.Connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, name);
            pstmt.setString(4, email);
            pstmt.setString(5, phoneNumber);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }*/
}