package labAssignment4;

public class Node {

	public char input;
	public Node nextLink;
	
	public Node(char input)
	{
		this.input = input;
	}
	
	public void printChar()
	{
		System.out.print( input );
	}
}
