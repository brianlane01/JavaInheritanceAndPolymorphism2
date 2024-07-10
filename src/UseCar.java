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
	
	//simulating the main method
	public void start() {
		
		//This will create some pre-seeded car owners
        CarOwner owner1 = new CarOwner("Bruce Wayne", "123 Gotham Lane");
        CarOwner owner2 = new CarOwner("Clark Kent", "456 Smallville Avenue");
        CarOwner owner3 = new CarOwner("Oliver Queen", "789 Star Road");
        
        //this will create some pre-seeded cars with the appropriate owner
        Car car1 = new Car("Lamborghini", "Aventador S", 2021, "ZHWUR1ZDXMLA02984", 421000.0d, owner1);
        Car car2 = new Car("Ford", "F-150 Rapto", 2024, "1FTFW1RG1MFB56743", 65000.99d, owner2);
        Car car3 = new Car("Aston Martin", "DB11", 2025, "SCFRMFAV4MGL05021", 205600.78d, owner3);
        
        //this will add the cars with their owners to the ArrayList 
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
		
		CarOwner ow = createOwner();
		
		Car myCar = createCar(ow);
		//Car myCar = new Car ("Chevy", "Tahoe", 2024, 80000.0d, ow);  
		
		cars.add(myCar);
		
		displayCars();
		
		
	}
	
	/**
     * Description: This is a method to create a new car owner by taking input from the user.
     * @return a CarOwner object with the inputed name and address.
     */
	public CarOwner createOwner() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the name of the owner: ");
		String name = sc.nextLine();
		
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
        String make = sc.nextLine();

        System.out.println("Enter the model of the car: ");
        String model = sc.nextLine();

        System.out.println("Enter the year of the car: ");
        int year = sc.nextInt();
        
        System.out.println("Enter the VIN for the car");
        String vin = sc.nextLine();

        System.out.println("Enter the price of the car: ");
        double price = sc.nextDouble();

        Car car = new Car(make, model, year, vin, price, owner);
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
}