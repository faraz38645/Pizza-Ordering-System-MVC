/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CheckLogin {

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String connectURL = "jdbc:sqlserver://localhost:1433;instance=DESKTOP-R1FN2EL;databaseName=PizzaDB";
            java.sql.Connection con = DriverManager.getConnection(connectURL, "sa", "1234");
            return con;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CheckLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public int log(String username, String password) {

        try {

            Connection con = getConnection();
            String qu = "select * from EMPLOYEE where EMP_NAME = ? and EMP_PASS= ?";
            PreparedStatement pst = con.prepareStatement(qu, Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            int id = 0;
            while (rs.next()) {
                id = Integer.parseInt(rs.getString(1));
            }
            return id;

        } catch (Exception e) {
            return 0;
        }
    }
}
