package com.qianjin.java.sss.java2s.a02;


/**
 * Considering games with feature of turn-taking, generally this type of games starts by seating the players who will take part in the game. 
 * As each player joins the game, they are given a (virtual) "seat at the table". The players are seated in the order they arrive. 
 * After each round, new round will start from the first player.
 * From the view of ADT, this is a circular list which means the last node point to the first node, so it is a ring.
 * This interface try to be designed as a circular list in order to contain the players.
 * This interface describes the operations of the specific circular list, the implementation classes must implement these methods.
 * Considering features/fields of players in each game are different, this interfaces is generic. 
 * That design may make a Ring of any kind of object (just as we can make a Bag that contains any kind of object introduced in the class)
 *
 * @author Lingda Cai A00372181
 * @version 1.0
 */

public interface Ring<T> {

	/**
	 * Obtain an Iterator over this ring.
	 * Since the concrete storage implementation for circular list will vary, array, linked list, array list for example,
	 * So how to iterator a circular list will not need to depend on Ring
	 * So a RingIterator has been introduced
	 * @see RingIterator 
	 *
	 * @return an Iterator over the elements of this ring.
	 */
	public RingIterator<T> iterator();

	/**
	 * Obtain whether the current circular list is an empty list.
	 *
	 * @return True if it is empty otherwise false.
	 */
	public boolean isEmpty();

	/**
	 * This method is designed to insert a new element into this circular list, for example, seating a player at the table, a new player coming needs to be inserted into the circular list
	 * By default, the circular list will be empty. There should be a specific node named HEAD which indicates the first node because of it is a ring in circular list.
	 * The index position of this head node of this circular list will be 0
	 * The new element will be inserted into after the last element, and it's next pointer will be the first node.
	 *
	 * @param  t the generic object which will be added into the current circular list
	 * @exception NullObjectIsNotAccept if the t is null object, it will be refused.
	 * 
	 * @return True if it is performed successfully, otherwise false
	 */
	public boolean add(T t);

	/**
	 * Remove the element which index is given.
	 * The index position of the head node of this circular list will be 0, so if the index==0 could not be removed. 
	 * Needs to check if the index value must be more than 0
	 *
	 * @param  the index position of element which will be deleted
	 * @exception IndexOutOfBox if the index is more than the size of the current circular list, or the index is less than or equals with 0
	 * @throws NullPointer  if the circular list is empty, will trigger an exception
	 * 
	 * @return True if it is performed successfully, otherwise false
	 */
	public boolean remove(int index);

	/**
	 * Obtain the element which index number is given
	 * The index position of this head node of this circular list will be 0, so in this method, the validation of index value is a must
	 *
	 * @param  index which position will be obtained
	 * @exception IndexOutOfBox if the index is more than the size of the current circular list, or the index is less than 0
	 * @throws NullPointer  if the circular list is empty, will trigger an exception
	 * 
	 * @return The element which index number is given, otherwise return will be null
	 */
	public T get(int index);
	
	/**
	 * Obtain the first element in the circular list
	 *
	 * @return The first element, if the circular list is empty, null be returned
	 */
	public T getFirst();
	
	/**
	 * Obtain the last element in the circular list
	 *
	 * @return The last element, if the circular list is empty, null be returned
	 */
	public T getLast();

	/**
	 * Obtain the size of the current circular list
	 * Can be used for returning the number of players at the table
	 * 
	 * @return If the circular list is empty, 0 will be returned.
	 */
	public int size();


	/**
	 * Format the toString output in order to print it in test/demo program
	 * For example, in this course requirement, after each round, the game program needs to print the current remaining players.
	 * the format will be [1, 3, 4, 5]
	 * So, in different requirements, the implemented class should be override this method. 
	 */
	public String toString();

}
