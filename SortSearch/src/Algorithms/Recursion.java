/*
 * 
 */
package Algorithms;

// TODO: Auto-generated Javadoc
/**
 * The Class Recursion.
 */
public class Recursion {


	/**
	 * Checks if is palindrome.
	 *
	 * @param input the input
	 * @return true, if is palindrome
	 */
	public static boolean isPalindrome(String input) {
		
		//base case
		//a zero string or single char string is always a palindrome
		if (input.length()==0 || input.length()==1) {
			return true;
		}
		
		//work to shrink the problem
		if (input.charAt(0)==input.charAt(input.length()-1)) {
			return isPalindrome(input.substring(1,input.length()-1));
		}
		
		//second base case if the comparison above fails - not a palidrome
		return false;
		
	}
	
	/**
	 * Convert binary.
	 *
	 * @param input the input
	 * @param result the result
	 * @return the string
	 */
	public static String convertBinary(int input, String result) {
		
		//base case
		if (input == 0) {
			return result;
		}
	
		// this builds the output string
		result = input % 2 + result; 	//prepend the remainder of the divison to the
										// final output string
		
		// divide the input by 2 and call again
		return convertBinary(input /2, result);
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
