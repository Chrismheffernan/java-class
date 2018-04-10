package labAssignment4;

public class LinkList {

	private int count;
	private Node first;
	private Node last = null;
	
	public LinkList()
	{
		first = null;
		count = 0;
	}
	
	public boolean isEmpty()
	{
		if ( first == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public void addLink(char input, int position)
	{
		Node node = new Node(input);
		
		if( position == 0)
		{
			node.nextLink = first;
			first = node;
			count++;
		}
	
		else
		{
			Node runner = first;
			for( int x = 1; x<position; x++)
			{
				runner = runner.nextLink;
			}
			node.nextLink = runner.nextLink;
			runner.nextLink = node;
			count++;
		}
		
	}
	
	public Node removeLink(int position)
	{
		Node current = null;
		
		if(position >= count)
		{
			return current;
		}
		if(position == 0)
		{
			current=first;
			first=first.nextLink;
			count--;
		}
		else
		{
			Node runner = first;
			for( int x = 1; x< position; x++)
			{
				runner=runner.nextLink;
			}
			current = runner.nextLink;
			runner.nextLink = runner.nextLink.nextLink;
			count--;
		}
		
		return current;
	}
	
	public int returnSize()
	{
		return count;
	}
	
	public char displayNode(int position)
	{
		Node runner = first;
		for( int x = 1; x < position; x++)
		{
			runner = runner.nextLink;
		}
		
		return runner.input;
	}
	
	
	public String displayList()
	{
		Node current = first;
		String display = "";
		
		while( current != null)
		{
			display = display + current.input;
			current = current.nextLink;
		}
		
		return display;
		
	}
	

}
