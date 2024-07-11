/*
 *  Problem 2
 *  Description: .
 *  @Author: Brian Lane
 *  @Date: July 5, 2024
 */

import java.util.ArrayList;
import java.util.Scanner;

public class UseCar {
    public static void main(String[] args) {
    	
    	MyCarSystem s1 = new MyCarSystem();
    	s1.start();
      
    }
}

class MyCarSystem {
	// create an arraylist and make it global
	ArrayList<Car> cars = new ArrayList<Car>();
	
	// Create an ArrayList to store CarOwner objects and make it a global variable
    ArrayList<CarOwner> owners = new ArrayList<CarOwner>();
	
	//simulating the main method
	public void start() {
		
		boolean finished = false;
		int userChoice = 0;
		
		//This will create some pre-seeded car owners
        CarOwner owner1 = new CarOwner("BRUCE WAYNE", "123 Gotham Lane");
        CarOwner owner2 = new CarOwner("Clark Kent", "456 Smallville Avenue");
        CarOwner owner3 = new CarOwner("Oliver Queen", "789 Star Road");
        CarOwner owner4 = new CarOwner("Tony Stark", "10880 Malibu Point");
        CarOwner owner5 = new CarOwner("Peter Parker", "20 Ingram Street");
        CarOwner owner6 = new CarOwner("Rachel Roth", "1600 Azarath Avenue");
        
        owners.add(owner1);
        owners.add(owner2);
        owners.add(owner3);
        owners.add(owner4);
        owners.add(owner5);
        owners.add(owner6);
        
        //this will create some pre-seeded cars with the appropriate owner
        SportsCar car1 = new SportsCar("Lamborghini", "Aventador S", 2021, "ZHWUR1ZDXMLA02984", 421000.0d, owner1, 95, 217, 2.9, 92, 3472, 730, 90, "7-speed Automated Manual");
        Car car2 = new Car("Ford", "F-150 Rapto", 2024, "1FTFW1RG1MFB56743", 65000.99d, owner2);
        Car car3 = new Car("Aston Martin", "DB11", 2025, "SCFRMFAV4MGL05021", 205600.78d, owner3);
        SedanCar car4 = new SedanCar("Tesla", "Model S", 2025, "5YJSA1E48MF123456", 135000.00d, owner4, 4, 28);
        SedanCar car5 = new SedanCar("Honda", "Accord", 2024, "1HGCV2F34MA123456", 35000.00d, owner5, 4, 17);
        SportsCar car6 = new SportsCar("Bugatti", "Chiron", 2024, "VF9SK252XKM795001", 3000000.00d, owner1, 95, 261, 2.4, 92, 4400, 1479, 90, "7-speed dual-clutch automatic");
        SportsCar car7 = new SportsCar("Ford", "Mustang Shelby GT500", 2024, "1FA6P8JZ1M5501234", 85000.00d, owner6, 95, 180, 3.3, 92, 4171, 760, 90, "7-speed dual-clutch automatic");
        
        //this will add the cars with their owners to the ArrayList 
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);
        cars.add(car7);
		
        Scanner scanner = new Scanner(System.in); 
        
        System.out.println(" Welcome to the Car Management System");
        while (finished == false) {
        	
            // Display a menu for the user to select from 
        	System.out.println("");
			System.out.println("            Car Mangement Menu             ");
			System.out.println("");
			System.out.println("|=========================================|");
			System.out.println("|                                         |");
			System.out.println("|    Please Make a Selection (1-4):       |");
			System.out.println("|                                         |");
			System.out.println("| 1. Create Car                           |");
			System.out.println("| 2. Create New Owner                     |");
			System.out.println("| 3. Lookup Car By VIN                    |");
			System.out.println("| 4. Lookup Car By Owner                  |");
			System.out.println("| 5. Lookup Cars By Make                  |");
			System.out.println("| 6. Display All Cars                     |");
			System.out.println("| 7. Display All Owners                   |");
			System.out.println("| 8. Exit                                 |");
			System.out.println("|                                         |");
			System.out.println("|=========================================|");
			System.out.println("");
			
			// Loop until a valid choice is entered
			// the loop will handle if the user was to enter anything other than a integer such as b/, so that it does not break the program and cause you to start over
			boolean validChoice = false;
						
			while (!validChoice) {
				String userInput = scanner.nextLine();
				if (userInput.matches("[1-8]")) {
					userChoice = Integer.parseInt(userInput);
					validChoice = true;
				} 
				else {
					System.out.println("Invalid Input. Please enter a number between 1 and 6.");
				}
			}
            
            switch (userChoice) {
            	case 1:
            		createNewCarMenu();
            		break;
            	case 2: 
            		CarOwner cw = createOwner();
            		if (cw != null) {
						owners.add(cw);
						System.out.println("New owner created successfully.");
					}
					pressAnyKey();
	                break; 
            	case 3: 
            		vinNumberToSearchFor();
            		pressAnyKey();
            		break;
            	case 4:
            		nameOfOwnerForCarLookUp();
            		pressAnyKey();
            		break;
            	case 5: 
            		makeOfCarToLookFor();
            		pressAnyKey();
            		break;
            	case 6: 
            		displayCars();
            		pressAnyKey(); 
            		break;
            	case 7: 
            		displayOwners();
            		pressAnyKey();
            		break;
            	case 8: 
            		System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);  // Exit the program
                    break;
            	default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
		
	}
	
	/**
     * Description: This is a method to create a new car owner by taking input from the user.
     * @return a CarOwner object with the inputed name and address.
     */
	public CarOwner createOwner() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the name of the owner: ");
		String name = sc.nextLine().toUpperCase();
		
		System.out.println("Enter the address of the owner: ");
		String address = sc.nextLine();
		
		CarOwner cw = new CarOwner (name, address);
		return cw;
		
	}
	
	/**
     * Description: This is a method to create a new car by taking input from the user.
     * @param owner the owner of the car.
     * @return a Car object with the inputed details and the provided owner.
     */
	public Car createCar(CarOwner owner) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the make of the car: ");
        String make = sc.nextLine().toUpperCase();

        System.out.println("Enter the model of the car: ");
        String model = sc.nextLine();

        System.out.println("Enter the year of the car: ");
        int year = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Enter the VIN for the car");
        String vin = sc.nextLine().toUpperCase();

        System.out.println("Enter the price of the car: ");
        double price = sc.nextDouble();

        Car car = new Car(make, model, year, vin, price, owner);
        return car;
    }
	
	public Car createCarOwnerExists() {
		
		 Scanner sc = new Scanner(System.in);  // Create a Scanner object for input

	     System.out.println("Enter the make of the car: ");
	     String make = sc.nextLine().toUpperCase();  // Read the car's make

	     System.out.println("Enter the model of the car: ");
	     String model = sc.nextLine();  // Read the car's model

	     System.out.println("Enter the year of the car: ");
	     int year = sc.nextInt();  // Read the car's year
	     sc.nextLine();  // Consume the newline character

	     System.out.println("Enter the VIN for the car: ");
	     String vin = sc.nextLine().toUpperCase();  // Read the car's VIN number

	     System.out.println("Select the owner of the car from the list below:");
	     
	     for (int i = 0; i < owners.size(); i++) {
	          System.out.println(i + 1 + ". " + owners.get(i).getName());
	     }
	     
	     int ownerIndex = sc.nextInt() - 1;  // Read the owner's index from the list
	     CarOwner owner = owners.get(ownerIndex);  // Get the selected owner

	     System.out.println("Enter the price of the car: ");
	     double price = sc.nextDouble();  // Read the car's price

	     Car car = new Car(make, model, year, vin, price, owner);  // Create a new Car object with the input
	     
	     return car;  // Return the Car object
	}

	public SedanCar createSedanCar(CarOwner owner) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the make of the car: ");
		String make = sc.nextLine().toUpperCase();
		
		System.out.println("Enter the model of the car: ");
		String model = sc.nextLine();
		
		System.out.println("Enter the year of the car: ");
		int year = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the VIN for the car");
		String vin = sc.nextLine().toUpperCase();
		
		System.out.println("Enter the price of the car: ");
		double price = sc.nextDouble();
		
		System.out.println("Enter the number of doors the car has: ");
		int numberOfDoors = sc.nextInt();
		
		System.out.println("Enter the trunk size of the car in cubic feet: ");
		int trunkSize = sc.nextInt();
		
		SedanCar car = new SedanCar(make, model, year, vin, price, owner, numberOfDoors, trunkSize);
		return car;
	}
	
	public SedanCar createSedanCarOwnerExists() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Select the owner of the car from the list below:");
	     
	    for (int i = 0; i < owners.size(); i++) {
	          System.out.println(i + 1 + ". " + owners.get(i).getName());
	     }
	     
	    int ownerIndex = sc.nextInt() - 1;  // Read the owner's index from the list
	    CarOwner owner = owners.get(ownerIndex);  // Get the selected owner
	    sc.nextLine();
		
		System.out.println("Enter the make of the car: ");
		String make = sc.nextLine().toUpperCase();
		
		System.out.println("Enter the model of the car: ");
		String model = sc.nextLine();
		
		System.out.println("Enter the year of the car: ");
		int year = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the VIN for the car");
		String vin = sc.nextLine().toUpperCase();
		
		System.out.println("Enter the price of the car: ");
		double price = sc.nextDouble();
		
		System.out.println("Enter the number of doors the car has: ");
		int numberOfDoors = sc.nextInt();
		
		System.out.println("Enter the trunk size of the car in cubic feet: ");
		int trunkSize = sc.nextInt();
		
		SedanCar car = new SedanCar(make, model, year, vin, price, owner, numberOfDoors, trunkSize);
		return car;
	}
	
	public SportsCar createSportsCar(CarOwner owner) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the make of the car: ");
		String make = sc.nextLine().toUpperCase();
		
		System.out.println("Enter the model of the car: ");
		String model = sc.nextLine();
		
		System.out.println("Enter the year of the car: ");
		int year = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the VIN for the car");
		String vin = sc.nextLine().toUpperCase();
		
		System.out.println("Enter the price of the car: ");
		double price = sc.nextDouble();
		
		System.out.println("Enter the overall race stat of the car: ");
		int raceStat = sc.nextInt();
		
		System.out.println("Enter the top speed of the car in MPH: ");
		int topSpeed = sc.nextInt();
		
		System.out.println("Enter the time it takes the car to go from 0-60: ");
		double timeToSixty = sc.nextDouble();
		
		System.out.println("Enter the handling rating of the car: ");
		int handling = sc.nextInt();
		
		System.out.println("Enter the weight of the car pounds: ");
		int weight = sc.nextInt();
		
		System.out.println("Enter the HorsePower of the car: ");
		int horsePower = sc.nextInt();
		
		System.out.println("Enter the tranction rating of the car: ");
		int traction = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the type of transmission the car has: ");
		String transmission = sc.nextLine();
		
		SportsCar car = new SportsCar(make, model, year, vin, price, owner, raceStat, topSpeed, timeToSixty, handling, weight, horsePower, traction, transmission);
		return car;
	}
	
	public SportsCar createSportsCarOwnerExists() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Select the owner of the car from the list below:");
	     
	    for (int i = 0; i < owners.size(); i++) {
	          System.out.println(i + 1 + ". " + owners.get(i).getName());
	     }
	     
	    int ownerIndex = sc.nextInt() - 1;  // Read the owner's index from the list
	    CarOwner owner = owners.get(ownerIndex);  // Get the selected owner
	    sc.nextLine();
		
		System.out.println("Enter the make of the car: ");
		String make = sc.nextLine().toUpperCase();
		
		System.out.println("Enter the model of the car: ");
		String model = sc.nextLine();
		
		System.out.println("Enter the year of the car: ");
		int year = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the VIN for the car");
		String vin = sc.nextLine().toUpperCase();
		
		System.out.println("Enter the price of the car: ");
		double price = sc.nextDouble();
		
		System.out.println("Enter the overall race stat of the car: ");
		int raceStat = sc.nextInt();
		
		System.out.println("Enter the top speed of the car in MPH: ");
		int topSpeed = sc.nextInt();
		
		System.out.println("Enter the time it takes the car to go from 0-60: ");
		double timeToSixty = sc.nextDouble();
		
		System.out.println("Enter the handling rating of the car: ");
		int handling = sc.nextInt();
		
		System.out.println("Enter the weight of the car pounds: ");
		int weight = sc.nextInt();
		
		System.out.println("Enter the HorsePower of the car: ");
		int horsePower = sc.nextInt();
		
		System.out.println("Enter the tranction rating of the car: ");
		int traction = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the type of transmission the car has: ");
		String transmission = sc.nextLine();
		
		SportsCar car = new SportsCar(make, model, year, vin, price, owner, raceStat, topSpeed, timeToSixty, handling, weight, horsePower, traction, transmission);
		return car;
	}
	
	 /**
     * Description: this method is used to display the details of all cars in the system.
     */
	public void displayCars() {
		System.out.println("\nDisplaying All Cars:");
        System.out.println("====================\n");
        for (Car currentCar : cars) {
            System.out.println(currentCar);
        }
    }
	
	public void displayOwners() {
		System.out.println("\nDisplaying All Owners:");
        System.out.println("====================\n");
        for (CarOwner owner : owners) {
            System.out.println(owner);
        }
	}
	
	public void pressAnyKey() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please Press any key to continue");
		sc.nextLine();
	}
	
	public void createNewCarMenu() {
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			// Display a menu for the user to select from 
			System.out.println("|=========================================|");
			System.out.println("|                                         |");
			System.out.println("|    Please Make a Selection:             |");
			System.out.println("|                                         |");
			System.out.println("| 1. Owner Already Exist                  |");
			System.out.println("| 2. Create New Owner And Car             |");
			System.out.println("| 3. Back to Main Menu                    |");
			System.out.println("|                                         |");
			System.out.println("|=========================================|");
			System.out.println("|                                         |");
			System.out.println("|Enter a choice:                          |");
			System.out.println("|                                         |");
			System.out.println("|=========================================|");
			int choice = sc.nextInt();
			
			switch (choice) {
		
			case 1:
				chooseTypeOfCarForExistingOwnerMenu();
				pressAnyKey();
				return;
				
			case 2: 
				chooseTypeOfCarForNewOwnerMenu();
				pressAnyKey();
				return;
             
			 case 3:
                System.out.println("Returning to main menu...");
                return;

             default:
                System.out.println("Invalid choice. Please try again.");
                pressAnyKey();
			}
		}
	}
	
	public void chooseTypeOfCarForExistingOwnerMenu() {
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			// Display a menu for the user to select from 
			System.out.println("|=========================================|");
			System.out.println("|                                         |");
			System.out.println("|    Please Make a Selection:             |");
			System.out.println("|                                         |");
			System.out.println("| 1. Create A Basic Car                   |");
			System.out.println("| 2. Create Sports Car                    |");
			System.out.println("| 3. Create Sedan Car                     |");
			System.out.println("| 4. Return to Create Car Menu            |");
			System.out.println("|                                         |");
			System.out.println("|=========================================|");
			int choice = sc.nextInt();
			
			switch (choice) {
				case 1: 
					Car carFromExistingOwner = createCarOwnerExists();
					if (carFromExistingOwner != null) {
						cars.add(carFromExistingOwner);
						System.out.println("New Car created successfully.");
					}
					pressAnyKey();
	                break;
	                
				case 2: 
					SportsCar sportCar = createSportsCarOwnerExists();
					if (sportCar != null) {
						cars.add(sportCar);				}
						System.out.println("New Sports Car created successfully.");
					
					pressAnyKey();
					break;
					
				case 3: 
					SedanCar sedan = createSedanCarOwnerExists();
					if (sedan != null) {
						cars.add(sedan);				
						System.out.println("New Sedan Car created successfully.");
					}
					pressAnyKey();
					break; 
				case 4: 
					System.out.println("Returning to main Car Menu...");
		            return;

		        default:
		            System.out.println("Invalid choice. Please try again.");
		            pressAnyKey();
			}
		}
	}
	
	
	public void chooseTypeOfCarForNewOwnerMenu() {
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			// Display a menu for the user to select from 
			System.out.println("|=========================================|");
			System.out.println("|                                         |");
			System.out.println("|    Please Make a Selection:             |");
			System.out.println("|                                         |");
			System.out.println("| 1. Create A Basic Car                   |");
			System.out.println("| 2. Create Sports Car                    |");
			System.out.println("| 3. Create Sedan Car                     |");
			System.out.println("| 4. Return to Create Car Menu            |");
			System.out.println("|                                         |");
			System.out.println("|=========================================|");
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1: 
				CarOwner ow = createOwner();
				if (ow != null) {
					owners.add(ow);
					System.out.println("New owner created successfully.");
				}
				Car car = createCar(ow);
				if (car != null) {
					cars.add(car);
					System.out.println("New Car created successfully.");
				}
				pressAnyKey();
                return;
				
			case 2: 
				CarOwner ow2 = createOwner();
				if (ow2 != null) {
					owners.add(ow2);
					System.out.println("New owner created successfully.");
				}
				SportsCar car2 = createSportsCar(ow2);
				if (car2 != null) {
					cars.add(car2);
					System.out.println("New Sports Car created successfully.");
				}
				pressAnyKey();
                return;
			case 3: 
				CarOwner ow3 = createOwner();
				if (ow3 != null) {
					owners.add(ow3);
					System.out.println("New owner created successfully.");
				}
				SedanCar car3 = createSedanCar(ow3);
				if (car3 != null) {
					cars.add(car3);
					System.out.println("New Sedan Car created successfully.");
				}
				pressAnyKey();
                return; 
			case 4: 
				System.out.println("Returning to main Car Menu...");
                return;

             default:
                System.out.println("Invalid choice. Please try again.");
                pressAnyKey();
			}
			
		}
	}
	
	public void vinNumberToSearchFor() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("|=========================================|");
		System.out.println("|                                         |");
		System.out.println("| Please enter the VIN to search by:      |");
		System.out.println("|                                         |");
		System.out.println("|=========================================|");
		System.out.println("");
		
		String vin = sc.nextLine().toUpperCase();
		searchForCarByVin(vin); 
	}
	
	public void searchForCarByVin(String vin) {
        for (Car car : cars) {  // Loop through the ArrayList of cars
            if (car.getVin().equals(vin)) {  // Check if the VIN number matches
                System.out.println("Car found:");
                System.out.println(car);  // Print the details of the car
                return;
            }
        }
        System.out.println("Car with VIN " + vin + " not found.");
    }
	
	public void nameOfOwnerForCarLookUp() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("|=========================================|");
		System.out.println("|                                         |");
		System.out.println("| Please enter the full name to search:   |");
		System.out.println("|                                         |");
		System.out.println("|=========================================|");
		System.out.println("");
		
		String ownerName = sc.nextLine().toUpperCase();
		searchForCarByOwner(ownerName); 
	}
	
	public void searchForCarByOwner(String ownerName) {
		
		 ownerName = ownerName.trim().toUpperCase();  // Normalize the input name
		    boolean found = false;  // To track if any cars are found

		    for (Car car : cars) {  // Loop through the ArrayList of cars
		        if (car.getOwner().getName().trim().toUpperCase().equals(ownerName)) {  // Normalize and compare
		            System.out.println("Car found for " + ownerName + ":");
		            System.out.println(car);  // Print the details of the car
		            found = true;  // Set found to true if at least one car is found
		        }
		    }

		    if (!found) {
		        System.out.println("Cars for the Owner " + ownerName + " not found.");
		    }
	}
	
	public void makeOfCarToLookFor() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("|=========================================|");
		System.out.println("|                                         |");
		System.out.println("| Please enter the car make to search:    |");
		System.out.println("|                                         |");
		System.out.println("|=========================================|");
		System.out.println("");
		
		String make = sc.nextLine().toUpperCase();
		searchForCarByMake(make);
	}
	
	public void searchForCarByMake(String make) {
		make = make.trim().toUpperCase();  // Normalize the input make
	    boolean found = false;  // To track if any cars are found
	    
	    System.out.println("Car(s) found with the make " + make + " :" );
	    for (Car car : cars) {  // Loop through the ArrayList of cars
	        if (car.getMake().trim().toUpperCase().equals(make)) {  // Normalize and compare
	            
	            System.out.println(car);  // Print the details of the car
	            found = true;  // Set found to true if at least one car is found
	        }
	    }

	    if (!found) {
	        System.out.println("Cars with Make of " + make + " not found.");
	    }

	}
	
	
}