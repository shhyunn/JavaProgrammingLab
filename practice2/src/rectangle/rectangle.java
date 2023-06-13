package rectangle;

public class rectangle {
	private double width;
	private double height;

	public rectangle() {
		this.width = 1;
		this.height = 1;
	}

	public rectangle(double width, double height) {
		setHeight(height);
		setWidth(width);
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public void setHeight(double height) {
		if (height >= 0) {
			this.height = height;
		}
		else {
			System.err.println("You cannot assign negative number.");
		}
		
	}
	@Override
	//toString은 println(), printf(), loggers, assert문, IDE의 디버거, collections의 출력과정 등 다양한 자바 API들에 의해 호출된다.
	public String toString() {
		String info = "width:" + this.width + "\n" + "height:" + this.height + "\n";
		return info;
	}
	
	public double area() {
		double rectangleArea = this.height * this.width;
		return rectangleArea;
	}
	
	public double perimeter() {
		double rectanglePerimeter = 2 * (this.height + this.width);
		return rectanglePerimeter;
	}
	
	public void printMenu() {
		System.out.println("1.Set Length \n 2.Set Width \n 3. Exit");
	}
}
