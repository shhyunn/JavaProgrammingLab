package restaurantRankingProgram;

public class student {
	private String studentID; //for storing the id
	private String nickName; //for storing the nick name
	private String studentPW; //for storing the pw
	private String freeInfo; //for storing the free info
	private String role; //for storing the role
	
	public student() {
		
	}

	public student(String inputID, String inputNick, String inputPW, String role) {
		//initialize the value of variables
		setStudentID(inputID);
		setNickName(inputNick);
		setStudentPW(inputPW);
		setRole(role);
	}
	
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getStudentPW() {
		return studentPW;
	}
	public void setStudentPW(String studentPW) {
		this.studentPW = studentPW;
	}
	public String getFreeInfo() {
		return freeInfo;
	}
	public void setFreeInfo(String freeInfo) {
		this.freeInfo = freeInfo;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
