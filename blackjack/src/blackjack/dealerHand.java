package blackjack;



public class dealerHand extends Hand {

	public void printDealersHand()
	{
		
		if ( cards[0].faceType == Card.FaceType.NONE )
		{
			System.out.println("Card number " + (1) + " is a " + cards[0].value + " of " + cards[0].suit );
		}
		
		else
		{
			System.out.println("Card number " + (1) + " is a " + cards[0].faceType + " of " + cards[0].suit );
		}
		
		System.out.println("Card number 2 is a xxxxx of xxxxx");
		
	}
	
	public void returnDealersValue()
	{
		System.out.println("The value of the dealers showing card is " + cards[0].value);
	}
	
}
