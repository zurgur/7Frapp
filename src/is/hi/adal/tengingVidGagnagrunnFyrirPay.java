package is.hi.adal;

/**
 * Created by Brynja Palina on 4/11/2017.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//fuking magic
public class tengingVidGagnagrunnFyrirPay {

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
    public void insertNewBooking(String username, String firstname, String lastname, String gender, String ssn, String nationality, String from, String to, String date, String seat, String flightID) {

        String sql = "INSERT INTO User(username, firstname, lastname, gender, ssn, nationality, from, to, date) VALUES(?,?,?,?,?,?,?,?,?)";

        try (Connection conn = this.Connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, firstname);
            pstmt.setString(3, lastname);
            pstmt.setString(4, gender);
            pstmt.setString(5, ssn);
            pstmt.setString(6, nationality);
            pstmt.setString(7, from);
            pstmt.setString(8, to);
            pstmt.setString(9, date);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}