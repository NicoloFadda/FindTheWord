package Game;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author nicolo.fadda
 * @version 15.09.2023
 *
 */
public class Puzzle{

    private Controls controls;
    private char[][] puzzle;
    private Random random;
    private InsertWords insertWord;
    private int rows;
    private int cols;

    public Puzzle(int rows, int columns) {
        this.cols = columns;
        this.rows = rows;
        this.puzzle = new char[rows][columns];
        random = new Random();
        controls = new Controls();
        insertWord = new InsertWords();

    }

    public void fillPuzzle() {
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                if (puzzle[i][j] == '\u0000') {//Controllo se la cella sia vuota
                    puzzle[i][j] = '-';
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


    public char getValue(int row,int col) {
        return this.puzzle[row][col];
    }
    
    public int getRows(){
        return this.rows;
    }
    
    public int getColums(){
        return this.cols;
    }

    public void setPuzzle(char[][] puzzle) {
        this.puzzle = puzzle;
    }
    
    //METODO PRINCIPALE - POSIZIONA LE PAROLE NELLA GRIGLIA
    /**
     * @param word
     * @param row
     * @param col
     * @param orientation
     * @param isInverse
     */
    //TODO (27.10)
    //Da mettere boolean quando finita pulizia codice!
    //Da fare metodo unico per checkOrientation
    //Da fare metodo unico per IsInBounds
    //Da fare metodo unico per InsertWord
    
    
    
    public void setWord(String word, int row, int col, int orientation) {

        if(controls.isInBounds(word, row, col, orientation, this)){
            insertWord.insertWord(word, row, col, orientation, puzzle);
        }
    }
}

//In seguito sarà da fare in modo che l'utente possa scegliere la grandezza

//FATTI:
//1. ORIZZONTALE
//2. VERTICALE
//3. INVERSO
//4. ALTO-SINISTRA-BASSO-DESTRA
//5. BASSO-SINISTRA-ALTO-DESTRA
//1. BASSO-DESTRA-ALTO-SINISTRA
//2. ALTO-DESTRA-BASSO-SINISTRA
