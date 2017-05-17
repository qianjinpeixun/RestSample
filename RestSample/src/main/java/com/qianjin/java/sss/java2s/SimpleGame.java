package com.qianjin.java.sss.java2s;

import java.util.*;

/**
 * This program is a dice-rolling game.  Each player rolls a pair of dice (6-sided) in turn. If they roll a 2, 3 or 12 then they are eliminated from the game.
 * This is a test program in order to verify the functions of Ring/RingInterator interfaces and their implementations.
 * This SimpleGame uses interfaces and the (fake) implementations to play a simple game of chance.
 * Since there are some fake source code in those implementation class, so this test game will crash when you try to run it.
 * Generally, the purpose of this test program is to verify the concept of design of Ring and RingIterator interfaces and implement classes.
 * The developer who will implement the MyRing and MyRingiterator can get more details from this test program.
 * 
 * 
 * @author Lingda Cai A00372181
 * @version 1.0
 */

public class SimpleGame {

	public static void main(String[] args) {
		SimpleGame simpleGame = new SimpleGame();
		simpleGame.runGame();
	}

	/**
	 * Notice that this method will crash after running because of all of implementation class just return an exception
	 * So this is just for verify the concept and design about Ring and RingIterator interfaces.
	 * It would play the game if it were given a suitable implementation of the ADTs: MyRing and MyRingIterator classes.
	 */
	private void runGame() {

		// Construct MyRing to contain players
		Ring<String> myRing = new MyRing();

		// Introduce yourself
		System.out.println("This program plays a game where each player rolls the dice and is eliminated, if they roll a 2, a 3 or a 12. Last player left in the game wins.");
		System.out.print("How many people are there in the game?");
		Scanner keyboard = new Scanner(System.in);
		int userCount = keyboard.nextInt();
		System.out.println("Here we go!");

		// Start to initialize the circular list
		for (int i = 0; i < userCount; i++) {
			myRing.add(String.valueOf(i + 1));
		}

		// In order to iterate this circular list, getting the RingIterator
		// instance
		RingIterator<String> ringIterator = myRing.iterator();

		// Start to play this game
		while (ringIterator.hasNext()) {
			// In order to simplify this test program, use String object to
			// present a pserson information
			String person = ringIterator.next();

			// If there is only one player, this player is winner, break the
			// loop
			if (myRing.size() == 1) {
				System.out.println("The winner is player #" + person + "!");
				break;
			}

			/*
			 * if there are more than one players, get the current turn's player
			 * object simulate one player rolls a pair of dice (6-sided), using
			 * random method to get the number after dice-rolling by generating
			 * a random number from 1 to 12, judge if the number is 2 3 or 12
			 */
			int number = (int) (Math.random() * 12 + 1);
			if (number == 2 || number == 3 || number == 12) {
				// eliminate the current player
				// according the design in ADTs, the ringIterator should be
				// refreshed, the size shrinks as well
				ringIterator.remove();
				System.out.println("Player " + person + " is eliminated.");
			}
			// if the current player is the last node, print the reamaining
			// player information
			if (ringIterator.isLast()) {
				System.out.println("Remaining players: " + myRing);
			}
		}
		keyboard.close();
	}

}
