
public class Hashing {

	public int modHash(int key) {
		return key % 2^6;
	}
	
	
	public int multiHash(double key,int slots) {
		return (int) key * slots;
	}
	
	
	public static long djb2Hash(String str) {
	    // TODO: generated code - understand line-byline
		// REVIEW: before exam
		
		
		long hash = 5381;
	    for (int i = 0; i < str.length(); i++) {
	        char c = str.charAt(i);
	        hash = ((hash << 5) + hash) + c; // hash * 33 + c
	    }
	    return hash;
	}
	
	
	public static void main(String[] args) {
		
		// TODO:
		

		
		String[] keys = Helpers.generateStringArray(10, 10);
		Helpers.printArray(keys);
		System.out.println();
		for (String s : keys) {
			System.out.print(djb2Hash(s) + "\t");
		}
	}	
	
}
	
