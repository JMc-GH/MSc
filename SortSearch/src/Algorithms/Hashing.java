package Algorithms;
// TODO: Java code standards: 

/*
	OTHER HASHING ALGOS
	-------------------
	
	MurmurHash  -- simple / elegant
	SipHash-2-4  -- python
	Fowler–Noll–Vo (FNV) hash function. -- old pythoin
	BLAKE3 -- cutting edge
	XXH3 -- cutting edge
	HighwayHash -- cutting edge
 */



public class Hashing {

	
	private Integer[] hashTable;
	public static final int PROBE_LINEAR = 1;
	public static final int PROBE_QUADRATIC = 2;
	public static final int DOUBLE_HASH = 3;
	public static final int HASH_MODULUS = 1;
	
	private int addressingMode = PROBE_LINEAR;
	private int hashMode = HASH_MODULUS;
	
	
	// GETTERS AND SETTERS
	
	public int getHashMode() {
		return hashMode;
	}

	public void setHashMode(int hashMode) {
		this.hashMode = hashMode;
	}

	
	public Integer[] getHashTable() {
		return hashTable;
	}


	public int getAddressingMode() {
		return addressingMode;
	}


	public void setAddressingMode(int addressingMode) {
		this.addressingMode = addressingMode;
	}


	
	// main hashing function
	private int hash(int k, int m ) {
	
		int hashValue = k % m;

		if (hashValue == 0) {
			hashValue = 1;
		}
		
		return hashValue;
	}
	
	// for quadratic probing
	private int quadHash(int key,int counter) {
		
		int ret = key + counter^2;
	
		if (ret==0)ret = 1;
		
		return ret;
	}
	
	public void buildHashmap(Integer[] keysToAdd,int hashMapSize) {
		// Collision resolution test for W6.1
		// this populates the hashmap from an array of integers
		
		hashTable = new Integer[hashMapSize+1]; /// add one to account for the base 0 array
		
		int m = hashMapSize; 
		
		System.out.println("Initial hash function results");
		System.out.println("-----------------------------");
		System.out.println("key \t : \t hash");
		
		for (int k : keysToAdd) {
			int i = hash(k,m);
			System.out.println(k + "\t : \t" + i);
			}
		
		for (int k : keysToAdd) {
				insert(k,m);
			}
		
		System.out.println();
		
		
		System.out.println("Open Addressing Results");
		System.out.println("-----------------------------");
		System.out.println("slot \t : \t key");
		
		Helpers.printArray(hashTable);
	}
	

	public void insert(int k,int m) {
		
		int i = hash(k,m);		//generates the hash
		int j = 0; 
		System.out.println("Try key " + k + " in " + i);
		
		while (hashTable[i] != null) {			//loop until a free slot is found
			switch (addressingMode) {
			case 1: // linear probing
				i++;
				System.out.println("COLLISION try LINEAR \t" + (i));
				break;
			case 2: // Quadratic addressing
				j++;
				i = quadHash(i,j);
				System.out.println("COLLISION try QUADRATIC \t" + (i));
				break;
			default: // Double Hashing
				i++;
				i = i * (1 + (k % m));  //TODO: not working
				
			}
		}
		System.out.println("Added Slot " + i);
		hashTable[i] = k;
	}
	
	
	public int search(int k, int m) {
		//TODO : Should count deleted items?
		
		int index = hash(k,m);
		int j = 0;
			while (index <= m && hashTable[index] != k ) {
				switch (addressingMode) {
				case PROBE_LINEAR:
					index++;
					break;
				case PROBE_QUADRATIC:
					j++;
					index=quadHash(index,j);
					break;
				default: //TODO: double hashing
				
				}
			}
		if (index>m) return -1;
			else return index;
	}
	
	
	public void delete(int k) {
		//TODO : Add deleted marker?
	}
	
}	
	

	
