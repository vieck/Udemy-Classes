
public class Dodge extends Car {
	
	public Dodge(){
		finalMake = "Dodge";
		finalYear = 2015;
	}
	
	public void speed(){
		finalSpeed = 210;
	}
	
	public void color(){
		finalColor = "red";
	}
	
	public void model(){
		finalModel = "Challenger";
	}
	
	public static void main(String[] args) {
		Car dodge = new Dodge();
		dodge.speed();
		dodge.color();
		dodge.model();
		dodge.print(finalMake, finalModel, finalYear, finalColor, finalSpeed);
	}

}
