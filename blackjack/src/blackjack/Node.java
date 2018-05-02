package blackjack;

public class Node {

	public Card input;
	public Node nextLink;
	
	public Node(Card input)
	{
		this.input = input;
	}
	
	public void printChar()
	{
		System.out.print( input );
	}
}
