package appleProduct;

public class AirPods extends Product{

	public AirPods() {
		super(120); //initializing with base price of AirPods
	}
	/*function for printing user's option and updating the cost*/
	@Override
	public void getUserSelection() {
		float cost = this.getBasePrice(); //for storing base price of product at first
		
		if (this.getModel().equals("AirPodsPro")) {
			System.out.println("Model (AirPodsPro) ----- +$100");
			cost += 100;
		} else if (this.getModel().equals("AirPodsMax")){
			System.out.println("Model (AirPodsPMax) ----- +$200");
			cost += 200;
		}
		this.setCost(cost); //changing the calculated cost
	}	
}
