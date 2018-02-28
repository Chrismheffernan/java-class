package blackjack;

/**
 * Class Hand
 * A class that can be used to create a set of players hands
 * @author chris
 *
 */
public class Hand {

	private boolean hasWon = false;
	
	private int handPosition = 0;
	
	protected Card[] cards = new Card[11];
	
	/**
	 * Method buildHand
	 * Assigns the maximum number of cards in a hand a place in memory
	 */
	public void buildHand()
	{
		for( int i = 0; i<11; i++)
		{
			cards[i] = new Card();
		}
	}
	
	/**
	 * Method drawTwoCards
	 * Uses the parameter of a array of Cards to assign two consecutive
	 * cards to the players hand.
	 * Adds a value to hand position to keep track of how many cards are in
	 * players hand.
	 * @param deck
	 */
	public void drawTwoCards(Card[] deck)
	{
		for(int x = 0; x<2; x++)
		{ 
			cards[handPosition] = deck[DeckOfCards.drawCard()];
			handPosition++;
		}
	}
	
	/**
	 * Method printHand
	 * Uses the variable handPosition to print out the values of
	 * each card in the players hand.
	 */
	public void printHand()
	{
		for ( int x = 0; x<handPosition; x++ )
		{
			if ( cards[x].faceType == Card.FaceType.NONE )
			{
				System.out.println("Card number " + (x+1) + " is a " + cards[x].value + " of " + cards[x].suit );
			}
			
			else
			{
				System.out.println("Card number " + (x+1) + " is a " + cards[x].faceType + " of " + cards[x].suit );
			}
		}
		System.out.println("\n");
	}
	
	/**
	 * Method drawCard
	 * Assigns the value of the current position of the array of Card
	 * passed through to it.
	 * @param deck
	 */
	public void drawCard(Card[] deck)
	{
			cards[handPosition] = deck[DeckOfCards.drawCard()];
			handPosition++;
	}
	
	/**
	 * Method returnCardValues
	 * Calculates the value of the players hand
	 * takes into account the changing value of an Ace card
	 * @return
	 */
	public int returnCardValues()
	{
		int aceCounter = 0;
		int total = 0;
		for ( int x = 0; x< handPosition+1; x++)
		{
			if ( cards[x].faceType == Card.FaceType.ACE)
			{
				aceCounter++;
				total = total + 1;
			}
			
			total = total + cards[x].value;
		}
		
		while ( total > 21 && aceCounter > 0)
		{
			total = total - 10;
			aceCounter--;
		}
		
		return total;
	}
	
}
