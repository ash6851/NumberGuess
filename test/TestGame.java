import com.company.Game;
import com.company.GameOptions;
import com.company.Input;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by Ashley on 5/16/15.
 */
public class TestGame {

    @Test
    public void testTenGuessesWin() {
        String userGuesses = "1\n" +
                "2\n" +
                "3\n" +
                "4\n" +
                "5\n" +
                "6\n" +
                "7\n" +
                "8\n" +
                "9\n" +
                "10\n";
        BufferedReader testInput = new BufferedReader(new StringReader(userGuesses));

        Game game = new Game(new Input(testInput), new GameOptions(1, 10));
        boolean isWin = game.runGame(); //game only allows numbers between 1 and 10, and we've guessed them all! -AK
        assertTrue(isWin);
    }

    @Test
    public void testTenGuessesLoss() {
        String userGuesses = "11\n" +
                "12\n" +
                "13\n" +
                "14\n" +
                "15\n" +
                "16\n" +
                "17\n" +
                "18\n" +
                "19\n" +
                "20\n";
        BufferedReader testInput = new BufferedReader(new StringReader(userGuesses));

        Game game = new Game(new Input(testInput), new GameOptions(1, 10));
        boolean isWin = game.runGame(); //game only allows numbers between 1 and 10, and all our numbers are outside because we don't understand this game! -AK
        assertFalse(isWin);
    }
}
