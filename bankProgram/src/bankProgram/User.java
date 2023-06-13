package bankProgram;

public class User {
	private String name;
	
	public User(String userName) {
		setName(userName);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
