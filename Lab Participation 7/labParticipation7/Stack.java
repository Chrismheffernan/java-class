package labParticipation7;

/**
 * Class Stack
 * Holds values that are first in last out
 * @author Chris
 *
 */
public class Stack {
	
	private int stackPosition;
	private Card mainArray[];
	
	/**
	 * Constructor class
	 */
	public Stack()
	{
		stackPosition = -1;
		mainArray = new Card[60];
	}
	
	/**
	 * Method push
	 * Pushes values into the stack
	 * @param pushValue - The value used to push into the stack
	 */
	public void push(Card pushValue)
	{
		mainArray[stackPosition+1] = pushValue;
		stackPosition++;
	}
	
	/**
	 * Method pop
	 * Pops the last value added to the stack
	 * @return
	 */
	public Card pop()
	{
		return mainArray[stackPosition--];
	}
	
	/**
	 * Method isEmpty
	 * Determines if the stack is empty or not
	 * @return true if value is empty
	 */
	public boolean isEmpty()
	{
		if(stackPosition == -1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Method size
	 * @return - returns the size of the stack
	 */
	public int size()
	{
		return stackPosition+1;
	}

}
