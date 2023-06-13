package appleProduct;

public class Product {
	private int basePrice; //for storing base price of product
	private float totalCost; //for storing total cost of product(s)
	private String model; //for storing model name
	private int quantity; //for storing number of product
	private float cost; //for storing a single cost of a product
	
	/*function for initializing product with base price*/
	public Product(int basePrice) {
		this.basePrice = basePrice;
	}
	
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}

	public int getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}
	
	
	public float getTotalCost() {
		return totalCost;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/*function for overriding other object class*/
	public void getUserSelection() {
		
	}
	/*function for calculating total cost with number of product*/
	public void calculateCost() {
		this.totalCost = this.cost * this.quantity;
	}
}
