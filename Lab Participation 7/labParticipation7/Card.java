package labParticipation7;

import blackjack.Card.Suit;

/**
 * Class Card
 * A class of Card that holds a set of values
 * @author chris
 *
 */
public class Card {
	
	/**
	 * Creates a variable type Suit with 4 variables
	 * Diamonds, Spades, Hearts, Clubs
	 * @author chris
	 *
	 */
	public enum Suit
	{
		DIAMONDS
		{
		      public String toString() 
		      {
		          return "Diamonds";
		      }
		},
		SPADES
		{
		      public String toString() 
		      {
		          return "Spades";
		      }
		},
		HEARTS
		{
		      public String toString() 
		      {
		          return "Hearts";
		      }
		},
		CLUBS
		{
		      public String toString() 
		      {
		          return "Clubs";
		      }
		};
	}
	
	public int value;

	public Suit suit;
	
	public FaceType faceType;
	
	/**
	 * Creates a variable FaceType with 5 variables
	 * None, Jack, Queen, King, Ace
	 * @author chris
	 *
	 */
	enum FaceType
	{
		NONE,
		JACK
		{
		      public String toString() 
		      {
		          return "Jack";
		      }
		},
		QUEEN
		{
		      public String toString() 
		      {
		          return "Queen";
		      }
		},
		KING
		{
		      public String toString() 
		      {
		          return "King";
		      }
		},
		ACE
		{
		      public String toString() 
		      {
		          return "Ace";
		      }
		};
	}


}
