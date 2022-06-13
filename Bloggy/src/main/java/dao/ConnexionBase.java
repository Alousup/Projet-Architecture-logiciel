package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnexionBase {
	
	Connection conn = null;
	public Statement st = null;
	
	public void connect() {
		
		
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnexionBase.class.getName()).log(Level.SEVERE, null, ex);
            }
		
		
		
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost/blogdatabase", "root", "");
            } catch (SQLException ex) {
                Logger.getLogger(ConnexionBase.class.getName()).log(Level.SEVERE, null, ex);
            }
		
		
		
            try {
                st = conn.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(ConnexionBase.class.getName()).log(Level.SEVERE, null, ex);
            }
		
		
	}
	
}
