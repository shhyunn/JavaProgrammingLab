package appleProduct;

public class iPhone extends Product{
	private int memory; //for storing the memory storage of product
	private String color;//for storing the color of product
	public iPhone() {
		super(800);  //initializing with base price of iPhone
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
	/*function for printing user's option and updating the cost*/
	@Override
	public void getUserSelection() {
		float cost = this.getBasePrice();//for storing base price of product at first
		
		if (this.getModel().equals("iPhone13")) {
			System.out.println("Model (iPhone13) ----- +$200");
			cost += 200;
		}

		if (this.getColor().equals("Gold")) {
			System.out.println("Color (Gold) ----- +$20");
			cost += 20;
		} else if (this.getColor().equals("Silver")){
			System.out.println("Color (Silver) ----- +$10");
			cost += 10;
		}
		
		if (this.getMemory() == 128) {
			System.out.println("Memory (128) ----- +$100");
			cost += 100;
		} else if (this.getMemory() == 256) {
			System.out.println("Memory (256) ----- +$200");
			cost += 200;
		} else if (this.getMemory() == 512){
			System.out.println("Memory (512) ----- +$300");
			cost += 300;
		}
		
		this.setCost(cost); //changing the calculated cost
	}
}
