package restaurantRankingProgram;

import java.util.ArrayList;

public class restaurant {
	private String restaurantName; //for storing the restaurant name
	private String price; //for storing the price range of restaurant
	private int distance; //for storing the distance from university to restaurant
	private String imagePath; //for storing the image of restaurant
	private ArrayList<menu> menuList; //for storing the menu of restaurant 
	private String onStore;
	
	public String getOnStore() {
		return onStore;
	}

	public void setOnStore(String onStore) {
		this.onStore = onStore;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public restaurant(String inputName) {
		setRestaurantName(inputName);
	}

	public restaurant(String inputName, String inputPrice, int distance) {
		setRestaurantName(inputName);
		setPrice(inputPrice);
		setDistance(distance);
		menuList = new ArrayList<menu>();
	}
	
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public ArrayList<menu> getMenuList() {
		return menuList;
	}
	
	public void addMenu(menu menu) {
		menuList.add(menu);
	}
	
}
