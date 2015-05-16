package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 * Created by Ashley on 5/16/15.
 */
public class Input {

    private final BufferedReader in;
    private NumberFormat integerFormat;

    public Input(BufferedReader in) {
        this.in = in;
        integerFormat = NumberFormat.getIntegerInstance();
    }

    public int listenForGuess() {
        System.out.println("Guess?");
        try {
            String guessInput = in.readLine();
            return integerFormat.parse(guessInput).intValue();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public GameOptions setUpGame() throws IOException {
        System.out.println("Would you like to create a custom game? Y/N");
        String customGameAnswer = in.readLine();
        if (customGameAnswer.trim().equalsIgnoreCase("Y")) {
            System.out.println("Please enter a lower bound.");
            String lowerBoundInput = in.readLine();
            System.out.println("Please enter an upper bound.");
            String upperBoundInput = in.readLine();
            try {
                int lowerBound = integerFormat.parse(lowerBoundInput).intValue();
                int upperBound = integerFormat.parse(upperBoundInput).intValue();
                return new GameOptions(lowerBound, upperBound);
            } catch (ParseException e) {
                System.out.println("I can not understand your meaning... system closing.");
                return null;
            }
        } else {
            return new GameOptions(0, 100); //defaults
        }
    }

}
