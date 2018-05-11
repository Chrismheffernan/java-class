
package labAssignment6;

import java.util.Arrays;

public class Heap {

	private Data2[] theHeap;
	private int numOfItems = 0;
	
	private int heapSize;
	
	
	/**
	 * Heap constructor
	 * Uses the max sized passed into it to create an array of Data2
	 * @param maxSize
	 */
	public Heap(int maxSize)
	{
		this.heapSize = maxSize;
		theHeap = new Data2[maxSize];
	}
	
	/**
	 * Method insert
	 * Inserts a new Data2 object at a specific index
	 * @param index
	 * @param newData
	 */
	public void insert( int index, Data2 newData)
	{
		theHeap[index] = newData;
		

	}
	
	
	public boolean topDownLeft( int index)
	{
		Data2 temp = theHeap[index];
		if(theHeap[index * 2].getKey() > theHeap[index].getKey())
		{
			theHeap[index] = theHeap[index * 2];
			theHeap[index * 2] = temp;
			return true;
		}
		
		return false;
		
	}
	
	/**
	 * Method topDownRight
	 * 
	 * @param index
	 * @return
	 */
	public boolean topDownRight( int index)
	{
		Data2 temp = theHeap[index];
		if(theHeap[index * 2+1].getKey() > theHeap[index].getKey())
		{
			theHeap[index] = theHeap[index * 2+1];
			theHeap[index * 2+1] = temp;
			return true;
		}
		
		return false;
	}
	
	/**
	 * Method newArray
	 * Creates an array to be returned to main that can be displayed using System.out
	 * @return an array of int
	 */
	public int[] newArray()
	{
		int[] array = new int[heapSize-1];
		for( int x = 1; x < heapSize; x++)
		{
			array[x-1] = theHeap[x].getKey();
		}
		
		return array;
		
		
	}
	
	/**
	 * Method incrementArray
	 * Used to increase the number of items in the array
	 */
	public void incrementArray()
	{
		numOfItems++;
	}
	
	/**
	 * Method generateArray
	 * Creates a new array filling it with values from 10-89 with no duplicates
	 */
	public void generateArray()
	{
		Data2 newData;
		
		int newInt;
		
		
		
		for( int x = 1; x < this.heapSize; x++ )
		{
			
			newInt = (int)(Math.random() * 89) + 10;
			newData = new Data2(newInt);
			if(!checkForDoubles(newInt))
			{
				this.insert(x, newData);
				incrementArray();
			}
			else
			{
				x--;
			}
		}
	}
	
	/**
	 * Takes the first value of the Array and puts it at the end of the array.
	 * Pop removes the number of items, while insert doesn't increase it. Leading to an ordered array with a size of 1
	 * @param num
	 */
	public void heapSort(int num)
	{
		Data2 largestNum = pop();
		insert(num, largestNum);
		
	}
	
	/**
	 * Method checkForDoubles]
	 * Used by the method generateArray
	 * @param check int to check against array
	 * @return true if the number exists in the array
	 */
	public boolean checkForDoubles(int check)
	{
		for( int x = 1; x < numOfItems+1; x++)
		{
			if( check == theHeap[x].getKey())
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Removes the first value of the array and replaces it with the last
	 * Then heaps the array to max
	 * @return the first value of the array
	 */
	public Data2 pop()
	{
		if(numOfItems != 0)
		{
			Data2 root = theHeap[1];
			theHeap[1] = theHeap[numOfItems--];
			heapTheArray(1);
			
			return root;
		}
		
		return null;
	}
	
	/**
	 * Heaps down an array starting from the index passed to it
	 * @param index the position where to start a heap in the array
	 * @return true if any values were changed
	 */
	public boolean heapTheArray(int index)
	{
		int cycles = 0;
		int largestChild;
		
		Data2 root = theHeap[index];
		
		while( index < numOfItems /2+1)
		{
			int leftChild = 2 * index;
			int rightChild = leftChild +1;
			
			if(rightChild < numOfItems+1 && theHeap[leftChild].getKey() < theHeap[rightChild].getKey())
			{
				largestChild = rightChild;
			}
			else
			{
				largestChild = leftChild;
			}
			
			if( root.getKey() >= theHeap[largestChild].getKey())
			{
				if( cycles == 0 && index != 1 )
				{
					return false;
				}
				else
				{
					break;
				}
			}
			
			theHeap[index] = theHeap[largestChild];
			
			index = largestChild;
			
			cycles++;
			
		}
		
		
		theHeap[index] = root;
		return true;
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
	 * Method printTree
	 * Returns the string of the printed array to whatever calls it
	 * @param rows amount of rows that should be printed
	 * @return the results of the tree
	 */
	public String printTree(int rows)
	{
		String tree = "";
		String test;
		int spaces = 0;
		int iterator = 1;
		int[] indent = getIndentArray(rows);
		
		while(iterator <= rows )
		{
			
			int indexToPrint = (int) (.5 * (-2 + (Math.pow(2,  iterator))));
			
			int itemsPerRow = (int) (Math.pow(2, iterator - 1));
			
			int maxIndexToPrint = indexToPrint + itemsPerRow;
			
			for( int x = 0; x < indent[iterator - 1]; x++)
			{
				tree = tree + " ";
			}
			
			for( int y = indexToPrint; y < maxIndexToPrint; y++)
			{
				
				
				if ( y < numOfItems )
				{
					test =  Integer.toString(theHeap[y+1].getKey());
					
					tree = tree + test;
					
					for( int z = 0; z < spaces; z++)
					{
						tree = tree + " ";
					}
				}
				
			}
			
			spaces = indent[iterator - 1];
			
			iterator++;
			
			tree = tree + "\n ";
			
		}
		
		return tree;
	}
	
	/**
	 * Method getIndentArray
	 * Method used to determine how many indents each rows should get
	 * @param rows how many rows to determine indents for
	 * @return the number of indents for the printed tree
	 */
	public int[] getIndentArray(int rows)
	{
		int[] array = new int[rows];
		
		for(int i = 0; i < rows; i++)
		{
			array[i] = (int) Math.abs( (-2 + (Math.pow(2,  i+1))));
		}
		
		Arrays.sort(array);
		
		array = reverseArray(array);
		
		return array;
	}
	
	/**
	 * Method reverseArray
	 * getIndentArray needs to be reversed
	 * @param array that needs to be reversed
	 * @return reversed array of getIndentArray
	 */
	public int[] reverseArray(int[] array)
	{
		int left = 0;
		int right = array.length - 1;
		
		while(left < right)
		{
			int temp = array[left];
			array[left] = array[right];
			array[right] = temp;
			
			left++;
			right--;
		}
		
		return array;
	}
}
