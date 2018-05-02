package labAssignment5;

public class Node {

	private int value;
	private Node leftChild;
	private Node rightChild;
	
	/**
	 * Class initilization
	 * @param value - value held by the node
	 */
	Node( int value )
	{
		this.value = value;
		
	}
	
	/**
	 * Method setRight
	 * Sets the node's place in memory
	 * @param right - new place in memory
	 */
	public void setRight(Node right)
	{
		rightChild = right;
	}
	
	/**
	 * Method setLeft
	 * Sets the node's place in memory
	 * @param left - new place in memory
	 */
	public void setLeft(Node left)
	{
		leftChild = left;
	}
	
	/**
	 * Method getValue
	 * @return - the value of the node
	 */
	public int getValue()
	{
		return value;
	}
	
	/**
	 * getRight
	 * @return - the position in memory of the rightChild
	 */
	public Node getRight()
	{
		return rightChild;
	}
	
	/**
	 * getLeft
	 * @return - the position in memory of the leftChild
	 */
	public Node getLeft()
	{
		return leftChild;
	}
}
