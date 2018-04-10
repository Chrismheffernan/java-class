package labAssignment4;

import java.util.Scanner;

public class LabAssignment4 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		menu();
		

	}
	
	public static void menu()
	{
		LinkList newList = new LinkList();
		int choice;
		boolean listCreated = false;
		
		do {
		
			System.out.println("1 - Create an empty list");
			System.out.println("2 - Insert a node to the list in any position");
			System.out.println("3 - Remove a node at any position in the list");
			System.out.println("4 - Display the size of the list");
			System.out.println("5 - Display the information stored at a particular node");
			System.out.println("6 - Show list's data");
			System.out.println("7 - Process Roman number expressions");
			System.out.println("8 - Quit");
			
			choice = sc.nextInt();
			
			switch(choice)
			{
				case 1: newList = new LinkList();
					listCreated = true;
					break;
				
				case 2: 
					insertNode(newList);
					break;
				
				case 3: 
					removeNode(newList);
					break;
				case 4:
					System.out.println("The size of your list is: " +  newList.returnSize() );
					break;
				case 5:
					displayNode(newList);
					break;
				case 6:
					System.out.println ("The list currently holds: " + newList.displayList() );
					break;
				case 7:
					break;
				case 8:
					break;
			
			}
		} while( choice != 8);
	}
	
	public static void displayNode(LinkList newList)
	{
		int position;
		System.out.println("Please enter the position of the node you wish to view");
		System.out.println("0 is the left most node. Please "
				+ "do not enter a position bigger than the lists current size, which is: " + (newList.returnSize()-1) );
		position = sc.nextInt();
		while( position > newList.returnSize() || position < 0)
		{
			System.out.println("Please enter a number between 0 and " + (newList.returnSize()-1));
			position = sc.nextInt();
		}
		
		System.out.println(newList.displayNode(position +1));
	}
	
	public static void insertNode(LinkList newList)
	{
		char insert;
		int position;
		System.out.println("Please enter the character you wish to add to the linked list");
		insert = sc.next().charAt(0);
		System.out.println("Please enter the position where you wish to add the character");
		System.out.println("If you wish to enter it at the start of it list, enter 0. Please "
				+ "enter a position bigger than the lists current size, which is: " + newList.returnSize() );
		position = sc.nextInt();
		while( position > newList.returnSize() || position < 0)
		{
			System.out.println("Please enter a number between 0 and " + newList.returnSize());
			position = sc.nextInt();
		}
		newList.addLink(insert, position);
		
	}
	
	public static void removeNode(LinkList newList)
	{
		
		int position;
		System.out.println("Your linked list displays " + newList.displayList() +". Position 0 starts at the left most character.");
		System.out.println("Please enter the position where you wish to remove character");
		System.out.println("Please do not enter a position bigger than the lists current size, which is: " + (newList.returnSize()-1) );
		position = sc.nextInt();
		while( position >= newList.returnSize() || position < 0)
		{
			System.out.println("Please enter a number between 0 and " + (newList.returnSize()-1));
			position = sc.nextInt();
		}
		newList.removeLink(position);
		
	}

}
