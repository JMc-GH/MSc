
public class Test_Code {



	public static void main(String[] args) {

		
		
		Hashing testHash = new Hashing() ;

		// Linear 
//		Integer[] linearTest = {5, 28, 19, 15, 20, 33, 12, 17, 10};
//		Helpers.printArray(linearTest);
//		
//		testHash.buildHashmap(linearTest,9);
//		
//		System.out.println(testHash.search(15,9));
		
		
	
		
		Integer[] quadraticTest = {10, 22, 31, 4, 15, 28, 17, 88, 59};
	
		testHash.setAddressingMode(Hashing.PROBE_QUADRATIC);
		testHash.buildHashmap(quadraticTest, 11);
		System.out.println(testHash.search(59, 11));
	}

}
