package blackjack;

import java.util.Random;

import blackjack.Card.FaceType;

/**
 * Class DeckOfCards
 * A class that holds an array of 52 Cards
 * @author chris
 *
 */
public class DeckOfCards 
{
	private boolean deckBuilt = false;
	private static int deckPosition = 0;
	private LinkList deck = new LinkList();
	private Node nodePosition = deck.returnFirst();
	
	
	/**
	 * method buildDeck
	 * Assigns each card in the deck a place in memory
	 * Then utilizes the enumerations for suit and faceType to create 
	 * each unique card in the deck
	 */
	public void buildDeck()
	{
		Card tempCard = new Card();
		int cardNumber;
		cardNumber = 0;
		for( Card.Suit suitLoop : Card.Suit.values() )
		{
			for ( int y = 2; y<15; y++ )
			{
				if ( y < 10)
				{
					tempCard.value = y;
					tempCard.suit = suitLoop;
					tempCard.faceType = Card.FaceType.NONE;
					deck.addLink(tempCard, 0);
					cardNumber++;
				}
				
				if ( y >= 10  & y < 14 )
				{
					for ( Card.FaceType type : Card.FaceType.values() )
					{
						tempCard.value = 10;
						tempCard.faceType = type;
						tempCard.suit = suitLoop;
						deck.addLink(tempCard, 0);
						cardNumber++;
						y++;
					}
				}
				
				if ( y == 14)
				{
					tempCard.value = 11;
					tempCard.faceType = Card.FaceType.ACE;
					tempCard.suit = suitLoop;
					deck.addLink(tempCard, 0);
					cardNumber++;
				}
			}
		}
		
		deckPosition = 0;
		deckBuilt = true;
	}
	
	/**
	 * Method shuffleDeck
	 * Uses a random number generator to shuffle the cards in the deck
	 */
	public void shuffleDeck()
	{
		for( int x =0; x<100; x++)
		{
			Random randa = new Random();
			int  a = randa.nextInt(52-deckPosition) + deckPosition;
			Random randb = new Random();
			int  b = randb.nextInt(52-deckPosition) + deckPosition;
			
			Card tempCard = new Card();
			
			tempCard = deck.displayNode(a);
			deck.removeLink(a);
			deck.addLink(tempCard, b);
		
		}
		
	}
	
	/**
	 * Method printDeck
	 * Prints out the information for each card in the deck,
	 * in their current order
	 */
	public void printDeck()
	{
		Node tempCard = deck.returnFirst();
		
		for ( int x = deckPosition; x<52; x++ )
		{
			
			if ( deck.displayNode(x).faceType == Card.FaceType.NONE )
			{
				System.out.println("Card number " + (x+1) + " is a " + deck.displayNode(x).value + " of " + deck.displayNode(x).suit );
			}
			
			else
			{
				System.out.println("Card number " + (x+1) + " is a " + deck.displayNode(x).faceType + " of " + deck.displayNode(x).suit );
			}
			
			tempCard = tempCard.nextLink;
		}
		System.out.println("\n");
	}
	
	/**
	 * Method drawCard
	 * This method is used to find which card to draw in the deck
	 * It is effectively the top of the deck
	 * @return
	 */
	public static int drawCard()
	{
		deckPosition++;
		return deckPosition-1;
	}
	
	/**
	 * Method drawFourCards
	 * This method is used to act out one of the menu options
	 * It prints out the top four cards in the deck
	 */
	public int drawFourCards()
	{
		if (deckBuilt == false)
		{
			System.out.println("No deck has been created yet, please build a deck first.");
			return 0;
		}
		for (int x = deckPosition; x <deckPosition+4; x++) 
		{
			if ( deck.displayNode(x).faceType == Card.FaceType.NONE )
			{
				System.out.println("Card number " + (x+1) + " is a " + deck.displayNode(x).value + " of " + deck.displayNode(x).suit );
			}
			
			else
			{
				System.out.println("Card number " + (x+1) + " is a " + deck.displayNode(x).faceType + " of " + deck.displayNode(x).suit );
			}
		}
		deckPosition = deckPosition + 4;
		
		System.out.println("There are " + (52-deckPosition) + " left in the deck.\n");
		return 0;
	}
	
	/**
	 * Method returnPosition
	 * This method is used to determine how many cards are left
	 * in the deck
	 * @return
	 */
	public static int returnPosition()
	{
		return deckPosition;
	}
	
	/**
	 * Method returnDeck
	 * This method is used to pass the deck of cards through
	 * to other methods.
	 * @return
	 */
	public LinkList returnDeck()
	{
		return deck;
	}
}
