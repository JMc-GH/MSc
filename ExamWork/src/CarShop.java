// TODO: Sanitise user input
// TODO: Check output
// TODO: Search for car
// TODO: Manufacturer summary report

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class CarShop {

	
	private class Car {

		private int ID;
		private String manufacturer;
		private String model;
		private short year;
		private int mileage;
		private String engineSize;
		private CarGrade grade;
		private float price;
		
		  /**
	     * Creates a new car object with the specified attributes.
	     * 
	     * @param ID the ID of the car
	     * @param manufacturer the manufacturer of the car
	     * @param model the model of the car
	     * @param year the year of the car
	     * @param mileage the mileage of the car
	     * @param engineSize the engine size of the car
	     * @param grade the grade of the car
	     * @param price the price of the car
	     */
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
	private class CarStock extends ArrayList<Car> {
		// TODO: override add with generating ID
		
		private static final long serialVersionUID = 1L;
		private HashMap<Character,CarGrade> ourGrades = new HashMap<Character,CarGrade>();
		//TODO: override add method to generate ID if it's not given
		
		
		public CarStock() {
			//constructor sets up car grade types for this dealer
			ourGrades.put('A', new CarGrade(1, 'A', "Condition A", "Description A"));
			ourGrades.put('B', new CarGrade(1, 'B', "Condition B", "Description A"));
			ourGrades.put('C', new CarGrade(1, 'C', "Condition C", "Description A"));
			ourGrades.put('D', new CarGrade(1, 'D', "Condition D", "Description A"));
			ourGrades.put('E', new CarGrade(1, 'E', "Condition E", "Description A"));
			
		}

		
		public void populateTestData () {
			
			this.add(new Car(1, "Honda", "Fit", (short) 2013, 200500, "1.3L", ourGrades.get('A'), 5550.50F));
			this.add(new Car(2, "Toyota", "Prius", (short) 2012, 8800, "1.8L", ourGrades.get('A'), 8450.00F));
			this.add(new Car(3, "Volkswagon", "Golf", (short) 2016, 74550, "1.5L", ourGrades.get('B'), 12500.00F));
			this.add(new Car(4, "Toyota", "Yaris", (short) 2011, 110100, "1.0L", ourGrades.get('A'), 6500.50F));
			this.add(new Car(5, "Toyota", "Prius", (short) 2015, 52300, "1.8L", ourGrades.get('C'), 9999.95F));
			this.add(new Car(6, "Volkswagon", "Polo", (short) 2012, 140820, "1.2L", ourGrades.get('B'), 3050.50F));
			
		}
		
		public void sortByModel() {
			
	       Collections.sort(this, new Comparator<Car>() {
	    	   @Override
	            public int compare(Car c1, Car c2) {
	                return c1.model.compareTo(c2.model);
	            }
	        });
		}
		public Car getByID(int iD) {
			
			for (Car c : this) {
				if (c.ID == iD) {
					return c;
				}
			}
			
			return null;
		}
		
		private void sortByPrice() {
			
		       Collections.sort(this, new Comparator<Car>() {
		            public int compare(Car c1, Car c2) {
		                return Float.compare(c1.getPrice(), c2.getPrice());
		            }
		        });
		       
		}
		
		private Car getLowestMilage() {
			
				this.sortByMileage();
		
		       return this.get(0);
		}
		
		private Car getLowestPrice() {
			
			this.sortByPrice();
			return this.get(0);
			
		}
		
		private void sortByMileage() {
		       Collections.sort(this, new Comparator<Car>() {
		            public int compare(Car c1, Car c2) {
		                return Integer.compare(c1.getMileage(), c2.getMileage());
		            }
		        });
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
	            System.out.println("6. Search by ID");
	            System.out.println("7. Stock by Manufacturer");
	            System.out.println("8. Exit");
	            System.out.print("Your choice: ");
	           
	            
	            
	            choice = scanner.nextInt();
	            
	            
	            switch (choice) {
	                case 1:
	                    System.out.println("You chose option 1.");
	                    break;
	                case 2:
	                    System.out.println("You chose option 2.");
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
	                case 7:
	                	break;
	                default:
	                    System.out.println("Invalid Choice");
	                    break;
	            }
	            
	            System.out.println(); // Print blank line for readability
        	} while (choice != 8);
	        
	        scanner.close();
	        
	        System.out.println("BYE!");
	        
	}

	private void printHeader() {
	
	System.out.print("\033[1m");
	System.out.printf("%-3s%-15s%-12s%-6s%-9s%-7s%-12s%-20s\n", "ID", "Manufacturer", "Model", "Year", "Mileage", "Engine", "Grade", "Price");
	System.out.print("\033[0m");
	
}

	private void listCars(CarStock toList) {
	

	printHeader();
	
	for (Car c: toList ) printCarDetails(c,false);
	
}
	
	private void printCarDetails(Car toPrint, boolean printConditionDescription) {
	
	
	
	if (printConditionDescription) {
		System.out.printf("%-3s%-15s%-12s%-6s%-9s%-7s%-12s%-20s\n", toPrint.ID, toPrint.manufacturer, toPrint.model, 
			toPrint.year, toPrint.mileage, toPrint.engineSize, toPrint.grade.condition, toPrint.price);
	} else {
		System.out.printf("%-3s%-15s%-12s%-6s%-9s%-7s%-12s%-20s\n", toPrint.ID, toPrint.manufacturer, toPrint.model, 
				toPrint.year, toPrint.mileage, toPrint.engineSize, toPrint.grade.grade, toPrint.price);
	}

}

	public static void main(String[] args) {
		
	CarShop vertu = new CarShop();
	CarStock inStock = new CarShop().new CarStock();
	
	
	
	inStock.populateTestData();
	//vertu.listCars(inStock);
	//inStock.sortByModel();
	//vertu.listCars(inStock);
	//inStock.sortByPrice();
	vertu.listCars(inStock);
	vertu.printCarDetails(inStock.getByID(3),true);
	
	//vertu.printCarDetails(inStock.lowestMilage());
	
	
	
}
}
