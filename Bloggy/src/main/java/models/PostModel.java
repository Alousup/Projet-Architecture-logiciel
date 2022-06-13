package models;

public class PostModel {
	
	private int id, user_id;
	private String title, content, category;
	
	public PostModel(int user_id, String title, String content, String category) {
		super();
		this.user_id = user_id;
		this.title = title;
		this.content = content;
		this.category = category;
	}
	
	public PostModel() {
		super();
	}

	public PostModel(int id,String title, String content) {
		super();
		this.id=id;
		this.title = title;
		this.content = content;
		
	}
        
        public PostModel(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	

	
	
}
