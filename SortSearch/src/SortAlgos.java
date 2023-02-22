public class SortAlgos {


	
	private Integer[] A = { 0, 5,5,5,5,5,5,5,5,5};
	
	
	public SortAlgos(Integer[] sortArray) {
		A = sortArray;
	}
	
	public SortAlgos() {
		
	}
	

	
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
	
	
	public void mergeSort(int p, int r) {
		if (p < r) {
			int q = ((p+r)/2);
			mergeSort(p,q);
			mergeSort(q+1,r);
			merge(p,q,r);
		}
		
		
	}
	
	
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

	
	public void buildMaxHeap() {
		for (int i=((A.length-1)/2);i > 0;i--) {
			heapify(i,A.length);
		}
	}
	
	
	public void heapSort() {
		
		for (int i=A.length-1;i > 1;i--) {
			swapElement(1,i);
			heapify(1,i-1);
			System.out.print(i + ":"); 
			Helpers.printArray(A);
		}
		
	}
	
	
	// QUICKSORT
	public void quickSort(int p, int r) {
		
		int q;
		
		if (p < r) {					//base condition (if start is same at end)
			q = partition(p,r);
			Helpers.printArray(A);
			quickSort(p,q-1);
			quickSort(q+1,r);
		}
	}
	
	private int partition(int p, int r) {
		
		int x = A[r];			        //contents of last element (pivotpoint)
		int i = p - 1;					//index for elements < pivot
		for (int j=p;j < r;j++) {	//last element is the pivot point
			if (A[j] >= x) {			//if the current element is smaller that the pivot
				i++;					
				swapElement(i,j);		//put it at the start of the array cos its smaller than the pivot
			}		
		}
		swapElement(i+1,r);		//this puts the pivot point at the end of the < items
		return i+1;				
	}
	
	
	// HELPERS
	private void swapElement(int first, int second) {
		int temp1 = A[first];
		A[first] = A[second];
		A[second] = temp1;
	}
	
	private int left(int i) {
		return i * 2;
	}
	
	private int right(int i) {
		return (i *2 ) + 1;
	}
	
	

	
	// MAIN
	public static void main(String[] args) {
		
		SortAlgos testSort = new SortAlgos();
		
		testSort.A = Helpers.generateRandomArray(Integer.class, 50);
		testSort.mergeSort(0,49);
		
		Helpers.printArray(testSort.A);

	}

}
