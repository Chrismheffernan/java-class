package happyNumbers;

import java.util.Scanner;
import java.util.Stack;

public class HappyNumbers {

	static Scanner sc = new Scanner(System.in);
	private static Stack<Integer> stack;
	static int[] arrayOfNumbers = new int[50];
	static int arrayPosition = 0;
	

	public static void main(String[] args) {
		
		stack = new Stack<Integer>();
		blankArray(arrayOfNumbers);
		
		int number;
		boolean inUse = true;
		boolean start = false;
		System.out.println("Welcome to the Happy Numbers program! \nPlease enter a number "
				+ "and I'll find out if its happy or not.\n Or 0 to quit: ");
		
		while(inUse)
		{
			if( start == true)
			{
				System.out.println("Please enter a number and I'll find out if its happy or not. Or 0 to quit: ");
			}
			start = true;
			number = sc.nextInt();
			while( number < 0)
			{
				System.out.println("Please enter a number greater than 0 or 0 to quit: ");
				number = sc.nextInt();
			}
			
			
			if (happyCheck(number))
			{
				printArray(arrayOfNumbers, number);
				blankArray(arrayOfNumbers);
				System.out.println("This number is happy!\n");
			}
			else if( number == 0 )
			{
				inUse = false;
			}
			else
			{
				printArray(arrayOfNumbers, number);
				blankArray(arrayOfNumbers);
				System.out.println("This number is not happy.\n");
			}
			
			
			
			
		}
		
		System.out.println("Thanks for using the program!");
		
	}
	
	/**
	 * Function happyCheck
	 * Breaks up a number into separate digits, squares them then adds them back together
	 * Breaks only when tested against an outside loop, or when one of the numbers is equal to 1
	 * @param number - number meant to check against
	 * @return
	 */
	public static boolean happyCheck(int number)
	{
		int placeHolder;
		int total = 0;
		
		
		while( number > 0)
		{
			stack.push(number % 10);
			number /=10;
			
		}
		
		while ( !stack.isEmpty())
		{
			placeHolder = stack.pop();
			total += placeHolder*placeHolder;
		}
		
		if(arrayChecker(total))
		{
			
			return false;
		}
		
		
		if( total == 1 || happyCheck(total))
		{
			return true;
		}
		
		
		
		
		return false;
		
		
	}
	
	/**
	 * Function arrayChecker
	 * Checks against an array created during the happyChecker function
	 * As happyChecker is recursive, we had to create an outside array that happyChecker
	 * can use to ensure it doesn't get stuck in a loop
	 * @param number - number to check against the array
	 * @return
	 */
	public static boolean arrayChecker(int number)
	{
		for(int x = 0; x < arrayPosition + 1; x++)
		{
			if( arrayOfNumbers[x] == number)
			{
				arrayOfNumbers[arrayPosition] = number;
				arrayPosition++;
				return true;
			}
		}
		arrayOfNumbers[arrayPosition] = number;
		arrayPosition++;
		return false;
	}
	
	/**
	 * Function blankArray
	 * This function is used to wipe the array, it is used each time the recurvise function is completed
	 * @param array
	 */
	public static void blankArray(int[] array)
	{
		for (int x = 0; x<50; x++)
		{
			array[x] = 0;
		}
		arrayPosition = 0;
	}
	
	/**
	 * Function printArray
	 * Prints all the values of the array before informing user if it is happy or not
	 * @param array
	 * @param total
	 */
	public static void printArray(int[] array, int total) 
	{
		System.out.print(total + ": ");
		for (int x = 0; x<arrayPosition-1; x++)
		{
			System.out.print(array[x] + ", ");
		}
		
		System.out.print(array[arrayPosition-1] + " - ");
	}

	
}


