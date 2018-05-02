package labAssignment5;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		
		menu();

	}

	/**
	 * Function menu
	 * Displays menu list with selection for the program functions 
	 */
	public static void menu()
	{
		
		BinaryTree tree = new BinaryTree();

		
		int choice;
		
		
		do {
		
			System.out.println("1 - Add item to tree");
			System.out.println("2 - Delete item from tree");
			System.out.println("3 - Find item");
			System.out.println("4 - Balance Tree");
			System.out.println("5 - List content of tree");
			System.out.println("6 - Display Statistics");
			System.out.println("7 - Quit");
			
			choice = sc.nextInt();
			
			switch(choice)
			{
				case 1: addItem(tree);
					break;
				
				case 2: 
					deleteItem(tree);
					break;
				
				case 3: 
					findItem(tree);
					break;
				case 4:
					startBalancedTree(tree);
					break;
				case 5:
					listContent(tree);
					break;
				case 6:
					displayStats(tree);
					break;
				case 7:
					break;
		
			}
		} while( choice != 7);
	}
	
	/**
	 * Function startBalancedTree
	 * Function used to dynamically declare the size of an appropriate array
	 * Uses the array to deconstruct and rebuild a balanced array
	 * @param tree The binary tree used in the program
	 */
	public static void startBalancedTree(BinaryTree tree)
	{
		int[] tempArray = new int[tree.getNumOfItems()];
		tempArray = tree.preBuildContents();
			
		tree.deleteTree(tree.getRoot());
		
		
		
		tree.setRoot(tree.setBalancedTree(tempArray, 0, tempArray.length-1));
	}

	
	/**
	 * Function addItem
	 * Function used to call addNode method in BinaryTree
	 * @param tree The binary tree used in the program
	 */
	public static void addItem(BinaryTree tree)
	{
		int value;
		
		System.out.println("Please enter a number value to add to the binary tree: ");
		value = sc.nextInt();
		while(tree.depth(tree.getRoot()) != 0 && tree.findItem(value) != -1)
		{
			System.out.println("Value already in binary tree, please enter a new value: ");
			value=sc.nextInt();
		}
		
		tree.addNode(value);
	}
	
	/**
	 * Function deleteItem
	 * Function used to call the deleteNode method in the BinaryTree class
	 * @param tree The binary tree used in the program
	 */
	public static void deleteItem(BinaryTree tree)
	{
		int value;
		
		System.out.println("Please enter a number you would like to delete from the binary tree: ");
		value= sc.nextInt();
		
		if(tree.deleteNode(value))
		{
			System.out.println(value + " was deleted from the binary tree.");
		}
		else
		{
			System.out.println(value + " was not found in the binary tree.");
		}
	}
	
	/**
	 * Function findItem
	 * Function used to call the findItem method in the BinaryTree class
	 * @param tree The binary tree used in the program
	 */
	public static void findItem(BinaryTree tree)
	{
		int value;
		
		System.out.println("Please enter a number to find what level the item is on: ");
		value = sc.nextInt();
		
		if( tree.findItem(value) == -1)
		{
			System.out.println("Value searched for was not found in the binary tree.");
		}
		else
		{
			System.out.println("Value searched for is located on level " + tree.findItem(value) + " of the binary tree.");
		}
	}
	
	/**
	 * Function listContent
	 * Function used to call the preBuildContent method in the BinaryTree class
	 * Displays the content of the binary tree in order
	 * @param tree The binary tree used in the program
	 */
	public static void listContent(BinaryTree tree)
	{
		
		System.out.println("The contents of your binary tree are as follows: " + Arrays.toString(tree.preBuildContents()));
	}
	
	/**
	 * Function displayStats
	 * Function used to display the value of the root node, the depth of the tree, and the number of items in the tree
	 * @param tree The binary tree used in the program
	 */
	public static void displayStats(BinaryTree tree)
	{
		if(tree.getRoot() == null)
		{
			System.out.println("Binary tree is currently empty");
		}
		else	
		{
			System.out.println("The root value of the tree is: " + tree.getRoot().getValue());
			System.out.println("The depth of the tree is: " + tree.depth(tree.getRoot()));
			System.out.println("There are " + tree.getNumOfItems() + " items in the tree.");
		}
	}
}
