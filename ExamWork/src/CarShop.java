import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author john
 *
 */
public class CarShop {

	/**
	 * 
	 */
	
	private static CarShop vertu = new CarShop();
	private  ArrayList<Car> stock = new ArrayList<Car>();
	private  HashMap<Character,CarGrade> ourGrades = new HashMap<Character,CarGrade>();
	
	private class Car {
		private int ID;
		private String manufacturer;
		private String model;
		private short year;
		private int mileage;
		private String engineSize;
		private CarGrade grade;
		private float price;
		
		public Car(int ID) {
			this.ID = ID;
		}
		
		public String getManufacturer() {
			return manufacturer;
		}
		public void setManufacturer(String manufacturer) {
			this.manufacturer = manufacturer;
		}
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public short getYear() {
			return year;
		}
		public void setYear(short year) {
			this.year = year;
		}
		public int getMileage() {
			return mileage;
		}
		public void setMileage(int mileage) {
			this.mileage = mileage;
		}
		public String getEngineSize() {
			return engineSize;
		}
		public void setEngineSize(String engineSize) {
			this.engineSize = engineSize;
		}
		public CarGrade getGrade() {
			return grade;
		}
		public void setGrade(CarGrade grade) {
			this.grade = grade;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		} 
		
		
	}
	
	private class CarGrade {
		
		private int ID;
		private char grade;
		private String condition;
		private String description;
		
		public CarGrade(int iD, char grade, String condition, String description) {
			super();
			ID = iD;
			this.grade = grade;
			this.condition = condition;
			this.description = description;
		}

		public char getGrade() {
			return grade;
		}

		public String getCondition() {
			return condition;
		}

		public String getDescription() {
			return description;
		}



	}
	
	public CarShop() {
		
		ourGrades.put('A', new CarGrade(1, 'A', "Excellent", "Very slightly used, virtually as good as new."));
		ourGrades.put('B', new CarGrade(2, 'B', "Good", "Good condition but with visible flaws."));
		ourGrades.put('C', new CarGrade(3, 'C', "Average", "Average condition, with minor damage."));
		ourGrades.put('D', new CarGrade(4, 'D', "Poor", "Poor condition with significant damage, but the car is functional."));
		
	}


	private void addCarToStock(Scanner scn) {
		
		// TODO:  drop down lists for selections as validation
		
		
		Car newCar = new Car(1);

		
		System.out.println("ADD NEW CAR TO STOCK");
		System.out.println("====================\n");
		
		System.out.println("Manufacturer:");
		newCar.setManufacturer(scn.next());
		
		
		System.out.println("Model:");
		newCar.setModel(scn.next());
		
		System.out.println("Year:");
		newCar.setYear(scn.nextShort());
		
		System.err.println("Mileage:");
		newCar.setMileage(scn.nextInt());
		
		System.out.println("Engine Size");
		newCar.setEngineSize(scn.next());
		
		
		System.out.println("Grade (A,B,C,D,E):");
		
		newCar.setGrade(ourGrades.get(scn.next().charAt(0)));
		
		
		System.out.println("Price");
		newCar.setPrice(scn.nextFloat());
		
		stock.add(newCar);
		System.out.println("Car ADDEDD");
			
		
	}
	
	private void listCars() {
		
		for (Car inStock: stock ) {
			System.out.println(inStock.manufacturer);
			
		}
	}
	private void menuChoice() {
		
		Scanner scanner = new Scanner(System.in);
	        
	        int choice;
	        
	        do {
	            System.out.println("Please choose an option:");
	            System.out.println("1. Input new car");
	            System.out.println("2. List cars (Alphabetical Order)");
	            System.out.println("3. List cars (Lowest To Highest)");
	            System.out.println("4. Car with lowest mileage");
	            System.out.println("5. Car with lowest price");
	            System.out.println("6. Exit");
	            System.out.print("Your choice: ");
	           
	            
	            
	            choice = scanner.nextInt();
	            
	            
	            switch (choice) {
	                case 1:
	                    System.out.println("You chose option 1.");
	                    vertu.addCarToStock(scanner);
	                    break;
	                case 2:
	                    System.out.println("You chose option 2.");
	                    vertu.listCars();
	                    break;
	                case 3:
	                    System.out.println("You chose option 3.");

	                    break;
	                case 4:
	                    System.out.println("You chose option 4.");
	                    break;
	                case 5:
	                    System.out.println("You chose option 5.");
	                    break;
	                case 6:
	                    break;
	                default:
	                    System.out.println("Invalid Choice");
	                    break;
	            }
	            
	            System.out.println(); // Print blank line for readability
        	} while (choice != 6);
	        
	        scanner.close();
	        
	        System.out.println("BYE!");
	        
	}
		
	public static void main(String[] args) {
		
		
		
		vertu.menuChoice();
		

	}

}
