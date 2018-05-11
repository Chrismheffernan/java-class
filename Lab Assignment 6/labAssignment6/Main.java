package labAssignment6;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		
		Heap mainHeap = new Heap(32);
		
		mainHeap.generateArray();
		
		System.out.println( mainHeap.printTree(5) );
		
		System.out.println("Press any key to continue...");
		sc.nextLine();
		
	
		//Heaps the array into a max array
		/**for( int x = 32/2-1; x >= 1; x--)
		{
			if(mainHeap.heapTheArray(x))
			{
				System.out.println( mainHeap.printTree(5) );
				if( x != 1)
				{
					System.out.println("Press any key to continue...");
					sc.nextLine();
				}
			}
		}**/
		
		mainHeap = recurHeap(1, mainHeap);
		
		System.out.println("Array has been made into a max-heap!");
		System.out.println("Press any key to continue...");
		sc.nextLine();
		
		
		//Sorts the heaped array into order from smallest to largest
		for( int x = 31; x >1; x--)
		{
			int y;
			if( x > 15)
			{
				y = 5;
			}
			else if( x > 7)
			{
				y = 4;
			}
			else if( x > 3)
			{
				y = 3;
			}
			else if( x> 1)
			{
				y = 2;
			}
			else
			{
				y = 1;
			}
			mainHeap.heapSort(x);
			System.out.println( mainHeap.printTree(y) );
			System.out.println("Press any key to continue...");
			sc.nextLine();
		}
		mainHeap.heapSort(1);
		
		System.out.println("Tree has been sorted");
		System.out.println(Arrays.toString(mainHeap.newArray()));
		
		System.out.println("Press any key to continue...");
		sc.nextLine();
		
		sc.close();
			
	

	}
	
	public static Heap recurHeap(int position, Heap mainHeap)
	{
		Scanner sc = new Scanner(System.in);
		
		if( position == 16)
		{
			return mainHeap;
		}
		if(mainHeap.topDownLeft(position))
		{
			System.out.println( mainHeap.printTree(5) );
			System.out.println("Press any key to continue...1");
			sc.nextLine();
		}
		if(mainHeap.topDownRight(position))
		{
			System.out.println( mainHeap.printTree(5) );
			System.out.println("Press any key to continue...2");
			sc.nextLine();
		}
		
		mainHeap = recurHeap( position + 1, mainHeap);
		
		if(mainHeap.heapTheArray(position))
		{
			System.out.println( mainHeap.printTree(5) );
			System.out.println("Press any key to continue...3");
			sc.nextLine();
		}
		
		return mainHeap;
		
		
	}

}
