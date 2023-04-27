package CourseManager;

import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.Connection;
/*
 * The purpose of this class is to test your database connection, do not delete
 */
public class DBConnection {
    public static Connection con = null;

    public static void loadConnection(){
        String url = "jdbc:mysql://localhost:3306/course_manager";
        String root = "root";
        String pass = "MySQLr00tpass"; //change


        try{
            con = DriverManager.getConnection(url, root, pass);
            if(con != null){
                JOptionPane.showMessageDialog(null, "database has been successfully connected!");
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "error in database loading " + e);
        }
    }
}
