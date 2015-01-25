
public abstract class VanElements {
	private String make = "";
	private String model = "";
	private String color = "";
	private int speed = 0;
	private int year = 0;
	private boolean fullyLoaded = false;
	
	public String getMake(){
		return make;
	}
	
	public void setMake(String make){
		this.make = make;
	}
	
	public void setModel(String model){
		this.model = model;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	public void setSpeed(int speed){
		this.speed = speed;
	}
	
	public void setYear(int year){
		this.year = year;
	}
	
	public void setPackage(boolean fullyLoaded){
		this.fullyLoaded = fullyLoaded;
	}
	
	public void print(){
		System.out.printf("Make: %s\n"
				+ "Model: %s\n"
				+ "Color: %s\n"
				+ "Speed: %d mph\n"
				+ "Year: %d\n"
				+ "Fully Loaded: %B\n",
				make,model,color,speed,year,fullyLoaded);
	}
	
	
}
