package romanNumerals;

public class Stack {
	
	private int stackPosition;
	private String mainArray[];
	
	public Stack()
	{
		stackPosition = -1;
		mainArray = new String[60];
	}
	
	public void push(String pushValue)
	{
		mainArray[stackPosition+1] = pushValue;
		stackPosition++;
	}
	
	public String pop()
	{
		return mainArray[stackPosition--];
	}
	
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
	
	public int size()
	{
		return stackPosition+1;
	}

}
