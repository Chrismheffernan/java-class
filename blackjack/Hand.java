package blackjack;


public class Hand {

	private boolean hasWon = false;
	
	private String name;
	
	private int handPosition = 0;
	
	protected Card[] cards = new Card[11];
	
	public void buildHand()
	{
		for( int i = 0; i<11; i++)
		{
			cards[i] = new Card();
		}
	}
	
	public void drawTwoCards(Card[] deck)
	{
		for(int x = 0; x<2; x++)
		{ 
			cards[handPosition] = deck[DeckOfCards.drawCard()];
			handPosition++;
		}
	}
	
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
	}
	
	public void drawCard(Card[] deck)
	{
			cards[handPosition] = deck[DeckOfCards.drawCard()];
			handPosition++;
	}
	
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
	
	public Boolean winner()
	{
		hasWon = true;
		return hasWon;
	}
	
}
