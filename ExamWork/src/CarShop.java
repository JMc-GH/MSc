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
	
	private static CarShop vertu = new CarShop(true);
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
		
		public Car(int iD, String manufacturer, String model, short year, int mileage, String engineSize,
				CarShop.CarGrade grade, float price) {
			super();
			ID = iD;
			this.manufacturer = manufacturer;
			this.model = model;
			this.year = year;
			this.mileage = mileage;
			this.engineSize = engineSize;
			this.grade = grade;
			this.price = price;
		}

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
	
	
	private void populateGrades() {
		ourGrades.put('A', new CarGrade(1, 'A', "Excellent", "Very slightly used, virtually as good as new."));
		ourGrades.put('B', new CarGrade(2, 'B', "Good", "Good condition but with visible flaws."));
		ourGrades.put('C', new CarGrade(3, 'C', "Average", "Average condition, with minor damage."));
		ourGrades.put('D', new CarGrade(4, 'D', "Poor", "Poor condition with significant damage, but the car is functional."));
		
	}
	
	public CarShop(boolean testData) {
		
		populateGrades();
		
		if (testData) {
			stock.add(new Car(1, "Honda", "Fit", (short) 2013, 200500, "1.3L", ourGrades.get('A'), 5550.50F));
			stock.add(new Car(2, "Toyota", "Prius", (short) 2012, 8800, "1.8L", ourGrades.get('A'), 8450.00F));
			stock.add(new Car(3, "Volkswagon", "Golf", (short) 2016, 74550, "1.5L", ourGrades.get('B'), 12500.00F));
			stock.add(new Car(4, "Toyota", "Yaris", (short) 2011, 110100, "1.0L", ourGrades.get('A'), 6500.50F));
			stock.add(new Car(5, "Toyota", "Prius", (short) 2015, 52300, "1.8L", ourGrades.get('C'), 9999.95F));
			stock.add(new Car(6, "Volkswagon", "Polo", (short) 2012, 140820, "1.2L", ourGrades.get('B'), 3050.50F));
		}

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
	
	
	//TODO: write a clever sort for the collecrtions
	
	
	private void listCars() {
		
		System.out.printf("%-3s%-15s%-12s%-6s%-9s%-7s%-12s%-20s\n", "ID", "Manufacturer", "Model", "Year", "Mileage", "Engine", "Grade", "Price");
		for (Car inStock: stock ) {
			System.out.printf("%-3s%-15s%-12s%-6s%-9s%-7s%-12s%-20s\n", inStock.ID, inStock.manufacturer, inStock.model, 
					inStock.year, inStock.mileage, inStock.engineSize, inStock.grade.condition, inStock.price);
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
