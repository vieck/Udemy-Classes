
public class Truck extends Car implements Drive,Weight{
	
	private float tonnage;
	
	public Truck(){
		finalMake = "Nissan";
		finalYear = 2011;
	}
	
	public void tonnage(){
		this.tonnage = 50000;
		System.out.printf("Tonnage: %.2f",tonnage);
	}
	
	public void speed(){
		finalSpeed = 125;
	}
	
	public void color(){
		finalColor = "blue";
	}
	
	public void model(){
		finalModel = "Titan";
	}

	public static void main(String[] args) {
		Car carExtension = new Truck();
		Truck truck = new Truck();
		
		carExtension.color();
		carExtension.model();
		carExtension.speed();
		carExtension.print(finalMake, finalModel, finalYear, finalColor, finalSpeed);
		truck.tonnage();

	}

}
