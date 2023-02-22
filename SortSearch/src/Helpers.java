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


public static <T> T[] generateRandomArray(Class<T> clazz, int length) {
    T[] array = (T[]) java.lang.reflect.Array.newInstance(clazz, length);
    Random rand = new Random();
    for (int i = 0; i < length; i++) {
        if (clazz == Integer.class) {
            array[i] = (T) Integer.valueOf(rand.nextInt(100));
        } else if (clazz == Double.class) {
            array[i] = (T) Double.valueOf(rand.nextDouble());
        } else if (clazz == Float.class) {
            array[i] = (T) Float.valueOf(rand.nextFloat());
        } else if (clazz == Long.class) {
            array[i] = (T) Long.valueOf(rand.nextLong());
        } else if (clazz == Short.class) {
            array[i] = (T) Short.valueOf((short) rand.nextInt(Short.MAX_VALUE + 1));
        } else if (clazz == Byte.class) {
            array[i] = (T) Byte.valueOf((byte) rand.nextInt(Byte.MAX_VALUE + 1));
        } else {
            throw new IllegalArgumentException("Unsupported array type: " + clazz.getName());
        }
    }
    return array;
}


public static <T> void printArray (T[] testArray) {
	
	for (T element : testArray) {
		System.out.print(element + "\t");
	}
}


}
