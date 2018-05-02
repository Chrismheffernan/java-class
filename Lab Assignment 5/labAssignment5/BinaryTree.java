package labAssignment5;

public class BinaryTree {

	private Node root;
	private int numOfItems = 0;
	private int arrayPosition = 0;
	
	/**
	 * Method addNode
	 * Method used to add a node to the proper position on the binary tree
	 * @param value - Value that the user wants to add to the tree
	 */
	public void addNode(int value)
	{
		Node newNode = new Node(value);
		
		if( root == null)
		{
			root = newNode;
			numOfItems++;
		}
		else
		{
			Node temp = root;
			Node parent;
			
			//Determines where to add the value using a loop that breaks with a null value is found
			while(true)
			{
				parent = temp;
				if(value < temp.getValue())
				{
					temp = temp.getLeft();
					
					if(temp == null)
					{
						parent.setLeft(newNode);
						numOfItems++;
						return;
					}
				}
				else
				{
					temp = temp.getRight();
					
					if( temp == null)
					{
						parent.setRight(newNode);
						numOfItems++;
						return;
					}
				}
			}
		}
	}
	
	/**
	 * Method preBuildContents
	 * Constructs a dynamic array that depends on the current size of the binary tree
	 * Calls the buildContents method to assign values in order to the array
	 * @return array of binary trees values in order
	 */
	public int[] preBuildContents()
	{
		int[] contentArray = new int[numOfItems];
		
		
		buildContents(root, contentArray);
		
		arrayPosition = 0;
		
		return contentArray;
	}
	/**
	 * Method buildContents
	 * Recursively goes through the contents of a tree in the order in which the values rise
	 * Creates an array of the values in the tree in order
	 * @param tempNode - a temp value used to pass recursive values
	 * @param contentArray - a dynamically created array that holds as many values as are in the binary tree
	 */
	public void buildContents(Node tempNode, int[] contentArray)
	{
	
		
		if(tempNode == null)
		{
			return;
		}
			
		buildContents(tempNode.getLeft(), contentArray);
		
		contentArray[arrayPosition++] = tempNode.getValue();
		
		
		buildContents(tempNode.getRight(), contentArray);

	}
	

	
	/**
	 * Method findItem
	 * Uses the basic structure of a binary tree to decide which path to search for a node
	 * @param searchValue - value used to search in tree
	 * @return return the Node that holds the searched for value
	 */
	public int findItem(int searchValue)
	{
		int level = 0;
		Node tempNode = root;
		
		while(tempNode.getValue() != searchValue)
		{
			if ( searchValue < tempNode.getValue())
			{
				tempNode = tempNode.getLeft();
				level++;
			}
			
			else
			{
				tempNode = tempNode.getRight();
				level++;
			}
			
			if(tempNode == null)
			{
				return -1;
			}
		}
		
		return level+1;
	}
	
	/**
	 * Method depth
	 * Recursively determines the depth of deepest part of a tree
	 * @return returns the depth of the tree
	 */
	public int depth(Node root)
	{
		if( root == null)
		{
			return 0;
		}
		
		if( root.getLeft() == null && root.getRight() == null)
		{
			return 1;
		}
		
		if(root.getLeft() == null)
		{
			return depth(root.getRight()) + 1;
		}
		
		if(root.getRight() == null)
		{
			return depth(root.getLeft()) + 1;
		}
		
		return Math.max(depth(root.getLeft()), depth(root.getRight())) + 1;
	}
	
	/**
	 * Method getRoot
	 * @return the pointer for the root node
	 */
	public Node getRoot()
	{
		return root;
	}
	
	/**
	 * Method getNumOfItems
	 * @return the number of items in the binary tree
	 */
	public int getNumOfItems()
	{
		return numOfItems;
	}
	
	/**
	 * Method setRoot
	 * Used by the balancing function in Main to set values of the new balanced tree
	 * @param root - a new value for root for the binary tree to set
	 */
	public void setRoot(Node root)
	{
		this.root = root;
	}
	
	/**
	 * Method deleteNode
	 * Finds the location of a node in the binary tree and deletes it
	 * assigning the proper pointers to the nodes around it
	 * @param value - value of the node wished to be deleted
	 * @return - a boolean value of whether the node was found and deleted or not
	 */
	public boolean deleteNode(int value)
	{
		Node temp = root;
		Node parent = root;
		
		boolean isItLeft = true;
		
		//Runs through binary tree to see if the value of the node is found
		while( temp.getValue() != value)
		{
			parent = temp;
			
			if( value < temp.getValue())
			{
				isItLeft = true;
				temp = temp.getLeft();
			}
			else
			{
				isItLeft = false;
				temp = temp.getRight();
			}
			
			if(temp == null)
			{
				return false;
			}
		}
		
		//Next four ifs determine how to move around nodes to ensure a properly functioning binary tree
		if(temp.getLeft() == null && temp.getRight() == null)
		{
			if( temp == root)
			{
				root = null;
			}
			else if(isItLeft)
			{
				parent.setLeft(null);
			}
			else
			{
				parent.setRight(null);
			}
		}
		else if(temp.getRight() == null)
		{
			if( temp == root)
			{
				root = temp.getLeft();
			}
			else if(isItLeft)
			{
				parent.setLeft(temp.getLeft());
			}
			else
			{
				parent.setRight(temp.getLeft());
			}
		}
		else if(temp.getLeft() == null)
		{
			if( temp == root)
			{
				root = temp.getRight();
			}
			else if(isItLeft)
			{
				parent.setLeft(temp.getRight());
			}
			else
			{
				parent.setRight(temp.getLeft());
			}
		}
		else
		{
			Node replace = getReplacement(temp);
			
			if( temp == root)
			{
				root = replace;
			}
			else if(isItLeft)
			{
				parent.setLeft(replace);
			}
			else
			{
				parent.setRight(replace);
			}
			
			replace.setLeft( temp.getLeft() );
		}
		
		numOfItems--;
		return true;
	}
	
	/**
	 * Method getReplacement
	 * This method determines which node should be moved in place of the deleted node
	 * @param temp - the node which needs to be determined
	 * @return the proper replacement node
	 */
	public Node getReplacement( Node temp)
	{
		Node replacementParent = temp;
		Node replace = temp;
		
		Node focus = temp.getRight();
		
		while( focus != null)
		{
			replacementParent = replace;
			replace = focus;
			focus = focus.getLeft();
		}
		
		if(replace != temp.getRight())
		{
			replacementParent.setLeft(replace.getRight());
			replace.setRight(temp.getRight());
		}
		
		return replace;
	}
	
	
	
	/**
	 * Method deleteTree
	 * Used to wipe a tree when balancing the tree
	 * @param root Where to start the deletion process
	 */
	public void deleteTree(Node root)
	{
		if ( root == null)
		{
			return;
		}
		
		deleteTree(root.getLeft());
		deleteTree(root.getRight());
		
		root = null;
	}
	
	/**
	 * Method setBalancedTree
	 * Recursively determines how the balanced tree should be created with an array
	 * @param array - the array used to determine how the tree should be created
	 * @param start - the start of the array, important for the recursive function
	 * @param end - the end of the array, important for the recursive function
	 * @return - returns the node back to the BinaryTree, creating a balanced array
	 */
	public Node setBalancedTree(int[] array, int start, int end)
	{
		if ( start > end) 
		{
			return null;
		}
		
		int middle = ( start + end)/2;
		Node root = new Node(array[middle]);
		
		root.setLeft(setBalancedTree(array, start, middle-1));
		root.setRight(setBalancedTree(array, middle+1, end));
		
		return root;
		
		
	}
}
