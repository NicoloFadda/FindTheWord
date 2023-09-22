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

    public void fillPuzzle() {
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                if (puzzle[i][j] == '\u0000') { // Check if cell is empty
                    //puzzle[i][j] = (char) (random.nextInt(26) + 'A'); // Generate a random letter
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
    //METODO DI DEBUG - POSIZIONA LE PAROLE NELLA GRIGLIA
    /**
     * 
     * TODO: 
     * 1. CREARE METODI SEPARATI PER I CONTROLLI PER LA PULIZIA DEL CODICE (H,V,D,INV)
     * 2. CREARE METODO SEPARATI PER IL CONTROLLO DELLA LUNGHEZZA DELLA PAROLA
     * 
     */
    
    public void setWord(String word, int row, int col, boolean isHorizontal, boolean isDiagonal, boolean isInverse) {
        //1. Memorizzare i massimi della griglia per evitare IndexOutOfBounds
        int wordLength = word.length();
        int maxRow = puzzle.length;
        int maxCol = puzzle[0].length;
        
        //2. Controllo se la parola è orizzontale
        if (isHorizontal) {
            //2.1 Controllo se la parola può esistere nella griglia o è troppo lunga
            if (col + wordLength <= maxCol) {
                //2.1.1 Inserisco la parola carattere per carattere
                for (int i = 0; i < wordLength; i++) {
                    puzzle[row][col + i] = word.charAt(i);
                }
            //2.2 Se la parola è troppo lunga userà questa condizione
            } else {
                //2.2.1 Genera una nuova colonna casuale
                int newCol = random.nextInt(maxCol - wordLength + 1); 
                //2.2.2 Inserisco la parola carattere per carattere
                for (int i = 0; i < wordLength; i++) {
                    puzzle[row][newCol + i] = word.charAt(i); //ALGORITMO ORIZZONTALE
                }
            }
        //3. Controllo se la parola è in diagonale
        } else if (isDiagonal) {
            //3.1 Controllo se la parola può esistere nella griglia o è troppo lunga
            if (row + wordLength <= maxRow && col + wordLength <= maxCol) {
                //3.1.1 Inserisco la parola carattere per carattere
                for (int i = 0; i < wordLength; i++) {
                    puzzle[row + i][col + i] = word.charAt(i); //ALGORITMO DIAGONALE
                }
            //3.2 Se la parola è troppo lunga userà questa condizione
            } else {
                //3.2.1 Genera una nuova riga e colonna casuale
                int newRow = random.nextInt(maxRow - wordLength + 1); 
                int newCol = random.nextInt(maxCol - wordLength + 1); 
                //3.2.2 Inserisco la parola carattere per carattere
                for (int i = 0; i < wordLength; i++) {
                    puzzle[newRow + i][newCol + i] = word.charAt(i); 
                }
            }
        //4. Controllo se la parola è al contrario
        } else if (isInverse) {
            //4.1 Controllo se la parola può esistere nella griglia o è troppo lunga
            if (col - wordLength >= 0) {
                //4.1.1 Inserisco la parola carattere per carattere
                for (int i = 0; i < wordLength; i++) {
                    puzzle[row][col - i] = word.charAt(i); //ALGORITMO INVERSO
                }
            //4.2 Se la parola è troppo lunga userà questa condizione
            } else {
                //4.2.1 Genera una nuova colonna casuale
                int newCol = random.nextInt(maxCol - wordLength + 1);
                //4.2.2 Inserisco la parola carattere per carattere
                for (int i = 0; i < wordLength; i++) {
                    puzzle[row][newCol + i] = word.charAt(i);
                }
            }
        //5. Se non è nessuna delle precedenti allora è in verticale
        } else {
            //5.1 Controllo se la parola può esistere nella griglia o è troppo lunga
            if (row + wordLength <= maxRow) {
                //5.1.1 Inserisco la parola carattere per carattere
                for (int i = 0; i < wordLength; i++) {
                    puzzle[row + i][col] = word.charAt(i); //ALGORITMO VERTICALE
                }
            //5.2 Se la parola è troppo lunga userà questa condizione
            } else {
                //5.2.1 Genera una nuova riga casuale
                int newRow = random.nextInt(maxRow - wordLength + 1); 
                //5.2.2 Inserisco la parola carattere per carattere
                for (int i = 0; i < wordLength; i++) {
                    puzzle[newRow + i][col] = word.charAt(i);
                }
            }
        }
    }

    public static void main(String[] args) {

        //1. FARE IN MODO CHE LA PAROLA DA SETTARE SIA RANDOM TRA
        //TUTTE LE LETTERE DEL FILE DELLE PAROLE
        //2. FARE IN MODO CHE LA ROW E COL SIANO RANDOM
        //3. FARE IN MODO CHE LE POSIZIONI SIANO CASUALI
        //4. FARE IN MODO CHE LA LUNGHEZZA DELLE PAROLE NON SUPERINO
        //LA LUNGHEZZA TOTALE DELLA GRIGLIA
        Puzzle p = new Puzzle(20, 20);
        Random random = new Random();

        String word = "CIAO"; // Parola di prova
        int maxLength = Math.max(word.length(), 20); // Massima lunghezza della parola

        int row = random.nextInt(20); // Genera una riga casuale tra 0 e 19
        int col = random.nextInt(20); // Genera una colonna casuale tra 0 e 19

        boolean isHorizontal = random.nextBoolean(); // Genera un valore booleano casuale
        boolean isDiagonal = random.nextBoolean(); // Genera un valore booleano casuale
        boolean isInverse = random.nextBoolean(); // Genera un valore booleano casuale

        p.setWord(word, row, col, isHorizontal, isDiagonal, isInverse);
        p.fillPuzzle();
        p.displayPuzzle();
    }

}
