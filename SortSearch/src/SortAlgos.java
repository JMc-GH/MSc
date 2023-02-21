import java.util.Random;

public class SortAlgos {


	
	public int[] A = {0, 5, 13, 2, 25, 7, 17, 20, 8, 4};
	
	
	public SortAlgos() {
		// generateArray(11,100);
	
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
			spitArray();
		}
		
	}
	
	
	// QUICKSORT
	public void quickSort(int start, int end) {
		
		int pivot;
		
		if (start < end) {
			pivot = partition(start,end);
			quickSort(start,pivot-1);
			quickSort(pivot+1,end);
		}
	}
	
	private int partition(int start, int end) {
		
		int lastElement = A[end];
		int pivotPoint = start - 1;
		for (int j=start;j < end -1;j++) {
			if (A[j] <= lastElement) {
				pivotPoint++;
				swapElement(pivotPoint,j);
			}		
		}
		swapElement(pivotPoint+1,end);
		return pivotPoint+1;
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
	
	
	private void generateArray(int noOfElements,int maxValue) {
		
		Random rand = new Random();
		
		int[] temp = new int[noOfElements+1];
		
		for (int i = 1; i < noOfElements+1;i++) {
			temp[i] = rand.nextInt(maxValue);
		}
			
		A = temp;
	
		}
	
	private void spitArray() {
		
		for (int i=0;i<A.length;i++) {
			System.out.print(A[i] + "\t");
		}
		System.out.println("----");
	}
	

	
	// MAIN
	public static void main(String[] args) {
		
		SortAlgos testSort = new SortAlgos();
		testSort.spitArray();
		//testHeap.buildMaxHeap();
		//testHeap.heapSort();
		testSort.mergeSort(1, 9);
		
		//testSort.quickSort(1, testSort.A.length);
		testSort.spitArray();
	}

}
