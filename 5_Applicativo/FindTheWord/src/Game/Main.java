package Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author nicolo.fadda
 * @version 06.10.2023
 *
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        int maxRow = 10;
        int maxCol = 10;
        
        boolean modBambini = false;
        
        ArrayList<String> dictionary = new ArrayList();

        Puzzle p = new Puzzle(maxRow, maxCol);

        p.displayPuzzle(dictionary);
        
        System.out.println("");
        System.out.println("Celle rimanenti per la parola segreta: " + p.getRemainingCells());
        System.out.println("Parole totali: " + p.getArWordsSize());
        if(!modBambini){
            System.out.println("Parola Segreta: " + p.getSecretWord());
        }
        System.out.print("Parole: ");
        p.showWords();
        
    }
}
