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
	
	
	@SuppressWarnings("unused")
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
		
		public CarGrade (int ID) {
			this.ID = ID;
		}
		public char getGrade() {
			return grade;
		}

		public void setGrade(char grade) {
			this.grade = grade;
		}

		public String getCondition() {
			return condition;
		}

		public void setCondition(String condition) {
			this.condition = condition;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}


	}
	
	public CarShop() {
		// TODO: Generate CarGrades
		
	}


	private void showMenu() {
		
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
	                default:
	                    System.out.println("Invalid Choice");
	                    break;
	            }
	            
	            System.out.println(); // Print blank line for readability
        	} while (choice != 6);
	        
	        System.out.println("BYE!");
	        scanner.close();
	}
		
	public static void main(String[] args) {
		
		CarShop vertu = new CarShop();
		
		vertu.showMenu();
		

	}

}
