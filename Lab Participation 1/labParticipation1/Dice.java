package labParticipation1;


import java.util.Random;

public class Dice {
	
	private int rollValue1, rollValue2;
	
	/**
	 * Method rollDice
	 * Assigns two random values to both dice
	 */
	public void rollDice()
	{
		Random r = new Random();
		
		rollValue1 = r.nextInt(6) + 1;
		rollValue2 = r.nextInt(6) +1;
		
	}
	
	/**
	 * Method returnValue1
	 * Returns the value of the first dice
	 * @return
	 */
	public int returnValue1()
	{
		return rollValue1;
	}
	
	/**
	 * Method returnValue2
	 * Returns the value of the second dice
	 * @return
	 */
	public int returnValue2()
	{
		return rollValue2;
	}
	
	/**
	 * Method returnTotal
	 * Returns the value of both the dice
	 * @return
	 */
	public int returnTotal()
	{
		return rollValue1 + rollValue2;
	}
}
