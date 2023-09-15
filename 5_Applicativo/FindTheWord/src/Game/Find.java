package Game;

import java.util.Random;

/**
 * 
 * @author nicolo.fadda
 * @version 15.09.2023
 * 
 */
public class Find {
    private char[][] puzzle;
    private Random random;
    
    
    public void fillPuzzleRandomly() {
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                if (puzzle[i][j] == '\u0000') { // Check if cell is empty
                    puzzle[i][j] = (char) (random.nextInt(26) + 'A'); // Generate a random letter
                }
            }
        }
    }
    public void displayPuzzle() {
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                System.out.print(puzzle[i][j] + " ");
            }
            System.out.println();
        }
    }
}
