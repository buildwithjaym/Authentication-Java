
package login_activity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class DB {
       private Connection conn;
       
    public DB() throws SQLException {
          try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/login_db";
            String user = "root"; 
            String password = ""; 
            this.conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
            this.conn = null;
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
            this.conn = null;
        }
    }

 
    public Connection getConnection() {
        return this.conn;
    }

    public void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

   

}
