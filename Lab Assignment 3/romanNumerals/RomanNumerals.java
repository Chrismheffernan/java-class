package romanNumerals;

import java.util.Scanner;

public class RomanNumerals {

	public static void main(String[] args) {
		
		
		
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("Please enter two roman numerals surrounded by either a +, -, or *, separated by spaces: 0 to quit ");
			String str = sc.nextLine();
			if( str.equals("0") )
			{
				break;
			}
			String[] romanOperation = str.split("\\s+");
			Numeral num1 = new Numeral(romanOperation[0]);
			Numeral num2 = new Numeral(romanOperation[2]);
			while( num1.isValid() || num2.isValid())
			{
				System.out.println("Invalid entry");
				System.out.println("Please enter two roman numerals surrounded by either a +, -, or *, separated by spaces: 0 to quit ");
				str = sc.nextLine();
				if( str.equals("0") )
				{
					break;
				}
				romanOperation = str.split("\\s+");
				num1 = new Numeral(romanOperation[0]);
				num2 = new Numeral(romanOperation[2]);
			}
		
			
			if(romanOperation[1].equals("+"))
			{
				int sum = num1.printArabic() + num2.printArabic();
				Numeral num3 = new Numeral(sum);
				System.out.println(str + " = " + num3.printRoman());
			}
			
			if(romanOperation[1].equals("-"))
			{
				int difference = num1.printArabic() - num2.printArabic();
				Numeral num3 = new Numeral(difference);
				System.out.println(str + " = " + num3.printRoman());
			}
			
			if(romanOperation[1].equals("*"))
			{
				int product = num1.printArabic() * num2.printArabic();
				Numeral num3 = new Numeral(product);
				System.out.println(str + " = " + num3.printRoman());
			}
			
			
		}
		System.out.println("Thanks for using!");
		sc.close();

	}
	
	

}
