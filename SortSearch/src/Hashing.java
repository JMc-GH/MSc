
public class Hashing {

	
	private int[] Ai = {5, 28, 19,15,20,33,12,17,10};
	
	public Hashing() {
		
	}
	public int modHash(int key) {
		return key % 2^6;
	}
	
	
	public int multiHash(double key,int slots) {
		return (int) key * slots;
	}
	
	public static void main(String[] args) {
		
		Hashing testHash = new Hashing();
		Helpers myHelper = new Helpers();
//		
//		double[] testArray = myHelper.generateDoubleArray(0, 1, 20);
//		myHelper.printArray(testArray);
		
//		for (int i=0;i<testArray.length;i++) {
//			System.out.print(testHash.multiHash(testArray[i],testArray.length) + "\t");
//		}

//		String[] datTest = {"e","ae","be","ce","de","abe","ace","ade","bae"};
//		
//		for (String s : datTest) {
//			System.out.print(s + "\t");
//			int currInt = myHelper.stringToInt(s);
//			System.out.print(currInt + "\t");
//			System.out.print(testHash.modHash(currInt) + "\n");
//		}
		
		int[] elements = {18,41,22,44,59,2,31};
		
		for (int e : elements) {
			System.out.println(e % 7);
		}
		 
		
	}	
		
}
	
