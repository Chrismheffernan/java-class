package labParticipation3;

public class Player {

	private String player;
	Dice dice[] = new Dice[2];
	
	/**
	 * Default constructor, assigns memory to array of dice
	 * Sets the players name
	 * @param user The players name
	 */
	public Player(String user)
	{
		player = user;
		for (int x = 0; x<2; x++)
		{
			dice[x]=new Dice();
		}
	}
	

	
	
	
	/**
	 * Initializes the value of the dice
	 */
	public void rollPlayerDice()
	{
		
		dice[0].rollDice();
		dice[1].rollDice();
		
	}
	
	public int returnPlayerTotal()
	{
		int total = 0;
		
		total = dice[0].returnValue() + dice[1].returnValue();
		
		return total;
	}
	
	public void printDice()
	{
		System.out.println(player + " has a total of " + returnPlayerTotal() + " with a " + dice[0].returnValue() + " and " + dice[1].returnValue());
	}
}
