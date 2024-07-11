
public class CarOwner {
	
	//instance variables
	private String name;
    private String address;

    // Default constructor
    public CarOwner() {
        this.name = "";
        this.address = "";
    }

    // Constructor with parameters
    public CarOwner(String name, String address) {
        this.name = name.toUpperCase();
        this.address = address;
    }

    // Getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    // Overriding the toString method to provide a formatted string representation of the owner details
    @Override
    public String toString() {
        String output = "  Name: " + this.name + "\n";
        output += "  Address: " + this.address + "\n";

        return output;
    }

}
