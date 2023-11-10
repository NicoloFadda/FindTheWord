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
        
        Random random = new Random();
        //10.11.2023 --> DA FARE IN UN ALTRO FILE
        ArrayList<String> dictionary = new ArrayList();
        
        int maxRow = 15; //In seguito fare in modo che utente possa scegliere
        int maxCol = 15; //In seguito fare in modo che utente possa scegliere
        
        Puzzle p = new Puzzle(maxRow, maxCol);

        //Riempo il puzzle di trattini
        p.fillPuzzle();
        
        //10.11.2023 --> DA FARE IN UN ALTRO FILE
        File dizionario = new File("src/Assets/dizionario.txt");
        Scanner scanner = new Scanner(dizionario);
        
        //10.11.2023 --> DA FARE IN UN ALTRO FILE
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            line = line.toUpperCase();
            dictionary.add(line);
        }
        //10.11.2023 --> DA FARE IN UN ALTRO FILE
        Collections.shuffle(dictionary);
        
        for(String word : dictionary) {
            int row = random.nextInt(maxRow);
            int col = random.nextInt(maxCol);

            int orientation = random.nextInt(-8, -1);

            p.setWord(word, row, col, orientation); 
        }
        //Stampo il puzzle
        p.displayPuzzle();
        
        p.showWords();
    }
}
