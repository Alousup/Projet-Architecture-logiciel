package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ConnexionBase;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.PostModel;

public class PostController {

	//Add Post
	public void addPost(PostModel um) {
            try {
                ConnexionBase cb = new ConnexionBase();
                cb.connect();
                
                String req = "insert into posts(title, content) values('"+um.getTitle()+"', '"+um.getContent()+"');";
                
                
                cb.st.executeUpdate(req);
            } catch (SQLException ex) {
                Logger.getLogger(PostController.class.getName()).log(Level.SEVERE, null, ex);
            }
		
	}
	
	//Delete Post
	public void delPost(int id) {
		ConnexionBase cb = new ConnexionBase();
		cb.connect();
		
		String req = "delete from posts where id='"+id+"';";
		
		
            try {
                cb.st.executeUpdate(req);
            } catch (SQLException ex) {
                Logger.getLogger(PostController.class.getName()).log(Level.SEVERE, null, ex);
            }
		
	}
	
	//Update Post
	public void updatePost(PostModel um) {
		ConnexionBase cb = new ConnexionBase();
		cb.connect();
		
		String req = "update posts set title='"+um.getTitle()+"', content='"+um.getContent()+"' where id='"+um.getId()+"';";
		
		
            try {
                cb.st.executeUpdate(req);
            } catch (SQLException ex) {
                Logger.getLogger(PostController.class.getName()).log(Level.SEVERE, null, ex);
            }
		
	}
	
	//List post
	public ResultSet list(PostModel um) {
		ResultSet rs = null;
		
		ConnexionBase cb = new ConnexionBase();
		cb.connect();
		
		String req = "select * from posts ;";
		
		
            try {
                rs = cb.st.executeQuery(req);
                while(rs.next()==true){
                    String title= rs.getString("title");
                    String contenu =rs.getString("content");
                }
            } catch (SQLException ex) {
                Logger.getLogger(PostController.class.getName()).log(Level.SEVERE, null, ex);
            }
		
		
		return rs;
	}
	
	//Search by ID
			public PostModel searchId(int id) {
				PostModel um = new PostModel();
				
				ConnexionBase cb = new ConnexionBase();
				cb.connect();
				
				String req = "select * from posts where id='"+id+"';";
				
				
					
            try {
                ResultSet rs = cb.st.executeQuery(req);
                
                if(rs.next()) {
                    um.setId(rs.getInt("id"));
                    um.setTitle(rs.getString("title"));
                    um.setContent(rs.getString("content"));
		}else{
                    um = null;
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(PostController.class.getName()).log(Level.SEVERE, null, ex);
            }
					
				
				
				return um;
			}
}
