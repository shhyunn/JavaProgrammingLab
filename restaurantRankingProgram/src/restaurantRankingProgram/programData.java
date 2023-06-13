package restaurantRankingProgram;

import java.util.ArrayList;

public class programData {
	 private static programData instance; //for storing the total object of program data
	 private ArrayList<student> studentList; //for storing the student list
	 private ArrayList<restaurant> restaurantList; //for storing the restaurant list
	 private student userStudent; //for storing the login user object
	 
	 private programData() {
		 //initializing the list objects
		 studentList = new ArrayList<>();
		 restaurantList = new ArrayList<>();
	 }
	 
	 public static programData getInstance() {
		 if (instance == null) { //cases for empty instance
			 instance = new programData(); //creating the new data object
	     }
	     return instance;
	 }
	 
	 public ArrayList<student> getStudentList() {
	     return studentList;
	 }

	 public void addStudent(student student) {
		 studentList.add(student);
	 }
	 
	 public ArrayList<restaurant> getRestaurantList() {
		 return restaurantList;
	 }
	 
	 public void addRestaurant(restaurant restaurant) {
		 restaurantList.add(restaurant);
	 }
	 
	 public void setUserStudent(student user) {
		 this.userStudent = user;
	 }
	 
	 public student getUserStudent() {
		 return this.userStudent;
	 }
}