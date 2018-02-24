package labParticipation2;


import java.util.Random;

public class Dice {
	
	private int rollValue1, rollValue2;
	
	public void rollDice()
	{
		Random r = new Random();
		
		rollValue1 = r.nextInt(6) + 1;
		rollValue2 = r.nextInt(6) +1;
		
	}
	
	
	public int returnValue1()
	{
		return rollValue1;
	}
	
	public int returnValue2()
	{
		return rollValue2;
	}
	
	public int returnTotal()
	{
		return rollValue1 + rollValue2;
	}
}
