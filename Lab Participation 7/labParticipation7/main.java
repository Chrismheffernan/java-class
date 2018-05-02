package labParticipation7;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		String value;
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Stack Testing Program");
		
		System.out.println("Press any key to start: ");
		value = sc.next();
		while(!value.equals("N") && !value.equals("n"))
		{
			drawFive();
			System.out.println("Would you like to run the program again? (Y/N)");
			value = sc.next();
		}

	}
	
	/**
	 * Function drawFive
	 * Pushes 5 cards into a stack and then pop them all out
	 */
	public static void drawFive()
	{
		
		DeckOfCards mainDeck = new DeckOfCards();
		mainDeck.shuffleDeck();
		
		Stack hand = new Stack();
		Card tempCard = new Card();
		
		for( int x = 0; x < 5; x++)
		{
			
			tempCard = mainDeck.drawCard();
			hand.push(tempCard);
			
			if( tempCard.faceType.equals(Card.FaceType.NONE))
			{
				System.out.println(x+1 + "- pushing " + tempCard.value + " of " + tempCard.suit);
			}
			
			else
			{
				System.out.println(x+1 + "- pushing " + tempCard.faceType + " of " + tempCard.suit);
			}
			
		}
		
		for( int x = 0; x < 5; x++)
		{
			tempCard = hand.pop();
			
			if( tempCard.faceType.equals(Card.FaceType.NONE))
			{
				System.out.println(x+1 + "- poping " + tempCard.value + " of " + tempCard.suit);
			}
			
			else
			{
				System.out.println(x+1 + "- poping " + tempCard.faceType + " of " + tempCard.suit);
			}
		}
	}

}
