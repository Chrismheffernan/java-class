package labParticipation3;


import java.util.Random;

public class Dice {
	
	private int rollValue;
	
	/**
	 * Method rollDice
	 * Uses Random to assign a value to the dice
	 */
	public void rollDice() 
	{
		Random r = new Random();
		
		rollValue = r.nextInt(6) + 1;	
	}
	
	/**
	 * Method returnValue
	 * Returns the value of the die
	 * @return
	 */
	public int returnValue()
	{
		return rollValue;
	}
	
}
