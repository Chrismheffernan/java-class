package labParticipation3;

import java.util.Scanner;


public class DiceWarGame {
	
	public static int wins = 0;
	public static int games = 0;

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] arguments) {
		
		menu();
		
		
		
	}
	
	/**
	 * Uses a do/while loop with a switch statement to present user a menu
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
	 * Plays the dice game
	 * Records wins and loses as they happen
	 */
	public static void diceGame()
	{
		String choice;
		Player user = new Player("User");
		Player computer = new Player("Computer");
		
		
		do
		{
			user.rollPlayerDice();
			computer.rollPlayerDice();
			
			user.printDice();
			computer.printDice();
			
			if ( user.returnPlayerTotal() > computer.returnPlayerTotal())
			{
				wins++;
				games++;
				System.out.println("Congratulations, you've won! Would you like to play again? ");
				choice = sc.next();
				
			}
			
			else if( user.returnPlayerTotal() < computer.returnPlayerTotal())
			{
				games++;
				System.out.println("I'm sorry, you've lost! Would you like to play again? ");
				choice = sc.next();
			}
			else
			{
				games++;
				System.out.println("Its a tie! Would you like to play again? ");
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
		System.out.println("You've won " + wins + " out of " + games + " games.");
	}
	
	
}
