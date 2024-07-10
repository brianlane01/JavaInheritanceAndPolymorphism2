
public class Car {
	
	//instance variables
	
	// Car make 
	private String make;
	
	// Car model
    private String model;
    
    // Year of manufacture
    private int year;
    
    // Price of the car
    private double price;
    
    // Owner of the car (CarOwner object)
    private CarOwner carOwner;

    // Default constructor
    public Car() {
        this.make = "";
        this.model = "";
        this.year = 0;
        this.price = 0.0;
        this.carOwner = null;
    }

    // Constructor with parameters to initialize the instance variables
    public Car(String make, String model, int year, double price, CarOwner owner) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.carOwner = owner;
    }

    // Getter and setter methods
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CarOwner getOwner() {
        return carOwner;
    }

    public void setOwner(CarOwner owner) {
        this.carOwner = owner;
    }
    
    // Overriding the toString method to provide a formatted string representation of the car details
    @Override
    public String toString() {
        String output = "----------------------------------\n";
        output += "Car Details:\n";
        output += "----------------------------------\n";
        output += "Make: " + this.make + "\n";
        output += "Model: " + this.model + "\n";
        output += "Year: " + this.year + "\n";
        output += "Price: $" + this.price + "\n";
        output += "Owner Information:\n" + this.carOwner;
        output += "\n----------------------------------";

        return output;
    }
}
