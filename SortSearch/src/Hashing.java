import java.util.HashMap;
import java.util.Map;

// TODO: MurmurHash  -- simple / elegant
// TODO: SipHash-2-4  -- python
// TODO: Fowler–Noll–Vo (FNV) hash function. -- old pythoin
// TODO: BLAKE3 -- cutting edge
// TODO: XXH3 -- cutting edge
// TODO: HighwayHash -- cutting edge


public class Hashing {

	
	private static final int PROBE_LINEAR = 1;
	private static final int PROBE_QUADRATIC = 2;
	private static final int DOUBLE_HASH = 3;
	

	public static int modHash(int k, int m ) {
		return k % m;
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
	
	
	
	
	private void openAddressingDemo(int addressingMethod,Integer[] keysToAdd,int hashMapSize) {
		// Collision resolution test for W6.1
		
		Integer[] hashTable = new Integer[hashMapSize+1]; /// add one to account for the base 0 array
		
		int m = hashMapSize; 
		
		System.out.println("Initial hash function results");
		System.out.println("-----------------------------");
		System.out.println("key \t : \t hash");
		for (int k : keysToAdd) {
			int i = modHash(k,m);
			System.out.println(k + "\t : \t" + i);
			}
		
		System.out.println();
		System.out.println("Using Method: " + addressingMethod);
		System.out.println("-----------------------------");
		
		
		for (int k : keysToAdd) {
				int i = modHash(k,m);
				System.out.println("Try key " + k + " in " + i);
				while (hashTable[i] != null) {			//loop until a free slot is found
					System.out.println("COLLISION (contains "+hashTable[i]+ ") try \t" + (i+1));
					switch (addressingMethod) {
					case 1: // linear probing
						i++;
						break;
					case 2: // Quadratic addressing
						i++;
						i = i^2;
					default: // Double Hashing
						i = modHash(i,m);
					}
					
				}
			System.out.println("Added Slot " + i);
				hashTable[i] = k;
			}
		
		System.out.println();
		
		
		System.out.println("Open Addressing Results");
		System.out.println("-----------------------------");
		System.out.println("slot \t : \t key");
		
		Helpers.printArray(hashTable);
		
	}
	
	
	public static void main(String[] args) {

		Hashing testHash = new Hashing() ;
		
//		Integer[] linearTest = {5, 28, 19, 15, 20, 33, 12, 17, 10};
//		
//		testHash.openAddressingDemo(PROBE_LINEAR,linearTest,9);
	
		Integer[] quadraticTest = {10, 22, 31, 4, 15, 28, 17, 88, 59};
		
		testHash.openAddressingDemo(PROBE_QUADRATIC, quadraticTest, 11);
		
		
		

			
		}

		
		
	}	
	

	
