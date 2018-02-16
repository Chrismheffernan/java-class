package blackjack;

import java.util.Random;

import blackjack.Card.FaceType;

public class DeckOfCards 
{
	
	private static int deckPosition = 0;
	private Card[] deck = new Card[52];
	
	
	public void buildDeck()
	{
		for( int i = 0; i<52; i++)
		{
			deck[i] = new Card();
		}
		int cardNumber;
		cardNumber = 0;
		for( Card.Suit suitLoop : Card.Suit.values() )
		{
			for ( int y = 2; y<15; y++ )
			{
				if ( y < 10)
				{
					deck[cardNumber].value = y;
					deck[cardNumber].suit = suitLoop;
					deck[cardNumber].faceType = Card.FaceType.NONE;
					cardNumber++;
				}
				
				if ( y >= 10  & y < 14 )
				{
					for ( Card.FaceType type : Card.FaceType.values() )
					{
						deck[cardNumber].value = 10;
						deck[cardNumber].faceType = type;
						deck[cardNumber].suit = suitLoop;
						cardNumber++;
						y++;
					}
				}
				
				if ( y == 14)
				{
					deck[cardNumber].value = 11;
					deck[cardNumber].faceType = Card.FaceType.ACE;
					deck[cardNumber].suit = suitLoop;
					cardNumber++;
				}
			}
		}
		
		deckPosition = 0;
	}
	
	public void shuffleDeck()
	{
		for( int x =0; x<100; x++)
		{
			Random randa = new Random();
			int  a = randa.nextInt(52);
			Random randb = new Random();
			int  b = randb.nextInt(52);
			
			Card tempCard = new Card();
			
			tempCard = deck[a];
			deck[a]=deck[b];
			deck[b]=tempCard;
		}
		
		deckPosition = 0;
		
	}
	
	public void printDeck()
	{
		for ( int x = 0; x<52; x++ )
		{
			if ( deck[x].faceType == Card.FaceType.NONE )
			{
				System.out.println("Card number " + (x+1) + " is a " + deck[x].value + " of " + deck[x].suit );
			}
			
			else
			{
				System.out.println("Card number " + (x+1) + " is a " + deck[x].faceType + " of " + deck[x].suit );
			}
		}
	}
	
	public static int drawCard()
	{
		deckPosition++;
		return deckPosition-1;
	}
	
	public void drawFourCards()
	{
		for (int x = deckPosition; x <deckPosition+4; x++) 
		{
			if ( deck[x].faceType == Card.FaceType.NONE )
			{
				System.out.println("Card number " + (x+1) + " is a " + deck[x].value + " of " + deck[x].suit );
			}
			
			else
			{
				System.out.println("Card number " + (x+1) + " is a " + deck[x].faceType + " of " + deck[x].suit );
			}
		}
		
		deckPosition = deckPosition + 4;
		
		System.out.println("There are " + (52-deckPosition) + " left in the deck.");
	}
	
	public static int returnPosition()
	{
		return deckPosition;
	}
	
	public Card[] returnDeck()
	{
		return deck;
	}
}
