package restaurantRankingProgram;

public class menu  extends restaurant{
	private String menuName; //storing the menu name
	private String menuPrice; //storing the menu price
	private int star; //storing the star
	
	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public menu(String restaurantName, String menuName, String menuPrice) {
		super(restaurantName); //inheriting the superclass(restaurant)
		 setMenuName(menuName);
		 setMenuPrice(menuPrice);
	}
	
	public String getMenuName() {
		return menuName;
	}
	
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	public String getMenuPrice() {
		return menuPrice;
	}
	
	public void setMenuPrice(String menuPrice) {
		this.menuPrice = menuPrice;
	}
	
}
