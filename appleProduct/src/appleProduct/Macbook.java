package appleProduct;

public class Macbook extends Product {
	private int memory; //for storing the memory storage of product
	private String color; //for storing the color of product
	private int size; //for storing the size of product
	
	public Macbook() {
		super(1000); //initializing with base price of Macbook
		
	}
	public int getMemory() {
		return memory;
	}
	
	public void setMemory(int memory) {
		this.memory = memory;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	/*function for printing user's option and updating the cost*/
	@Override
	public void getUserSelection() {
		float cost = this.getBasePrice(); //for storing base price of product at first
		
		if (this.getModel().equals("Pro")) {
			System.out.println("Model (MacbookPro) ----- +$200");
			cost += 200;
		}
		if (this.getSize() == 14) {
			System.out.println("Size (14 inch) ----- +$100");
			cost += 100;
		} else if (this.getSize() == 16){
			System.out.println("Size (16 inch) ----- +$200");
			cost += 200;
		}
		if (this.getColor().equals("Gold")) {
			System.out.println("Color (Gold) ----- +$20");
			cost += 20;
		} else if (this.getColor().equals("Silver")){
			System.out.println("Color (Silver) ----- +$10");
			cost += 10;
		}
		
		if (this.getMemory() == 256) {
			System.out.println("Memory (256) ----- +$100");
			cost += 100;
		} else if (this.getMemory() == 512){
			System.out.println("Memory (512) ----- +$300");
			cost += 300;
		}
		this.setCost(cost); //changing the calculated cost 
	}
}
