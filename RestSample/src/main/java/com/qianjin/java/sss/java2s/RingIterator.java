package com.qianjin.java.sss.java2s;

/**
 * This interface is designed for keeping track of whose turn it is. 
 * It starts at the first person in the Ring and continues from one player to the next.
 * When it reaches the end of the list it swings back around to the first player. (The client doesn't need to tell it to do that; it does it on its own without any prompting or special feedback.) 
 * Generally, this interface describes the operations about how to deal with and iterate a Ring object
 *
 * @author Lingda Cai A00372181
 * @version 1.0
 */

public interface RingIterator<E> {

	/**
	* Advancing to the next player, and retrieve the next available element.
	* The elements which have been added into circular list is with order, so the first next() will return the first node.
	* If reach the last element, the next() will return the first node.
	* So in the test/demo programs, the developers must be careful to avoid infinite loop because of the feature of circular list 
	* 
	* @exception if the circular list is empty, an exception will be triggered
	* @return the next element in the ring.
	* @throws NoSuchElementException if there are no more elements.
	*/
	public E next();
	
	/**
	* 
	* Check if there is available elements in circular list
	* Must be careful for this in a loop, except the list is empty, otherwise it always returns true due to the feature of circular list 
	* 
	* @return True if there is next available element, if the circular list size is 0, return false
	* 
	*/
	public boolean hasNext();


	/**
	* Remove the current element from the ring, this is for eliminating the current player.
	* If this operation is performed successfully, the size of circular list must be set, the RingIterator reference should be refreshed as well.
	* @exception NullPointer if the circular list is empty 
	* @return True if the current element has been removed and false otherwise
	*/
	public boolean remove();

	/**
	* Obtain if the current element is the first element(node)
	
	* @exception if the circular list is empty, an exception will be triggered
	* @return True if the current element is the head and false otherwise
	*/
	public boolean isHead();

	/**
	* Obtain if the current element is the last element(node)
	*
	* @exception if the circular list is empty, an exception will be triggered
		* @return True if the current element is the last and false otherwise
	*/
	public boolean isLast();

}
