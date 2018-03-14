package labParticipation2;

import java.util.Scanner;


public class labParticipation {
	
	public static int wins = 0;
	public static int games = 0;

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] arguments) {
		
		menu();
		
		
		
	}
	
	/**
	 * Function menu
	 * Uses a do while loop to display the menu
	 */
	public static void menu ()
	{
		int choice;
		
		do
		{
			System.out.println("1 - Play Dice War Game");
			System.out.println("2 - Display statistics");
			System.out.println("3 - Quit");
			choice = sc.nextInt();
			
			switch(choice)
			{
				case 1: diceGame();
					break;
				
				case 2: stats();
					break;
				
				case 3: 
					break;
								
			
			}
		} while(choice != 3);
		
		System.out.println("Thanks for playing!");
	}
	
	/**
	 * Function diceGame
	 * Plays the dice game
	 */
	public static void diceGame()
	{
		String choice;
		Dice opponent = new Dice();
		Dice userOne = new Dice();
		
		do
		{
			userOne.rollDice();
			opponent.rollDice();
			
			System.out.println("You rolled: \t\t " + userOne.returnTotal() + " = " + userOne.returnValue1() + " + " + userOne.returnValue2());
			System.out.println("Your opponent rolled: \t " + opponent.returnTotal() + " = " + opponent.returnValue1() + " + " + opponent.returnValue2());
			
			if ( userOne.returnTotal() > opponent.returnTotal())
			{
				wins++;
				games++;
				System.out.println("Congratulations, you've won! Would you like to play again? N/n to quit: ");
				choice = sc.next();
				
			}
			
			else if( userOne.returnTotal() < opponent.returnTotal())
			{
				games++;
				System.out.println("I'm sorry, you've lost! Would you like to play again? N/n to quit: ");
				choice = sc.next();
			}
			else
			{
				games++;
				System.out.println("Its a tie! Would you like to play again? N/n to quit: ");
				choice = sc.next();
			}
		} while(!choice.equals("N") & !choice.equals("n"));
	}
	
	/**
	 * Uses data gained from diceGame
	 * to display how many games the user has won
	 */
	public static void stats()
	{
		System.out.println("You've won " + wins + " out of " + games + " games.\n");
	}
	
	
}
