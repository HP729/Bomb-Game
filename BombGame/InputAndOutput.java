import java.util.Scanner;
/**
 * This class obtains input 
 * from the user, which allows
 * the game to be playable.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class InputAndOutput extends theBombGame {
    private int count;
    private int chance;
    private char in;
    Scanner input = new Scanner(System.in);
    
    // allows usage of other classes
    getWord word = new getWord();

    /**
     * Obtains char from the user
     * and keeps track of which
     * letter is currently being
     * guessed
     */
    public void getInput() {
        for(int g = 0; g < word.arraySize() ; g++) { 
            System.out.println("Enter letter " + (g + 1));
            in = input.next().charAt(0);
        }
    }

    /**
     * Checks if the char input obtained
     * matched with the current char needed.
     */
    public void checkInput() {
        for(int g = 0; g < word.arraySize(); g++) {
            for(int i = 0; i < word.arraySize() ; i++) { 
                System.out.println("Enter letter " + (g + 1)); 
                word.wordToArray();
                in = input.next().charAt(0);
                
                // Compares user input to word
                if(word.guess[0][g] == in) {
                    word.guess[1][g] = in;
                    count++;
                    break;
                }
                else {
                    chance++;
                }
                
                // prints out bomb
                bomb(count);
            }
            printGuess();
        }
    }

    /**
     * Prints out lines that represent
     * length of the word.
     */
    public void printGuess() {
        System.out.println();

        //Prints out correct guess
        for(int w = 0; w < count; w++) {
            
            if(w == 0) {  
                System.out.println();
            }
            
            System.out.print(word.guess[1][w]);
        }
        
        System.out.println();
        
        // prints out blank lines.
        for(int q = 0; q < word.word.length(); q++ ) {
            System.out.print("-");
        }
        
        System.out.println();
    }

    /**
     * Displays a bomb based on how
     * many guesses are incorrect,
     * will end game if you get
     * three guesses incorrect
     * @param count
     */
    public void bomb(int count) {
        if(chance == 0) {
            System.out.println("      *");
            System.out.println("     /");
            System.out.println("    /");
        }
        
        if(chance == 1) {
            System.out.println("      *");
            System.out.println("    /");
        }
        
        if(chance == 2) {
            System.out.println("    *");;
        }
        
        // Prints this bomb when you
        // have guessed wrong three times
        if(chance == 3) {
            System.out.println(" *   *");
            System.out.println("    ___|__   *");
            System.out.println("   */_______\\  *");
            System.out.println("  *  |_______|  *");
            System.out.println(" *  \\______/  *"   );
            System.out.println("The bomb exploded!");
            System.out.println("The word was " + word.returnWord());
            System.exit(0);
        }
        
        // Used as base of bomb when you 
        // have not obtained three wrong guesses
        if(chance < 3) {
            System.out.println(" ___|__");
            System.out.println("/       \\");
            System.out.println("|       |");
            System.out.println("\\______/");
        }
    }

    /**
     * Prints out how many letters 
     * the word contains and prints
     * out the starting bomb
     * @param word
     */
    public void startingOutput(String word) {
        System.out.println("The Bomb has " + word.length() + " letters");
        bomb(chance);
    }

    /**
     * Prints out directions and
     * the hint
     */
    public void startScreen() {
        System.out.println("You must defuse the bomb! \nEnter your letter to guess!");
        System.out.println("Hint: " + word.returnHint());
    }

    /**
     * Prints out victory screen
     */
    public void complete() {
        System.out.println("Congratulations, you have defused the bomb!");
        System.out.println("Would you like to play again? [y/n] ");
    }

}
