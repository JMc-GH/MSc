import java.util.Random;

public class Helpers {

	
public double[] generateDoubleArray(int min, int max, int size) {
	
	Random rand = new Random();
	
	double[] temp = new double[size];
	
	for (int i=0;i<size;i++) {
		temp[i] = rand.nextDouble();
	}
	
	return temp;
	
}

public int stringToInt(String input) {
	
	int charSum = 0 ;
	
	for (char c : input.toCharArray()) {
		charSum = charSum + ((int) c)*128;
	}
	
	return charSum;
}
public void printArray (double[] testArray) {
	for (int i =0;i<testArray.length;i++) {
		System.out.println(testArray[i] + "\t" + (Math.floor(testArray[i] * testArray.length)));
	}
}
}
