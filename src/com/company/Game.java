package com.company;

import java.util.Random;

/**
 * Created by Ashley on 5/16/15.
 */
public class Game {

    private final GameOptions gameOptions;
    private final Input input;

    public Game(Input input, GameOptions gameOptions) {
        this.gameOptions = gameOptions;
        this.input = input;
    }

    public boolean runGame() {
        boolean isGameInProgress = true;
        int maxGuesses = 10;
        int currentGuess = 0;
        Random random = new Random(10);
        int numberAnswer = random.nextInt();

        while (isGameInProgress) {
            int guess = input.listenForGuess();
            if (guess == numberAnswer)
                return true; //game is won
            else if (guess < numberAnswer)
                System.out.println("higher");
            else
                System.out.println("lower");

            if (currentGuess > maxGuesses)
                isGameInProgress = false;
        }

        return false;
    }
}
