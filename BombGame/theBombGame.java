import java.util.Scanner;
import java.io.FileReader;
import java.io.File;

/**
 * Combines all classes to
 * create the game.
 *
 * @author Himanshu Paul
 * @version 3/8/22
 */
public class theBombGame {
    public static void main(String[] args) {
        // Used to take input for replay
        Scanner main = new Scanner(System.in);
        String replay = "";

        do{
            // Allows usage of other classes
            getWord word = new getWord();
            InputAndOutput in = new InputAndOutput();
            
            // Methods from other classes
            // combined to create game
            word.returnWord();
            word.returnHint();
            word.wordToArray();
            in.startScreen();
            in.startingOutput(word.word);
            in.checkInput();
            in.complete();
            
            // Checks if user wants
            // to replay game
            word.wordToArray();
            replay = main.next();
        } while (replay.contains("y"));
    }
}
