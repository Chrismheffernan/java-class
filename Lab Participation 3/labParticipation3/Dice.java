package labParticipation3;


import java.util.Random;

public class Dice {
	
	private int rollValue;
	
	public void rollDice() 
	{
		Random r = new Random();
		
		rollValue = r.nextInt(6) + 1;	
	}
	
	public int returnValue()
	{
		return rollValue;
	}
	
}
