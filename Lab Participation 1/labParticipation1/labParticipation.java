package labParticipation1;
import java.util.Scanner;


public class labParticipation {

	
	
	public static void main(String[] arguments) {
		System.out.println("Hello World!");

		Scanner sc=new Scanner(System.in);
		
		Dice opponent = new Dice();
		Dice userOne = new Dice();
		boolean flag = true;
		while(flag)
		{
			System.out.println("Would you like to play a game? Pres any key to continue: ");
			String choice = sc.next();
		
					
			while ( !choice.equals("N") & !choice.equals("n"))
			{
				userOne.rollDice();
				opponent.rollDice();
				
				System.out.println("You rolled: \t\t " + userOne.returnTotal() + " = " + userOne.returnValue1() + " + " + userOne.returnValue2());
				System.out.println("Your opponent rolled: \t " + opponent.returnTotal() + " = " + opponent.returnValue1() + " + " + opponent.returnValue2());
				
				if ( userOne.returnTotal() > opponent.returnTotal())
				{
					System.out.println("Congratulations, you've won! Would you like to play again? ");
					choice = sc.next();
					
				}
				
				else if( userOne.returnTotal() < opponent.returnTotal())
				{
					System.out.println("I'm sorry, you've lost! Would you like to play again? ");
					choice = sc.next();
				}
				else
				{
					System.out.println("Its a tie! Would you like to play again? ");
					choice = sc.next();
				}
			}
			System.out.println("Thanks for playing!");
			flag = false;
			
			sc.close();
		}
		
	}
}
