package Game;

import java.util.Random;

/**
 *
 * @author nicolo.fadda
 * @version 06.10.2023
 *
 */
public class Main {

    public static void main(String[] args) {
        
        Random random = new Random();
        
        int maxRow = 15; //In seguito fare in modo che utente possa scegliere
        int maxCol = 15; //In seguito fare in modo che utente possa scegliere
        
        Puzzle p = new Puzzle(maxRow, maxCol);

        //Parole di prova (dovrà essere sostituita dalle parole del file)
        String[] parole = {"FADDA","JACKOPO","CORTI","ENEA","LUIS","CIOBA",
        "RICHI","FAUL","MARCO"};
        

        //DEBUG OVERLAP
        //p.setWord("ciao",1,0,-1,false);
        //p.setWord("ciao",0,0,-2,false);
        
        //DA DECOMMENTARE QUANDO FINITO INCROCI
        
        for(String word : parole) {
            int row = random.nextInt(maxRow);
            int col = random.nextInt(maxCol);

            boolean isInverse = random.nextBoolean();
            int orientation = random.nextInt(-8, -1);

            p.setWord(word, row, col, orientation); 
        
        }
        
        
        //p.setWord("MARCO", 0, 14, -5);
        //p.setWord("OCA",2,8,-2,false);
        

        //Riempo il puzzle di trattini
        p.fillPuzzle();

        //Stampo il puzzle
        p.displayPuzzle();
    }
}
