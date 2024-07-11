
public class SportsCar extends Car{

	private int raceStat; 
	
	private int topSpeed;
	
	private double timeToSixty;
	
	private int handling; 
	
	private int weight;
	
	private int horsePower;
	
	private int traction; 
	
	private String transmission; 
	
	//This is the default constructor
	public SportsCar () {
		super();
		this.raceStat = 0;
		this.topSpeed = 0;
		this.handling = 0;
		this.weight = 0;
		this.horsePower = 0;
		this.traction = 0;
		this.timeToSixty = 0.0d;
		this.transmission = "";
	}
	
	/**
     * Constructor with parameters for SportsCar.
     * @param make the make of the sports car.
     * @param model the model of the sports car.
     * @param year the year of the sports car.
     * @param vin the VIN number of the sports car.
     * @param owner the owner of the sports car.
     * @param raceStat the race stats of the sports car.
     * @param topSpeed the top speed of the sports car.
     * @param acceleration the acceleration of the sports car.
     * @param handling the handling of the sports car.
     * @param traction 
     * @param horsePower
     * @param transmission 
     * @param weight
     * @param timeToSixty
     */
	public SportsCar (String make, String model, int year, String vin, double price, CarOwner owner, int raceStat, int topSpeed, double timeToSixty, int handling, int weight, int horsePower, int traction, String transmission) { 
		super(make, model, year, vin, price, owner);
		this.raceStat = raceStat;
		this.topSpeed = topSpeed;
		this.handling = handling;
		this.weight = weight;
		this.horsePower = horsePower;
		this.traction = traction;
		this.timeToSixty = timeToSixty;
		this.transmission = transmission;
		
	}

	/**
	 * @return the raceStat
	 */
	public int getRaceStat() {
		return raceStat;
	}

	/**
	 * @return the topSpeed
	 */
	public int getTopSpeed() {
		return topSpeed;
	}

	/**
	 * @return the timeToSixty
	 */
	public double getTimeToSixty() {
		return timeToSixty;
	}

	/**
	 * @return the handling
	 */
	public int getHandling() {
		return handling;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @return the horsePower
	 */
	public int getHorsePower() {
		return horsePower;
	}

	/**
	 * @return the traction
	 */
	public int getTraction() {
		return traction;
	}

	/**
	 * @return the transmission
	 */
	public String getTransmission() {
		return transmission;
	}

	/**
	 * @param raceStat the raceStat to set
	 */
	public void setRaceStat(int raceStat) {
		this.raceStat = raceStat;
	}

	/**
	 * @param topSpeed the topSpeed to set
	 */
	public void setTopSpeed(int topSpeed) {
		this.topSpeed = topSpeed;
	}

	/**
	 * @param timeToSixty the timeToSixty to set
	 */
	public void setTimeToSixty(double timeToSixty) {
		this.timeToSixty = timeToSixty;
	}

	/**
	 * @param handling the handling to set
	 */
	public void setHandling(int handling) {
		this.handling = handling;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @param horsePower the horsePower to set
	 */
	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}

	/**
	 * @param traction the traction to set
	 */
	public void setTraction(int traction) {
		this.traction = traction;
	}

	/**
	 * @param transmission the transmission to set
	 */
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	
	/**
     * Override the toString method to provide a formatted string representation of the SportsCar object.
     * @return a string representation of the SportsCar object.
     */
    @Override
    public String toString() {
        String output = super.toString();
        output += "\nSports Stats for the " + super.getMake();
        output += "\n----------------------------------";
        output += "\nRace Stats: " + this.raceStat;
        output += "\nTop Speed: " + this.topSpeed + " mph";
        output += "\nAcceleration: " + this.timeToSixty + " 0-60 mph seconds";
        output += "\nHandling: " + this.handling + " score";
        output += "\nTraction: " + this.traction + " score";
        output += "\nHorsePower: " + this.horsePower + " HP";
        output += "\nWeight: " + this.weight + " pounds";
        output += "\nTransmission: " + this.transmission;
        output += "\n----------------------------------";
        
        return output;
    }
	
}
