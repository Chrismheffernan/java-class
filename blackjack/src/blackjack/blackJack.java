package blackjack;

import java.util.Scanner;

public class blackJack 
{

	static Scanner sc = new Scanner(System.in);
	
	
	
	public static void main(String[] args) 
	{
		
		menu();
		
		
		
	}
	
	public static void menu()
	{
		int choice;
		DeckOfCards deck = new DeckOfCards();
		do 
		{
			System.out.println("Please select an option: ");
			System.out.println("1 - Create a new Deck");
			System.out.println("2 - Deal 4 cards and show the number of remainer cards");
			System.out.println("3 - Shuffle the cards and show the cards");
			System.out.println("4 - Play the Blackjack game");
			choice = sc.nextInt();
			
			switch(choice)
			{
				case 1: deck.buildDeck();
					break;
				
				case 2: deck.drawFourCards();
					break;
				
				case 3: shuffleDeck(deck);
					break;
					
				case 4: 
					playBlackJack(deck);
					break;
				
			
			}
		}while(true);
	}
	
	public static DeckOfCards shuffleDeck(DeckOfCards deck)
	{
		deck.buildDeck();
		deck.shuffleDeck();
		deck.printDeck();
		return deck;
	}



	public static void playBlackJack(DeckOfCards deck)
	{
		boolean playing = true;
		int[] playerFunds = new int[1];
		playerFunds[0]=100;
		
		int toBet = 0;
		
		
		
		
		
		while(playerFunds[0] > 0 & playing)
		{
			deck.buildDeck();
			deck.shuffleDeck();
			System.out.println("Deck has been shuffled");
			while (DeckOfCards.returnPosition() < 32 & playing)
			{
				
				if( playerFunds[0] <= 0)
				{
					break;
				}
				Hand user = new Hand();
				dealerHand dealer = new dealerHand();
				user.buildHand();
				dealer.buildHand();
				
				System.out.println("You have $" + playerFunds[0] + ". How much would you like to bet? Enter 0 to quit: ");
				toBet = sc.nextInt();
				
				while (toBet < 0)
				{
					
					System.out.print("Must enter a value bigger than 0 to bet. Or 0 to quit: ");
					toBet = sc.nextInt();
				}
				
				if(toBet == 0)
				{
					
					playing = false;
					break;
				}
				
				dealer.drawTwoCards(deck.returnDeck());
				user.drawTwoCards(deck.returnDeck());
				
				System.out.println("The user has " + user.returnCardValues() + " with: ");
				user.printHand();
				
				dealer.returnDealersValue();
				dealer.printDealersHand();
				
				while((user.returnCardValues() < 21 && dealer.returnCardValues() < 21) )
				{
					boolean hit = true;
					String check;
					
					
					while(hit && user.returnCardValues() < 21)
					{
						System.out.println("Would you like to hit? Y/N");
						check = sc.next();
						if(check.equals("Y") || check.equals("y"))
						{
							user.drawCard(deck.returnDeck());
							System.out.println("The user has " + user.returnCardValues() + " with: " );
							user.printHand();
						}
						else
						{
							hit = false;
						}
					}
					
					while( dealer.returnCardValues() < 17)
					{
						dealer.drawCard(deck.returnDeck());
						
					}
					System.out.println("The dealer has " + dealer.returnCardValues() + " with: ");
					dealer.printHand();
					
					break;
					
				}
				
				playerFunds[0]=playerFunds[0]+winner(user, dealer, toBet);
					
			}
			
			
			
			
		}
		
		if(playerFunds[0] <= 0)
		{
			System.out.println("You've run out of money, thanks for playing!");
		}
		else
		{
			System.out.println("Thanks for playing!");
		}
	}
	
	
	public static int winner(Hand user, Hand dealer, int bet)
	{
		if (user.returnCardValues() > 21)
		{
			System.out.println("Sorry, you lost!");
			return bet*-1;
		}
		else if (dealer.returnCardValues() > 21)
		{
			System.out.println("Congrats, you won!");
			return bet;
		}
		else if (user.returnCardValues() > dealer.returnCardValues())
		{
			System.out.println("Congrats, you won!");
			return bet;
		}
		else if (user.returnCardValues() == dealer.returnCardValues())
		{
			System.out.println("Tie!");
			return 0;
		}
		else
		{
			System.out.println("Sorry, you lost!");
			return bet*-1;
		}
	}
	
	
	

}


