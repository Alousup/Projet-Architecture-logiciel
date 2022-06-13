package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ConnexionBase;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.UserModel;

public class UserController {

	//Add User
		public void addUser(UserModel um) {
			ConnexionBase cb = new ConnexionBase();
			cb.connect();
			
			String req = "insert into user(firstName, lastName, login, password) values('"+um.getFirstName()+"', '"+um.getLastName()+"', '"+um.getLogin()+"', '"+um.getPassword()+"');";
			
			
				boolean t = verifLogin(um.getLogin());
                    try {
                        cb.st.executeUpdate(req);
                    } catch (SQLException ex) {
                        Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                    }
			
		}
		
		//Delete User
		public void delUser(int id) {
			ConnexionBase cb = new ConnexionBase();
			cb.connect();
			
			String req = "delete from user where id='"+id+"';";
			
			
                    try {
                        cb.st.executeUpdate(req);
                    } catch (SQLException ex) {
                        Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                    }
			
		}
		
		//Update User
		public void updateUser(UserModel um) {
			ConnexionBase cb = new ConnexionBase();
			cb.connect();
			
			String req = "update user set firstName='"+um.getFirstName()+"', lastName='"+um.getLastName()+"', login='"+um.getLogin()+"', password='1';";
			
			
                    try {
                        cb.st.executeUpdate(req);
                    } catch (SQLException ex) {
                        Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                    }
			
		}
		
		//Search by ID
		public UserModel searchId(int id) {
			UserModel um = new UserModel();
			
			ConnexionBase cb = new ConnexionBase();
			cb.connect();
			
			String req = "select * from user where id='1';";
			
			try {
				ResultSet rs = cb.st.executeQuery(req);
				if(rs.next()) {
					um.setId(rs.getInt("id"));
					um.setLogin(rs.getString("login"));
					um.setFirstName(rs.getString("firstName"));
					um.setLastName(rs.getString("lastName"));
					um.setPassword(rs.getString("password"));
				}else{
					um = null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return um;
		}
		
		//List Users
		public ResultSet list() {
			ResultSet rs = null;
			
			ConnexionBase cb = new ConnexionBase();
			cb.connect();
			
			String req = "select * from user;";
			
			try {
				rs = cb.st.executeQuery(req);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return rs;
		}
		
		//Test login
		public boolean testLogin(String log, String pass) {
			boolean val = false;
			
			ConnexionBase cb = new ConnexionBase();
			cb.connect();
			
			String req = "select * from user where login='"+log+"' and password='"+pass+"';";
			
			try {
				ResultSet rs = cb.st.executeQuery(req);
				while(rs.next()) {
					val = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return val;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		public boolean verifLogin(String log) {
			boolean x = false;
			
			ConnexionBase cb = new ConnexionBase();
			cb.connect();
			
			String req = "select login from utilisateur where login='"+log+"';";
			try {
				ResultSet res = cb.st.executeQuery(req);
				if(res.next()) {
					x=true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return x;
		}

   
}
