package Algorithms;


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
		String s1 = new String ("Good choice");
		String s2 = new String ("Good choice");
		String s3 = "Good choice";
			
		if(s1==s2){
			System.out.println("Statement A");
		}
		else if(s3.equals(s2)){
			System.out.println("Statement B");
		}
		else if((s1!=s3)&&(s1.equals(s2))){
			System.out.println("Statement C");
		}
		else if((s1==s2)||(s1.equals(s3))){
			System.out.println("Statement D");
		}	
		else System.out.println("Statement E");
		
	
//		
//		Integer[] quadraticTest = {10, 22, 31, 4, 15, 28, 17, 88, 59};
//	
//		testHash.setAddressingMode(Hashing.PROBE_QUADRATIC);
//		testHash.buildHashmap(quadraticTest, 11);
//		System.out.println(testHash.search(19, 11));
	}

}
