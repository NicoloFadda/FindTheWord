package Game;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 
 * @author nicolo.fadda
 * @version 15.09.2023
 * 
 */
public class Puzzle {
    private char[][] puzzle;
    private Random random;
    
    public Puzzle(int rows, int columns) {
    puzzle = new char[rows][columns];
    random = new Random();
    }
    
    public void setWord(String word, int row, int col, boolean isHorizontal) {
        int length = word.length();
        if (isHorizontal) {
            for (int i = 0; i < length; i++) {
                puzzle[row][col + i] = word.charAt(i);
            }
        } else {
            for (int i = 0; i < length; i++) {
                puzzle[row + i][col] = word.charAt(i);
            }
        }
    }
    
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
    public static void main(String[] args) {
        Puzzle p = new Puzzle(20,20);
        //1. FARE IN MODO CHE LA PAROLA DA SETTARE SIA RANDOM TRA
            //TUTTE LE LETTERE DEL FILE DELLE PAROLE
        //2. FARE IN MODO CHE LA ROW E COL SIANO RANDOM
        //3. FARE IN MODO CHE LE POSIZIONI SIANO CASUALI
        
        //4. FARE IN MODO CHE LA LUNGHEZZA DELLE PAROLE NON SUPERINO
            //LA LUNGHEZZA TOTALE DELLA GRIGLIA
        p.setWord("CIAO", 0, 0, true);
        p.setWord("PROVA",0,18,true);
        p.fillPuzzleRandomly();
        p.displayPuzzle();
        
    }

}
