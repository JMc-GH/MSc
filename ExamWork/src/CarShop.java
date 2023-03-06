

import java.text.DecimalFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class CarShop {

	// Create an instance of CarShop class
	static CarShop vertu = new CarShop();
	
	// Create an instance of CarStock class
	static CarStock inStock = new CarShop().new CarStock();
	
	/**
	 * This class represents a summary of the number of cars available for each manufacturer.
	 * It has id, vehCount, and totalValue attributes.
	 * This class has getter and setter methods for id, vehCount, and totalValue attributes.
	 */
	private class mfrSummary {

        /**
         * The unique identifier for the manufacturer summary.
         */
		private int id;

        /**
         * The total number of vehicles produced by the manufacturer.
         */
		private int vehCount;

        /**
         * The total value of all vehicles produced by the manufacturer.
         */
		private float totalValue;

        /**
         * Returns the unique identifier for the manufacturer summary.
         * @return the unique identifier for the manufacturer summary
         */
		public int getId() {
			return id;
		}

        /**
         * Sets the unique identifier for the manufacturer summary.
         * @param id the unique identifier for the manufacturer summary
         */
		public void setId(int id) {
			this.id = id;
		}

        /**
         * Returns the total number of vehicles produced by the manufacturer.
         * @return the total number of vehicles produced by the manufacturer
         */
		public int getVehCount() {
			return vehCount;
		}

        /**
         * Sets the total number of vehicles produced by the manufacturer.
         * @param vehCount the total number of vehicles produced by the manufacturer
         */
		public void setVehCount(int vehCount) {
			this.vehCount = vehCount;
		}

        /**
         * Returns the total value of all vehicles produced by the manufacturer.
         * @return the total value of all vehicles produced by the manufacturer
         */
		public float getTotalValue() {
			return totalValue;
		}

        /**
         * Sets the total value of all vehicles produced by the manufacturer.
         * @param totalValue the total value of all vehicles produced by the manufacturer
         */
		public void setTotalValue(float totalValue) {
			this.totalValue = totalValue;
		}
		
		
	}
	/**
	 * This class represents a car.
	 * It has ID, manufacturer, model, year, mileage, engineSize, grade, and price attributes.
	 * It has two constructors; one with parameters, and one without parameters.
	 * This class provides methods to set and get the car attributes. 
	 */
	private class Car {

		private int ID;
		

		private String manufacturer;
		private String model;
		private short year;
		private int mileage;
		private float engineSize;
		private CarGrade grade;
		private float price;
		
        /**
        * 
        * Constructs a Car object with the specified attributes.
        * Only used to generate test data as the setters are by-passed (so no validation is performed against inputs)
        * @param iD the ID of the car
        * @param manufacturer the manufacturer of the car
        * @param model the model of the car
        * @param year the year of the car
        * @param mileage the mileage of the car
        * @param engineSize the engine size of the car
        * @param grade the grade of the car
        * @param price the price of the car
        */
		public Car(int iD, String manufacturer, String model, short year, int mileage, float engineSize,
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

        /**
        *Constructs a Car object with default attributes.
        */
		public Car() {}
		
		/**
		 * Get ID of the car.
		 * @return ID of the car
		 */
		public int getID() {
			return ID;
		}
		
		/**
		 * Set ID of the car.
		 * @param iD ID of the car
		 * @throws IllegalArgumentException when ID is not a valid integer.
		 */
		public void setID(String iD) throws IllegalArgumentException {
			
				ID = Integer.parseInt(iD);
	
		}

		/**
	     * Get the manufacturer of the car.
	     * @return manufacturer of the car.
	     */
		public String getManufacturer() {
			// TODO: lookup against list of mfrs
			
			return manufacturer;
		}

        /**
        * Sets the manufacturer of the car.
        * @param manufacturer the manufacturer of the car
        */
		public void setManufacturer(String manufacturer) {
			this.manufacturer = manufacturer;
		}
		
		/**
        * Returns the model of the car.
        * @return the model of the car
        */
		public String getModel() {
			return model;
		}
        /**
        *
        * Sets the model of the car.
        * @param model the model of the car
        */
		public void setModel(String model) {
			// lookup against list of mfrs
			this.model = model;
		}
		
        /**
        *
        *Returns the year of the car.
        * @return the year of the car
        */
		public short getYear() {
			return year;
		}

        /**
        *
        * Sets the year of the car.
        *
        * @param year the year of the car
        * @throws IllegalArgumentException when the year is not within a reasonable range.
        */
		public void setYear(String year) throws IllegalArgumentException {
			
			short setYear;
							
			// check that it's a number
			setYear = Short.parseShort(year);
			
			// check that it's within a reasonable range
			if (setYear < 1885 || setYear > Year.now().getValue()) {
				throw new IllegalArgumentException("Year must be between 1885 and " + Year.now().getValue());
			}
			
			this.year = setYear;
		}
		
		/**
        *
        * Returns the mileage of the car.
        * @return the mileage of the car
        */
		public int getMileage() {
			return mileage;
		}

        /**
        * This method sets the mileage of the car.
        * @param mileage a String representing the mileage to be set
        * @throws IllegalArgumentException if the input mileage is not a positive number
        */
		public void setMileage(String mileage) throws IllegalArgumentException{
			
			int setMileage;
			
			// check that it's a number
			setMileage = Integer.parseInt(mileage);
			
			// check that it's within a reasonable range
			if (setMileage < 0) throw new IllegalArgumentException("Must be a positive number");
	
			this.mileage = setMileage;
			
		}
		
		/**
        * This method gets the engine size of the car.
        * @return a String representing the engine size of the car
        */
		public String getEngineSize() {	
			
			String myEngineSize = engineSize + "L";
			
			return myEngineSize;
		}

        /**
        * This method sets the engine size of the car.
        * @param engineSize a String representing the engine size to be set in the format 9.99L
        * @throws IllegalArgumentException if the input engine size is not in the format 9.99L
        */
		public void setEngineSize(String engineSize) throws IllegalArgumentException {
			
			// check the format
			if (!engineSize.matches("\\d{1,2}\\.\\d{1,2}L")) throw new IllegalArgumentException("Must be in the format 9.99L"); 
			
			float newEngineSize = Float.parseFloat(engineSize.substring(0, engineSize.length() - 1));
			
			this.engineSize = newEngineSize;
		}
		/**
        * This method gets the grade of the car.
        * @return a CarGrade representing the grade of the car
        */
		public CarGrade getGrade() {
			return grade;
		}

        /**
        * This method sets the grade of the car.
        * @param grade a String representing the grade of the car, must be a single character
        * @throws IllegalArgumentException if the input grade is not a single character
        */
		public void setGrade(String grade) {
			
			char newGrade = 0;
			
			if (grade.length() != 1) throw new IllegalArgumentException("Must be a single char");
			//check its a single char
			
			newGrade = grade.charAt(0);
			
			this.grade = inStock.ourGrades.get(newGrade);
		}
		
		/**
        * This method gets the price of the car in UK currency format.
        * @return a String representing the price of the car in UK currency format
        */
		public String getPrice() {
			
			
	        DecimalFormat formatter = (DecimalFormat) DecimalFormat.getCurrencyInstance(Locale.UK); 
	        return formatter.format(this.price); 
	        
		}

        /**
        * This method sets the price of the car.
        * @param price a String representing the price of the car in UK currency format, e.g. £10,000.00
        */
		public void setPrice(String price) {
			
			String strippedFigure = price.replaceAll("[\\p{Sc},]", "");
			float newPrice = Float.parseFloat(strippedFigure);

			this.price = newPrice;
		} 
		
		
	}

	/**
	 * The CarStock class represents the inventory of cars in the dealership. It
	 * extends ArrayList and includes a HashMap to store CarGrade objects.
	 */
	private class CarStock extends ArrayList<Car> {
		// TODO: override add with generating ID
		
        /** The serial version UID. */
		private static final long serialVersionUID = 1L;


        /** The map of CarGrade objects. */
		private HashMap<Character,CarGrade> ourGrades = new HashMap<Character,CarGrade>();
		//TODO: override add method to generate ID if it's not given
		
		/**
		 * Constructs a CarStock object and sets up car grade types for this dealer.
		 */
		public CarStock() {
			//constructor sets up car grade types for this dealer
			ourGrades.put('A', new CarGrade(1, 'A', "Condition A", "Description A"));
			ourGrades.put('B', new CarGrade(1, 'B', "Condition B", "Description A"));
			ourGrades.put('C', new CarGrade(1, 'C', "Condition C", "Description A"));
			ourGrades.put('D', new CarGrade(1, 'D', "Condition D", "Description A"));
			ourGrades.put('E', new CarGrade(1, 'E', "Condition E", "Description A"));
			
		}

		/**
        * Populates the CarList with sample Car objects for testing purposes.
        * The method adds a new Car object to the list for each of the test data items.
        * @return void
        */
		public void populateTestData () {
			
			this.add(new Car(1, "Honda", "Fit", (short) 2013, 200500, 1.3F, ourGrades.get('A'), 5550.50F));
			this.add(new Car(2, "Toyota", "Prius", (short) 2012, 8800, 1.8F, ourGrades.get('A'), 8450.00F));
			this.add(new Car(3, "Volkswagon", "Golf", (short) 2016, 74550, 1.5F, ourGrades.get('B'), 12500.00F));
			this.add(new Car(4, "Toyota", "Yaris", (short) 2011, 110100, 1.0F, ourGrades.get('A'), 6500.50F));
			this.add(new Car(5, "Toyota", "Prius", (short) 2015, 52300, 1.8F, ourGrades.get('C'), 9999.95F));
			this.add(new Car(6, "Volkswagon", "Polo", (short) 2012, 140820, 1.2F, ourGrades.get('B'), 3050.50F));
			
		}
		
		/**
        * This method sorts the list of cars by their ID numbers in ascending order.
        */
		public void sortByID () {
		       Collections.sort(this, new Comparator<Car>() {
		            public int compare(Car c1, Car c2) {
		                return Integer.compare(c1.ID, c2.ID);
		            }
		        });
		}
        /**
        * This method sorts the list of cars by their model name in alphabetical order.
        */
		public void sortByModel() {
			
	       Collections.sort(this, new Comparator<Car>() {
	    	   @Override
	            public int compare(Car c1, Car c2) {
	                return c1.model.compareTo(c2.model);
	            }
	        });
		}
		
        /**
        * This method returns a Car object from the list based on the provided ID number.
        * @param iD the ID number of the Car to be returned
        * @return the Car object that matches the provided ID number, or null if no match is found
        */
		public Car getByID(int iD) {
			
			for (Car c : this) {
				if (c.ID == iD) {
					return c;
				}
			}
			
			return null;
		}
		
		/**
		* Sorts the list of cars by their price in ascending order.
		* This method uses the Collections.sort() method to sort the current list of cars
		* by their price. It implements a Comparator<Car> object that compares the price
		* of each Car instance in the list. The resulting sorted list is in ascending order
		* based on the price of the cars.
		* @throws UnsupportedOperationException if the list of cars is not modifiable.
		* @see Collections#sort(List)
		* @see Comparator
		*/
		public void sortByPrice() {
			
		       Collections.sort(this, new Comparator<Car>() {
		            public int compare(Car c1, Car c2) {
		                return Float.compare(c1.price, c2.price);
		            }
		        });
		       
		}
		
		/**
		Returns the Car instance with the lowest mileage in the list.
		This method uses the sortByMileage() method to sort the current list of cars by their
		mileage in ascending order, and then returns the Car instance with the lowest mileage
		(i.e., the first element of the sorted list).
		@return the Car instance with the lowest mileage in the list.
		@throws IndexOutOfBoundsException if the list of cars is empty.
		@see #sortByMileage()
		*/
		public Car getLowestMilage() {
			
				this.sortByMileage();
		
		       return this.get(0);
		}
		
		/**
		* Returns the Car instance with the lowest price in the list.
		* This method uses the sortByPrice() method to sort the current list of cars by their
		* price in ascending order, and then returns the Car instance with the lowest price
		* (i.e., the first element of the sorted list).
		* @return the Car instance with the lowest price in the list.
		* @throws IndexOutOfBoundsException if the list of cars is empty.
		* @see #sortByPrice()
		*/
		public Car getLowestPrice() {
			
			this.sortByPrice();
			return this.get(0);
			
		}
		
		/**
		* Sorts the list of cars by their mileage in ascending order.
		* This method uses the Collections.sort() method to sort the current list of cars
		* by their mileage. It implements a Comparator<Car> object that compares the mileage
		* of each Car instance in the list using the getMileage() method. The resulting sorted
		* list is in ascending order based on the mileage of the cars.
		* @throws UnsupportedOperationException if the list of cars is not modifiable.
		* @see Collections#sort(List)
		* @see Comparator
		* @see Car#getMileage()
		*/
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
	
	/**
	* Presents a menu to the user and waits for input
	@see Scanner
	*/
	private void menuChoice() {
		
		Scanner scanner = new Scanner(System.in);
	        
	        int choice;
	        
	        do {
	            System.out.println("Please choose an option:");
	            System.out.println("1. Input new car");
	            System.out.println("2. List Cars (Sorted by Model");
	            System.out.println("3. List Cars (Sort By Price)");
	            System.out.println("4. Car with lowest mileage");
	            System.out.println("5. Car with lowest price");
	            System.out.println("6. Search by ID");
	            System.out.println("7. Stock by Manufacturer");
	            System.out.println("8. Exit");
	            System.out.print("Your choice: ");
	           
	            
	            
	            choice = scanner.nextInt();
	            
	            
	            switch (choice) {
	                case 1:
	                    vertu.addCar(scanner);
	                    break;
	                case 2:
	                    inStock.sortByModel();
	                    vertu.listCars(inStock);
	                    break;
	                case 3:
	                    inStock.sortByPrice();
	                    vertu.listCars(inStock);
	                    break;
	                case 4:
	                    vertu.printCarDetails(inStock.getLowestMilage(), false);
	                    break;
	                case 5:
	                    vertu.printCarDetails(inStock.getLowestPrice(), false);
	                    break;
	                case 6:
	                	System.out.println("Please enter the ID:");
	                	int id = scanner.nextInt();
	                	vertu.printCarDetails(inStock.getByID(id), true);
	                    break;
	                case 7:
	                	vertu.manufacturerReport(inStock);
	                	break;
	                case 8:
	                	// exiting programme
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

	/**
	* Adds a new car to the inventory.
	* Prompts the user to enter the details of the car, including ID, manufacturer, model, year, mileage, engine size, grade, and price.
	* If the details are valid, a new Car object is created and added to the inventory.
	* If any of the details are invalid, an IllegalArgumentException is thrown and an error message is printed to the console.
	*
	* @param scn the Scanner object used to read input from the console
	*/
	private void addCar(Scanner scn) {
		
		Car newCar = new Car();
		
			
			try {
				System.out.println("Enter ID:");
				newCar.setID(scn.next());
				
				System.out.println("Enter Maufacturer:");
				newCar.setManufacturer(scn.next());
				
				System.out.println("Enter Model:");
				newCar.setModel(scn.next());
				
				System.out.println("Enter Year:");
				newCar.setYear(scn.next());
				
				System.out.println("Enter Mileage:");
				newCar.setMileage(scn.next());
				
				System.out.println("Enter Engine:");
				newCar.setEngineSize(scn.next());
				
				System.out.println("Enter Grade (A,B,C,D,E):");
				newCar.setGrade(scn.next());
				
				System.out.println("Enter Price:");
				newCar.setPrice(scn.next());

				inStock.add(newCar);
				
			} catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
			}
			
		}

		
		
		
	/**
	* Prints the header for the inventory table, which includes the column labels for ID, manufacturer, model, year, mileage, engine size, grade, and price.
	* Uses ANSI escape codes to make the text bold.
	*/
	private void printHeader() {
	
	System.out.print("\033[1m");
	System.out.printf("%-3s%-15s%-12s%-6s%-9s%-7s%-12s%-20s\n", "ID", "Manufacturer", "Model", "Year", "Mileage", "Engine", "Grade", "Price");
	System.out.print("\033[0m");
	
}
	/**
	 * Prints the details of a car, including its ID, manufacturer, model, year, mileage, engine size, grade, and price.
	 * If the boolean parameter printConditionDescription is true, it prints the condition description of the car's grade
	 * instead of its letter grade.
	 * 
	 * @param toPrint The car object whose details are to be printed.
	 * @param printConditionDescription A boolean parameter that indicates whether to print the condition description of the
	 * car's grade (true) or its letter grade (false).
	 */

	/**
	 * Prints the details of a car.
	 *
	 * @param toPrint the car whose details will be printed
	 * @param printConditionDescription if true, the condition of the car's grade will be printed instead of the grade
	 */
	private void printCarDetails(Car toPrint, boolean printConditionDescription) {
		
		
		
	if (printConditionDescription) {
		System.out.printf("%-3s%-15s%-12s%-6s%-9s%-7s%-12s%-20s\n", toPrint.getID(), toPrint.getManufacturer(), toPrint.getModel(), 
			toPrint.getYear(), toPrint.getMileage(), toPrint.getEngineSize(), toPrint.getGrade().getCondition(), toPrint.getPrice());
	} else {
		System.out.printf("%-3s%-15s%-12s%-6s%-9s%-7s%-12s%-20s\n", toPrint.getID(), toPrint.getManufacturer(), toPrint.getModel(), 
				toPrint.getYear(), toPrint.getMileage(), toPrint.getEngineSize(), toPrint.getGrade().getGrade(), toPrint.getPrice());
	}

}
	/**

	* Prints a list of cars from a given CarStock object without printing the condition description.
	* The method calls the printHeader() method to print the header of the table, then iterates over the
	* CarStock object passed as a parameter to print the details of each car using the printCarDetails()
	* method.
	* @param toList a CarStock object representing the list of cars to print.
	*/
	private void listCars(CarStock toList) {
	
	printHeader();
	for (Car c: toList ) printCarDetails(c,false);
	
}
	
	/**
	* Generates a manufacturer report based on the given CarStock object, including the manufacturer name,
	* number of cars for each manufacturer, and the total value of each manufacturer's stock.
	* @param stockList a CarStock object to generate a report for.
	*/
	private void manufacturerReport(CarStock stockList) {
		
		HashMap<String,mfrSummary> summaryReport = new HashMap<String,mfrSummary>();
		
		
		int id = 0;
		
		for (Car c: stockList) {
			
			if (!summaryReport.containsKey(c.getManufacturer())) {
				mfrSummary s = new mfrSummary();
				s.setVehCount(1);
				s.setId(id);
				id++;
				s.setTotalValue(c.price);
				summaryReport.put(c.getManufacturer(), s);
				
			} else {
				summaryReport.get(c.getManufacturer()).vehCount++;
				summaryReport.get(c.getManufacturer()).totalValue += c.price;
			}
		}
		
		System.out.print("\033[1m");
		System.out.printf("%-3s%-15s%-6s%-12s\n", "ID", "Manufacturer", "Count", "Stock Value");
		System.out.print("\033[0m");
		
		summaryReport.forEach((key, mfr) -> {
			System.out.printf("%-3s%-15s%-6s%-12s\n", mfr.getId(), key, mfr.getVehCount(), mfr.getTotalValue());
		});
	}
	

	/**
	* The main method of the CarShop class. It populates the "inStock" CarStock object with test data if any command-line arguments are provided, then calls the menuChoice method to start the program's menu system.
	* @param args the command-line arguments passed to the program
	*/
	public static void main(String[] args) {
		

	if (args.length != 0) inStock.populateTestData();
	
	vertu.menuChoice();
	}
	
	
}
