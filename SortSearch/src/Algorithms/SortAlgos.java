package Algorithms;
// TODO: Auto-generated Javadoc

/**
 * The Class SortAlgos.
 */
public class SortAlgos {


	
	/** The a. */
	private Integer[] A = { 0, 5,5,5,5,5,5,5,5,5};
	
	
	/**
	 * Instantiates a new sort algos.
	 *
	 * @param sortArray the sort array
	 */
	public SortAlgos(Integer[] sortArray) {
		A = sortArray;
	}
	
	/**
	 * Instantiates a new sort algos.
	 */
	public SortAlgos() {
		
	}
	

	
	/**
	 * Merge.
	 *
	 * @param p the p
	 * @param q the q
	 * @param r the r
	 */
	// MERGE SORT
	private void merge(int p, int q, int r) {
		
		//calculate the legnth of each sorted array
		int leftLen = (q - p+1);  
		int rightLen = (r - q);
		
		int[] leftSide = new int[leftLen+1];
		int[] rightSide = new int[rightLen+1];
		
		//populate the new arrays
		for (int i=0;i < leftLen;i++) {
			leftSide[i] = A[p+i];
		}
		for (int j=0;j < rightLen;j++) {
			rightSide[j] = A[j+q+1]; 
		}
		
		
		//Sentinal nodes
		leftSide[leftLen] = 99999;
		rightSide[rightLen] = 99999;
		
		int i = 0; // keeps track of leftside top card
		int j = 0; // rightside
		
		for (int k = p; k <= r; k++) {
			if (leftSide[i] <= rightSide[j]) {
				A[k] = leftSide[i];
				i++;
			} else {
				A[k] = rightSide[j];
				j++;
			}
		}
		
	}
	
	
	/**
	 * Merge sort.
	 *
	 * @param p the p
	 * @param r the r
	 */
	public void mergeSort(int p, int r) {
		if (p < r) {
			int q = ((p+r)/2);
			mergeSort(p,q);
			mergeSort(q+1,r);
			merge(p,q,r);
		}
		
		
	}
	
	
	/**
	 * Heapify.
	 *
	 * @param current the current
	 * @param heapSize the heap size
	 */
	// HEAPSORT
	private void heapify(int current, int heapSize) {
		
		int leftChild = left(current);
		int rightChild = right(current);
		int largest;
		
		
		try {
			if (leftChild <= heapSize && A[leftChild] > A[current]) {
				largest = leftChild;
			} else {
				largest = current;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			largest = current;
		}
		
		try {
		if (rightChild <= heapSize && A[rightChild] > A[largest]) {
			largest = rightChild;
		}
		} catch (ArrayIndexOutOfBoundsException e) {
			largest = current;
		}
		

		if (largest != current) {
			swapElement(current,largest);
			heapify(largest,heapSize);
		}

	}

	
	/**
	 * Builds the max heap.
	 */
	public void buildMaxHeap() {
		for (int i=((A.length-1)/2);i > 0;i--) {
			heapify(i,A.length);
		}
	}
	
	
	/**
	 * Heap sort.
	 */
	public void heapSort() {
		
		for (int i=A.length-1;i > 1;i--) {
			swapElement(1,i);
			heapify(1,i-1);
			System.out.print(i + ":"); 
			Helpers.printArray(A);
		}
		
	}
	
	
	/**
	 * Quick sort.
	 *
	 * @param p the p
	 * @param r the r
	 */
	// QUICKSORT
	public void quickSort(int p, int r) {
		
		int q;
		
		if (p < r) {					//base condition (if start is same at end)
			q = partition(p,r);
			//Helpers.printArray(A);
			quickSort(p,q-1);
			quickSort(q+1,r);
		}
	}
	
	/**
	 * Partition.
	 *
	 * @param p the p
	 * @param r the r
	 * @return the int
	 */
	private int partition(int p, int r) {
		
		int x = A[r];			        //contents of last element (pivotpoint)
		int i = p - 1;					//index for elements < pivot
		for (int j=p;j < r;j++) {	//last element is the pivot point
			if (A[j] <= x) {			//if the current element is smaller that the pivot
				i++;					
				swapElement(i,j);		//put it at the start of the array cos its smaller than the pivot
			}		
		}
		swapElement(i+1,r);		//this puts the pivot point at the end of the < items
		return i+1;				
	}
	
	
	/**
	 * Swap element.
	 *
	 * @param first the first
	 * @param second the second
	 */
	// HELPERS
	private void swapElement(int first, int second) {
		int temp1 = A[first];
		A[first] = A[second];
		A[second] = temp1;
	}
	
	/**
	 * Left.
	 *
	 * @param i the i
	 * @return the int
	 */
	private int left(int i) {
		return i * 2;
	}
	
	/**
	 * Right.
	 *
	 * @param i the i
	 * @return the int
	 */
	private int right(int i) {
		return (i *2 ) + 1;
	}
	
	

	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	// MAIN
	public static void main(String[] args) {
		
//		SortAlgos testSort = new SortAlgos();
//		
//		testSort.A = Helpers.generateRandomArray(Integer.class, 10);
//		Helpers.printArray(testSort.A);
//		testSort.mergeSort(0,testSort.A.length-1); 
//		Helpers.printArray(testSort.A);
//
//		testSort.A = Helpers.generateRandomArray(Integer.class, 10);
//		Helpers.printArray(testSort.A);
//		testSort.quickSort(0, 9);
//		Helpers.printArray(testSort.A);
		
//		testSort.A = Helpers.generateRandomArray(Integer.class, 10);
//		Helpers.printArray(testSort.A);
//		testSort.buildMaxHeap();
//		testSort.heapSort();
//		Helpers.printArray(testSort.A);
		
		System.out.println((char) 97);
		

	}

}
