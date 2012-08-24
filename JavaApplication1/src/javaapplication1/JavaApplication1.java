/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.sql.*;
/**
 *
 * @author roodney
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            String url = "jdbc:derby://localhost:1527/sample";
            Connection con = DriverManager.getConnection(url, "app", "app");
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM CUSTOMER");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                System.out.println(rs.getString("NAME"));
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
