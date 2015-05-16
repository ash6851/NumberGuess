package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/*
Dad tasks:
1. Make it work.
2. Have the game tell you the answer at the end on loss.
3. Make it so multiple games can be run in a single session. (Play again?)
4. Handle user typos
5. Create java interface around game.
*/
public class NumberGuessGame {

    private final Input input;

    public NumberGuessGame() {
        input = new Input(new BufferedReader(new InputStreamReader(System.in)));
    }

    public void startGame() {
        System.out.println("Welcome to the Number Guess Game!");
        try {
            System.out.println("Rules: I will think of a number and you will try to guess it.  " +
                    "Each time you guess I will tell you if the real number is higher or lower.  You have 10 tries. Begin!");
            GameOptions gameOptions = input.setUpGame();
            Game game = new Game(input, gameOptions);
            boolean isWin = game.runGame();
            if( isWin )
            {
                System.out.println("You have beaten me...... THIS TIME!");
            }
            else
            {
                System.out.println("You have... LOST! hahahahahahaha");
            }

        } catch (IOException e) {
            System.out.println("Unable to start game. System closing.");
        }
    }


    public static void main(String[] args) {
        NumberGuessGame numberGuessGame = new NumberGuessGame();
        numberGuessGame.startGame();
    }
}
