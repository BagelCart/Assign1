package assign2;
/**
 * @author Joshua McNeil
 * classID 367, assignment 1
 * 
 * This file contains only the class SimpleList.
 */

/**
 * SimpleList creates and manages a list of up to 10 integer 
 * values. Users can add and remove values from the list as
 * well as display contents, display number of elements in
 * the list, and search for the location of a value.
 */
class SimpleList
{
	/**
	 * list contains 10 storage locations for the list
	 *  of integers.
	 */
	public int[] list;
	/**
	 * count contains the value of how many integers are
	 * currently in the list.
	 */
	public int count;
	
	/**
	 * SimpleList, also known as the constructor, creates
	 * an empty list with 10 storage locations.
	 */
	public SimpleList()
	{
		list = new int[10];
		count = 0;
	}
	
	/**
	 * Inserts another integer into the list at location 0.
	 * All other elements of the list will then be adjusted
	 * one location. 
	 * <p>
	 * In the event that the list is already full, add will
	 * increase the size of the array by 50% (rounded down)
	 * and add the new integer.
	 * 
	 * @param element Integer value to be added to the list.
	 */
	public void add(int element)
	{
		int current = count;
		int[] newList;
		
		if (count == list.length)
			expand();
		else
		{
			while (current > 0)
			{
				list[current] = list[current - 1];
				--current;
			}
		}
		
		list[0] = element;
		
		++count;
	}
	
	/**
	 * Removes all instances of the given integer in the 
	 * list. All elements after the removed integer(s) will 
	 * be shifted toward the front of the list to fill the
	 * gap left by the removed value. In the event that the
	 * list contains multiple entries of the given integer,
	 * all will be removed.
	 * <p>
	 * If the list is more than 25% empty after removal,
	 * the list capacity will be shrunk by 25%. Capacity
	 * will never be less than 1 integer.
	 * 
	 * @param element the integer value to be removed.
	 */
	public void remove(int element)
	{
		int current = 0;
		int shiftstart;
		int[] newList;
		
		while (current < count)
		{
			if (list[current] == element)
			{
				shiftstart = current;
				--count;
				
				while (shiftstart < count)
				{
					list[shiftstart] = list[shiftstart + 1];
					++shiftstart;
				}
			}
			else
				++current;
		}
		
		if (count <= ((int) Math.floor(list.length * 0.75))
				&& list.length > 1)
		{
			newList = new int[(int) Math.floor(list.length * 0.75)];
			if (count > 0)
			{
				while (current >= 0)
				{
					newList[current] = list[current];
					--current;
				}
				list = newList;
			}
		}
	}
	
	/**
	 * Returns the number of integers currently in the list.
	 * 
	 * @return number of integers in the list.
	 */
	public int count()
	{
		return count;
	}
	
	/**
	 * Displays all current integers in the list.
	 * Integers will be displayed in the order they
	 * were added to the list.
	 * In the event that the list is empty, nothing
	 * will be displayed.
	 */
	public String toString()
	{
		String contents = "";
		
		for (int current = 0; current < count; ++current)
		{
			contents = contents + list[current];
			if (current < count - 1)
				contents = contents + " ";
		}
		
		return contents;
	}
	
	/**
	 * Finds the location of the given integer within the 
	 * list. The location will be the index location.
	 * For example, if the list contains 3 4 5 7, and the
	 * element parameter is 5, 2 will be the returned value.
	 * 
	 * @param element Integer to be searched for in the list.
	 * @return Index location of the given integer.
	 */
	public int search(int element)
	{
		int location = -1;
		int current = 0;
		
		while (current < count && location == -1)
		{
			if (list[current] == element)
				location = current;
			++current;
		}
		
		return location;
	}
	
	/**
	 * Appends the given element to the end of the list.
	 * If the list was full, it increases the size by 50%
	 * so there will be room.  Increments the count.
	 * 
	 * @param element Integer to be added to the end of the list.
	 */
	public void append(int element)
	{
		if (count == list.length)
			expand();
		
		list[count] = element;
		++count;
	}
	
	/**
	 * Returns the first element in the list.
	 * If there are no elements n the list, then returns -1.
	 * 
	 * @return Stored value at the first location in the list.
	 */
	public int first()
	{
		int value;
		
		if (count == 0)
			value = -1;
		else
			value = list[0];
		
		return value;
	}
	
	/**
	 * Returns the last element in the list.
	 * If there are no elements n the list, then returns -1.
	 * 
	 * @return Stored value of the last element in the list.
	 */
	public int last()
	{
		int value;
		
		if (count == 0)
			value = -1;
		else
			value = list[count - 1];
		
		return value;
	}
	
	/**
	 * Returns the current number of possible locations
	 * in the list. This is the current size of the list.
	 * 
	 * @return Total amount of storage locations in the list.
	 */
	public int size()
	{
		return list.length;
	}
	
	/**
	 * Expands the current number of available storage locations
	 * in the list by 50%, rounded down to the nearest integer.
	 */
	private void expand()
	{
		int current = list.length;
		int[] newList = new int
				[(int) Math.floor(list.length * 1.5)];
		
		while (current > 0)
		{
			newList[current]=list[current-1];
			--current;
		}
		list=newList;
	}
}