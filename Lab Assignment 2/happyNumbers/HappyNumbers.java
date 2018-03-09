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
			if( number == 0 )
			{
				inUse = false;
			}
			
			if (happyCheck(number))
			{
				System.out.println("This number is happy!");
			}
			else
			{
				System.out.println("This number is not happy.");
			}
			
			
			
			
		}
		
	}
	
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
		
		System.out.println(total);
		
		if(arrayChecker(total))
		{
			return false;
		}
		
		
		if( total == 1 || happyCheck(total))
		{
			return true;
		}
		
		
		
		blankArray(arrayOfNumbers);
		return false;
		
		
	}
	
	public static boolean arrayChecker(int number)
	{
		for(int x = 0; x < arrayPosition + 1; x++)
		{
			if( arrayOfNumbers[x] == number)
			{
				return true;
			}
		}
		arrayOfNumbers[arrayPosition] = number;
		arrayPosition++;
		return false;
	}
	
	public static void blankArray(int[] array)
	{
		for (int x = 0; x<50; x++)
		{
			array[x] = 0;
		}
	}

	
}


