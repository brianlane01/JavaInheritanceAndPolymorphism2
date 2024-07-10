
public class SedanCar extends Car{

	private int numberOfDoors;
	
	private int trunkSize; 
	
	
	public SedanCar() {
		super();
		this.numberOfDoors = 0;
		this.trunkSize = 0; 
		
	}
	
	public SedanCar(String make, String model, int year, String vin, double price, CarOwner owner, int numberOfDoors, int trunkSize) {
		super(make, model, year, vin, price, owner);
		this.numberOfDoors = numberOfDoors;
		this.trunkSize = trunkSize; 
				
	}

	/**
	 * @return the numberOfDoors
	 */
	public int getNumberOfDoors() {
		return numberOfDoors;
	}

	/**
	 * @return the trunkSize
	 */
	public int getTrunkSize() {
		return trunkSize;
	}

	/**
	 * @param numberOfDoors the numberOfDoors to set
	 */
	public void setNumberOfDoors(int numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}

	/**
	 * @param trunkSize the trunkSize to set
	 */
	public void setTrunkSize(int trunkSize) {
		this.trunkSize = trunkSize;
	}

	/**
     * Override the toString method to provide a formatted string representation of the SedanCar object.
     * @return a string representation of the SedanCar object.
     */
    @Override
    public String toString() {
        String output = super.toString();
        output += "\nNumber of Doors: " + this.numberOfDoors;
        output += "\nTrunk Size: " + this.trunkSize + " cubic feet";
        output += "\n----------------------------------";

        return output;
    }
	
	
}
