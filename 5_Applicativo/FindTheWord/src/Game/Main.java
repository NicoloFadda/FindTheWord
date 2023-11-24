package Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nicolo.fadda
 * @version 06.10.2023
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {

        int maxRow = 10;
        int maxCol = 10;
        
        boolean modBambini = false;

        Puzzle p = new Puzzle(maxRow, maxCol);
        try {
            p.displayPuzzle();
        } catch (FileNotFoundException ex) {
            System.out.println("Errore di File non trovato");
        }
        if (p.getDictionary() != null && !p.getDictionary().isEmpty()) {
            System.out.println("");
            System.out.println("Celle rimanenti per la parola segreta: " + p.getRemainingCells());
            System.out.println("Parole totali: " + p.getArWordsSize());
            if (!modBambini) {
                System.out.println("Parola Segreta: " + p.getSecretWord());
            }
            System.out.print("Parole: ");
            p.showWords();
        }else{
            System.out.println("Errore nel dizionario nullo o vuoto");
        }

        
    }
}
