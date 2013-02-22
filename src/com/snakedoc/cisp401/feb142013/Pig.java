/***********************************************************************************************
 * The game of Pig is a very simple jeopardy dice game in which two players race               *
 * to reach 100 points. Each turn, a player repeatedly rolls a die until either a 1            *
 * is rolled or the player holds and scores the sum of the rolls (i.e. the turn total).        *
 * At any time during a player's turn, the player is faced with two decisions:                 *
 *                                                                                             *
 * roll - If the player rolls a                                                                *
 * 1: the player scores nothing and it becomes the opponent's turn.                            *
 * 2 - 6: the number is added to the player's turn total and the player's turn continues.      *
 * hold - The turn total is added to the player's score and it becomes the opponent's turn.    *
 *                                                                                             *
 * Set your program up so a human and a computer can play together. Program a simple computer  *
 * opponent, ie perhaps a rule 'always roll 3 times', 'roll a die and take that many rolls' or *
 * something like that. The human player goes first. You can use the console or the GUI,       *
 * whichever you are most comfortable with.                                                    *
 *                                                                                             *
 * Bragging Rights - You can do other things to make your program more interesting. Examples   *
 * may be: a more sophisticated AI, very nice GUI, display probablility of winning for         *
 * each roll, etc, etc. Depending upon how well done your enhancement(s) is(are) I will        *
 * award a few bonus points. You don't need to do this to get an 'A' however. If you take      *
 * advantage of this, include a comment section at the bottom of your code explaining what     *
 * you've done.                                                                                *
 * *********************************************************************************************
 */

package com.snakedoc.cisp401.feb142013;

import java.util.Scanner;

public class Pig {
	static final int HUMAN = 1;
	static final int CPU = 2;
	static int rollResult = 0;
	static int currentRoundScore = 0;
	static int cpuScore = 0;
	static int playerScore = 0;
	static int currentPlayer = 0;
	static boolean quitGame = false;
	public static void main(String[] args) {
		initialize();
		gameLoop();
	}
	/**
	 * method is called to initialize the game,
	 * prints banner and game rules then determines
	 * the first player and starts game
	 */
	public static void initialize() {
		System.out.println("########################################\n" +
						   "#      Welcome To The Game of Pig!     #\n" +
						   "#         Coded by Jason Sipula        #\n" +
						   "#          CISP 401 - OOP Java         #\n" +
						   "########################################");
		System.out.println("");
		System.out.println("Rules: \n\nroll - If the player rolls a \n\n1: the player " +
				"scores nothing and it becomes the opponent's turn. \n2 - 6: the number " +
				"is added to the player's turn total and the player's turn continues. " +
				"\n\nhold - The turn total is added to the player's score and it " +
				"becomes the opponent's turn.\n");
		currentPlayer = determineFirstPlayer();
		System.out.println("First Player: " + currentPlayer);
		if (currentPlayer == HUMAN) {
			playerTurn();
		} else if (currentPlayer == CPU) {
			cpuTurn();
		}
	}
	/**
	 * Loop run while game is working,
	 * continues to loop until either a
	 * player reaches game ending score (100)
	 * or quits the game from the menu
	 */
	public static void gameLoop() {
		rollResult = 0;
		System.out.println("Current Player Num: " + currentPlayer);
		while ((playerScore < 100 || cpuScore < 100) && !quitGame) {
			if (currentPlayer == HUMAN) {
				playerTurn();
			} else if (currentPlayer == CPU) {
				cpuTurn();
			}
			rollResult = 0;
		}
	}
	/**
	 *  Rolls a "six sided dice" and returns a 
	 * random number between 1 and 6 
	 **/
	public static int rollSixSideDice() {
		return (int) (1 + (Math.random() * 6));
	}
	/**
	 * Determines the first player upon program startup
	 * @return the number of the first player (1 for Human 2 for CPU)
	 */
	public static int determineFirstPlayer() {
		System.out.println("\nDetermining who shall play first...");
		return (int)(1 + (Math.random() * 2));
	}
	/**
	 * Method is called at the start of the Human Player turn,
	 * is responsible for kicking off all player actions
	 */
	public static void playerTurn() {
		System.out.println("\nPlayer Turn: ");
		displayScore();
		int option = getOption();
		determineAction(option);
		
		
	}
	/**
	 * Method is called at the start of the CPU Player turn,
	 * is responsible for kicking off all cpu player actions
	 */
	public static void cpuTurn() {
		System.out.println("\nCPU Turn: ");
		displayScore();
		determineAction(1);
	}
	/**
	 * Displays Player and CPU Player Scores to stdout
	 */
	public static void displayScore() {
		System.out.println("");
		System.out.println("Player Score: " + playerScore + " | CPU Score: " + cpuScore);
		System.out.print("\n\tCurrent Player: ");
		if (currentPlayer == HUMAN) {
			System.out.print("Human Player");
		} else if (currentPlayer == CPU) {
			System.out.print("CPU Player");
		}
		System.out.print(" | Round Score: " + currentRoundScore);
	}
	/**
	 * Gets user input option from command line
	 * and if the input option is valid, return
	 * the user input.
	 * @return Validated User Input Option
	 */
	public static int getOption() {
		Scanner input = new Scanner(System.in);
		System.out.println("\nOptions:\n   1) Roll Dice\n   2) Hold Turn (Next Player)\n   " +
				"3) Quit Game (Sore Loser!)");
		int option = input.nextInt();
		while (option > 3 || option < 1) {
			System.out.println("\nInvalid Option!");
			System.out.println("\nOptions:\n   1) Roll Dice\n   2) Hold Turn (Next Player)\n   " +
					"3) Quit Game (Sore Loser!)");
			System.out.print("\nEnter Choice: ");
			option = input.nextInt();
		}
		input.close();
		return option;
	}
	/**
	 * Determines the action to perform based on the 
	 * player's selected option number
	 * @param option
	 * 			Number of option player selected
	 */
	public static void determineAction(int option) {
		if (option == 1) {
			rollResult = rollSixSideDice();
			System.out.println("\nThe roll was: " + rollResult);
			validateTurn();
		} else if (option == 2) {
			endRound();
		} else if (option == 3) {
			quitGame();
		}
	}
	/**
	 * Validates the turn after dice has been rolled.
	 * If dice roll is equal to 1, then round score is reset
	 * and round ends. Else, roll is valid.
	 * @return
	 * 		if round should continue or not
	 */
	public static boolean validateTurn() {
		boolean continueTurn = false;
		if (rollResult == 1) {
			currentRoundScore = 0;
			System.out.println("\nWhoops! Looks like your round score is now: " + currentRoundScore + " (sucka!)");
			endRound();
			continueTurn = false;
		} else {
			currentRoundScore += rollResult;
			System.out.println("\nFewww... Safe... For now.\nNew Round Score: " + currentRoundScore);
			continueTurn = true;
		}
		return continueTurn;
	}
	/**
	 * Adds the current round score to the
	 * running game total of the current player
	 */
	public static void addScore() {
		if (currentPlayer == HUMAN) {
			playerScore += currentRoundScore;
		} else if (currentPlayer == CPU) {
			cpuScore += currentRoundScore;
		}
	}
	/**
	 * Runs end of round routines
	 */
	public static void endRound() {
		System.out.println("\nEnd Of Round!");
		System.out.print("\nNext Player: ");
		if (currentPlayer == HUMAN) {
			addScore();
			currentRoundScore = 0;
			currentPlayer = CPU;
			System.out.println("CPU Player");
		} else if (currentPlayer == CPU) {
			addScore();
			currentRoundScore = 0;
			currentPlayer = HUMAN;
			System.out.println("Human Player");
		}
	}
	/**
	 * Runs end of game routines
	 */
	public static void endGame() {
		quitGame = true;
		System.out.println("\nFinal Score -- \n\tPlayer: " + playerScore + " | CPU: " + cpuScore);
		if (playerScore > cpuScore) {
			System.out.println("\nCongrats! You Won!");
		} else {
			System.out.println("\nBetter Luck Next Time!");
		}
		System.out.println("\nThanks For Playing!");
	}
	/**
	 * runs routines for when game is quit early
	 * by player including a random exit "jeer" at the player
	 * for quiting early.
	 */
	public static void quitGame() {
		quitGame = true;
		int ran = (int)(1 + (Math.random() * 5));
		switch (ran) {
			case 1 : ran = 1;
				System.out.println("\nCouldn't Hang In There Huh?");
				break;
			case 2 : ran = 2;
				System.out.println("\nGetting Too Hot In Here?");
				break;
			case 3 : ran = 3;
				System.out.println("\nLoosing Already?");
				break;
			case 4 : ran = 4;
				System.out.println("\nBut We're Just Getting Started!");
			case 5 : ran = 5;
				System.out.println("\nDevelopers Note: Add Easier AI...");
				break;
			default: 
				System.out.println("\nCome Back So I Can Win Again!");
		}
		endGame();
	}
	/**
	 * prints enough blank lines to clear the immediate
	 * focus of the screen/console
	 */
	public static void clearScreen() {
		for (int i = 0; i < 25; i++) {
			System.out.println("");
		}
	}
}
