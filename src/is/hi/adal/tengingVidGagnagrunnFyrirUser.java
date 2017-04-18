package is.hi.adal;

/**
 * Created by Brynja Palina on 4/11/2017.
 */

import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //skilar array list með username
    public ArrayList<String> getUsername() {
        ArrayList<String> username = new ArrayList<>();

        try {
            Connection con = Connect();
            //tengist SQLite gagnagrunninum
            //gerir statement sem tekur allt úr töflunni
            Statement statement = con.createStatement();
            String s = "SELECT * " +
                    "FROM User"; //+

            //executar og finnur allt í töflunni
            statement.execute(s);
            //hlutur sem er með því sem kom út
            ResultSet rs = statement.getResultSet();
            //while sem fer í gegnum result gögnin
            while (rs.next()) {
                String name = rs.getString("username");
                username.add(name);
            }
            // lokar gagnagruninnum svo hann geti verið notaður aftur
            statement.close();
            con.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return username;
    }

    //skilar array list með password
    public ArrayList<String> getPassword() {
        ArrayList<String> password = new ArrayList<>();

        try {
            Connection con = Connect();
            //tengist SQLite gagnagrunninum
            //gerir statement sem tekur allt úr töflunni
            Statement statement = con.createStatement();
            String s = "SELECT * " +
                    "FROM User"; //+

            //executar og finnur allt í töflunni
            statement.execute(s);
            //hlutur sem er með því sem kom út
            ResultSet rs = statement.getResultSet();
            //while sem fer í gegnum result gögnin
            while (rs.next()) {
                String name = rs.getString("password");
                password.add(name);
            }
            // lokar gagnagruninnum svo hann geti verið notaður aftur
            statement.close();
            con.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return password;
    }
}