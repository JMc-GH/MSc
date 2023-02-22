import java.util.Random;

public class Helpers {

	
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
	
	System.out.println("--");
}

public static String[] generateStringArray (int stringLength, int arrayLength) {
	
	Helpers internalHelper = new Helpers();
	
	String[] outputArray = new String[arrayLength];
	
	for (int i=0;i < arrayLength;i++) {
		outputArray[i] = internalHelper.generateString(stringLength);	
	}
	
	return outputArray;
	
}

private String generateString(int stringLength) {
	
	String outputString = new String();
	Random rand = new Random();
	
	for (int i=1; i < stringLength;i++) {
		outputString += (char) (rand.nextInt(58)+65);  ///TODO: note this clever offset
	}
	return outputString;
	
}

public static void main(String[] args) {
	
	printArray(generateStringArray(10,10));
	
}

}
