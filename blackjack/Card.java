package blackjack;

import blackjack.Card.Suit;

public class Card {
	
	public enum Suit
	{
		DIAMONDS
		{
		      public String toString() 
		      {
		          return "diamonds";
		      }
		},
		SPADES
		{
		      public String toString() 
		      {
		          return "spades";
		      }
		},
		HEARTS
		{
		      public String toString() 
		      {
		          return "hearts";
		      }
		},
		CLUBS
		{
		      public String toString() 
		      {
		          return "clubs";
		      }
		};
	}
	
	public int value;

	public Suit suit;
	
	public FaceType faceType;
	
	enum FaceType
	{
		NONE,
		JACK
		{
		      public String toString() 
		      {
		          return "jack";
		      }
		},
		QUEEN
		{
		      public String toString() 
		      {
		          return "queen";
		      }
		},
		KING
		{
		      public String toString() 
		      {
		          return "king";
		      }
		},
		ACE
		{
		      public String toString() 
		      {
		          return "ace";
		      }
		};
	}


}
