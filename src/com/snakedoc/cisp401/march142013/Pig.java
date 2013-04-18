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

package com.snakedoc.cisp401.march142013;

import java.util.Scanner;

import com.snakedoc.cisp401.march142013.Pig.*;

public class Pig {
	
	// begin main
	public static void main(String[] args) {
	    GameCore game = new GameCore();
	    
	    
	    
	//	initialize();
	//	gameLoop();
	}

	/**
	 * Class of basic system utilities
	 *
	 */
	static class SYS {
	    /**
	     * utility method that prints enough blank lines 
	     * to clear the immediate focus of the screen/console
	     */
	    public static void clearScreen(int lines) {
	        for (int i = 0; i < lines; i++) {
	            System.out.println("");
	        }
	    }
    
	    /**
	     * utility method to sleep the thread
	     * for the input time in milliseconds
	     */
	    public static void sleep(int millis) {
	        try {
	            Thread.sleep(millis);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	} /* END SYS static class */

	/**
	 * Class of constants declared
	 * throughout the entire program.
	 *
	 */
	static class GameConst {
	    
	    // Declare constants
	    static final int HUMAN = 1;
	    static final int CPU = 2;
	    static final int FIVE_SECOND = (1000 * 5);
	    static final int THREE_SECOND = (1000 * 3);
	    static final int TWO_SECOND = (1000 * 2);
        static final int SECOND = (1000 * 1);
        static final int HALF_SECOND = (int)(1000 * .5);
        static final int CLR = 50; // number of lines to clear console screen
        
	} /* END GameConst static class */
	
} /* END Pig class */

/**
 * Class of game core logic.
 *
 */
class GameCore {
    
    // Declare variables
    int rollResult = 0;
    int currentRoundScore = 0;
    int cpuScore = 0;
    int playerScore = 0;
    int currentPlayer = 0;
    boolean quitGame = false;
    
    /**
     * method is called to initialize the game,
     * prints banner and game rules then determines
     * the first player and starts game
     */
    public void initialize() {
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
        
        System.out.print("\nPress [ENTER] to continue...\n");
        this.getInputStr();
        
        System.out.println("Determining who shall play first...");
        currentPlayer = getRandomPlayer();
        
        System.out.print("\nFirst Player: ");
        if (currentPlayer == HUMAN) {
            System.out.println("Human Player");
            SYS.sleep(GameConst.THREE_SECOND);
            SYS.clearScreen(GameConst.CLR);
            playerTurn();
        } else if (currentPlayer == CPU) {
            System.out.println("CPU Player");
            SYS.sleep(GameConst.THREE_SECOND);
            SYS.clearScreen(GameConst.CLR);
            cpuTurn();
        }
        SYS.sleep(GameConst.SECOND);
    }
    
    /**
     * Loop run while game is working,
     * continues to loop until either a
     * player reaches game ending score (100)
     * or quits the game from the menu
     */
    public void gameLoop() {
        rollResult = 0;
        while ((playerScore < 100 && cpuScore < 100) && !quitGame) {
            if (currentPlayer == HUMAN) {
                playerTurn();
            } else if (currentPlayer == CPU) {
                cpuTurn();
            }
            rollResult = 0;
            SYS.sleep(GameConst.HALF_SECOND);
            SYS.clearScreen(GameConst.CLR); // clear enough lines to blank console
        }
    }
    
    /**
     * Displays Player and CPU Player Scores to stdout
     */
    public void displayScore() {
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
     *  Rolls a "six sided dice" and returns a 
     * random number between 1 and 6 
     **/
    public int rollSixSideDice() {
        return (int) (1 + (Math.random() * 6));
    }
    
    /**
     * Determines the first player upon program startup
     * @return the number of the first player (1 for Human 2 for CPU)
     */
    public int getRandomPlayer() {
        return (int)(1 + (Math.random() * 2));
    }
    
    /**
     * Validates the turn after dice has been rolled.
     * If dice roll is equal to 1, then round score is reset
     * and round ends. Else, roll is valid.
     * @return
     *      if round should continue or not
     */
    public boolean validateTurn() {
        boolean continueTurn = false;
        SYS.sleep(GameConst.THREE_SECOND);
        if (rollResult == 1) {
            currentRoundScore = 0;
            SYS.clearScreen(GameConst.CLR);
            System.out.println("\nWhoops! Looks like your round score is now: " + currentRoundScore + " (sucka!)");
            SYS.sleep(GameConst.THREE_SECOND);
            endRound();
            continueTurn = false;
        } else {
            currentRoundScore += rollResult;
            SYS.clearScreen(GameConst.CLR);
            System.out.println("\nFewww... Safe... For now.\n\nNew Round Score: " + currentRoundScore + "\n");
            SYS.sleep(GameConst.THREE_SECOND);
            continueTurn = true;
        }
        return continueTurn;
    }
    
    /**
     * Adds the current round score to the
     * running game total of the current player
     */
    public void addScore() {
        if (currentPlayer == HUMAN) {
            playerScore += currentRoundScore;
        } else if (currentPlayer == CPU) {
            cpuScore += currentRoundScore;
        }
    }
    
    /**
     * Runs end of round routines
     */
    public void endRound() {
        System.out.println("\nEnd Of Round!");
        SYS.sleep(GameConst.HALF_SECOND);
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
        SYS.sleep(GameConst.HALF_SECOND);
    }
    
    /**
     * Runs end of game routines
     */
    public void endGame() {
        quitGame = true;
        SYS.sleep(GameConst.HALF_SECOND);
        System.out.println("\nFinal Score -- \n\tPlayer: " + playerScore + " | CPU: " + cpuScore);
        if (playerScore > cpuScore) {
            System.out.println("\nCongrats! You Won!");
        } else {
            System.out.println("\nBetter Luck Next Time!");
        }
        System.out.println("\nThanks For Playing!");
        SYS.sleep(GameConst.HALF_SECOND);
    }
    
    /**
     * runs routines for when game is quit early
     * by player including a random exit "jeer" at the player
     * for quitting early.
     */
    public void quitGame() {
        SYS.sleep(GameConst.HALF_SECOND);
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
        SYS.sleep(GameConst.HALF_SECOND);
        endGame();
    }
} /* END GameCore class */

/**
 * Abstract class for player logic
 *
 */
abstract class Player {
    /**
     * Determines the action to perform based on the 
     * player's selected option number
     * @param option
     *          Number of option player selected
     */
    public void determineAction(int option) {
        SYS.sleep(GameConst.TWO_SECOND);
        if (option == 1) {
            rollResult = rollSixSideDice();
            System.out.println("\n\nThe roll was: " + rollResult);
            validateTurn();
        } else if (option == 2) {
            endRound();
        } else if (option == 3) {
            quitGame();
        }
    }
    /**
     * Gets input from stdin
     * @return user input string
     */
    public String getInputStr() {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        input.close();
        return str;
    }
    
    /**
     * Gets user input option from command line
     * and if the input option is valid, return
     * the user input.
     * @return Validated User Input Option
     */
    public int getOption() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nOptions:\n   1) Roll Dice\n   2) Hold Turn (Next Player)\n   " +
                "3) Quit Game (Sore Loser!)");
        System.out.print("\nEnter Option Number: ");
        int option = input.nextInt();
        while (option > 3 || option < 1) {
            System.out.println("\nInvalid Option!");
            System.out.println("\nOptions:\n   1) Roll Dice\n   2) Hold Turn (Next Player)\n   " +
                    "3) Quit Game (Sore Loser!)");
            System.out.print("\nEnter Option Number: ");
            option = input.nextInt();
        }
        input.close();
        return option;
    }
} /* END Player abstract class */

/**
 * Class for the CPU player that
 * extends the Player class.
 *
 */
class CPU extends Player {
    /**
     * Method is called at the start of the CPU Player turn,
     * is responsible for kicking off all cpu player actions
     */
    public void cpuTurn() {
        System.out.println("\nCPU Turn: ");
        displayScore();
        runAI();
        SYS.sleep(GameConst.HALF_SECOND);
    }
    /**
     * AI for CPU Player
     * determines what action to take
     */
    public void runAI() {
        int num = (int)(1 + (Math.random() * 10));
        if (currentRoundScore >= 10) {
            if (num >= 8) {
                determineAction(1); // very conservative
            } else {
                determineAction(2); // quit round
            }
        } else if (currentRoundScore >= 7) {
            if (num >= 6) {
                determineAction(1); // moderately conservative
            } else {
                determineAction(2); // quit round
            }
        } else if (currentRoundScore >= 4) {
            if (num >= 4) {
                determineAction(1); // mildly aggressive
            } else {
                determineAction(2); // quit round
            }
        } else if (currentRoundScore >= 2) {
            if (num >= 2) {
                determineAction(1); // moderately aggressive
            } else {
                determineAction(2); // quit round
            }
        } else if (currentRoundScore >= 1) {
            determineAction(1); // very aggressive
        } else {
            determineAction(1); // try to get on score board
        }
    }
} /* END CPU class extending Player abstract class */

/**
 * Class for the Human Player (HPU)
 * that extends the Player class.
 *
 */
class HPU extends Player {
    /**
     * Method is called at the start of the Human Player turn,
     * is responsible for kicking off all player actions
     */
    public void playerTurn() {
        System.out.println("\nPlayer Turn: ");
        displayScore();
        int option = getOption();
        determineAction(option);
        SYS.sleep(GameConst.HALF_SECOND);
    }
} /* END HPU class extending Player abstract class */
