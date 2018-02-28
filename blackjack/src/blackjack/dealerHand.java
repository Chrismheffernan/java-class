package blackjack;

/**
 * Class dealerHand
 * This is a inheritance class
 * This class is used to display the dealers initial two cards and their value
 * @author chris
 *
 */
public class dealerHand extends Hand {

	/**
	 * Method printDealersHand
	 * Prints the first card in the dealers hand,
	 * obscures the second
	 */
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
		
		System.out.println("Card number 2 is a xxxxx of xxxxx\n");
		
	}
	
	/**
	 * Method returnDealersValue
	 * Prints out the value of only the first card
	 */
	public void returnDealersValue()
	{
		System.out.println("The value of the dealers showing card is " + cards[0].value);
	}
	
}
