import java.io.File;
import java.util.Scanner;

/**
 * This class is used to setup and
 * obtain the word and hint for usage
 * in the other classes
 *
 * @author Himanshu Paul
 * @version 3/8/22
 */
public class getWord extends theBombGame {
    private File file = null;
    public String hint = "";
    private Scanner scan = null;
    public String word = returnWord();
    public char guess[][] = new char[2][word.length()];
    
    /**
     * Allows usage of the word.txt file
     */
    public void readFile() {
        try {
            file = new File("words.txt");
            scan = new Scanner(file);
        }
        catch(Exception e) {
            System.out.println("File not found");
            System.exit(0);
        }
    }
    
    /**
     * Reads in the word from the word.txt file
     */
    public String returnWord() {
        readFile();
        word = scan.nextLine();
        return word;
    }
    
    /**
     * Reads in the hint from the word.txt file
     */
    public String returnHint() {
        hint = scan.nextLine();
        return hint;
    }
    
    /**
     * Uses the word read from the txt file
     * and changes it into chars. The chars
     * are stored in the first row of the
     * double char array.
     */
    public void wordToArray() {
        for(int i = 0; i < word.length(); i++) {
            guess[0][i] = returnWord().charAt(i);
        }
    }
    
    /**
     * Returns the double array for
     * the first row and g collumn.
     */
    public char returnArray(int g) {
        return guess[0][g];
    }
    
    /**
     * Calculates the size of
     * the array.
     */
    public int arraySize() {
        int size = 0;
        for(int i = 0; i < word.length(); i++) {
            size++;
        }
        return size;
    }
}
