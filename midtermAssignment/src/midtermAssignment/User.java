package midtermAssignment;

public class User {
	private String name; //for storing user's name
	
	public User(String userName) { //constructor: setting user's name
		setName(userName);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}