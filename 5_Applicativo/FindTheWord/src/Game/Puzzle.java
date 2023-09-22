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
                if (puzzle[i][j] == '\u0000') {//Controllo se la cella sia vuota
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
    //1. METODO DI CONTROLLO ORIZZONTALE
    public boolean canBeHorizontal(String word, int col) {  
        int maxCol = puzzle[0].length;
        int wordLength = word.length();
        return col + wordLength <= maxCol;
    }
    //2. METODO DI CONTROLLO DIAGONALE
    public boolean canBeDiagonal(String word, int col, int row) {
        int maxRow = puzzle.length;
        int maxCol = puzzle[0].length;
        int wordLength = word.length();
        return row + wordLength <= maxRow && col + wordLength <= maxCol;
    }
    //3. METODO DI CONTROLLO AL CONTRARIO
    public boolean canBeInverse(String word, int col) {
        
        int wordLength = word.length();
        return col - wordLength >= 0;
    }
    //4. METODO DI CONTROLLO VERTICALE
    public boolean canBeVertical(String word, int row) {
        int maxRow = puzzle.length;
        int wordLength = word.length();
        return row + wordLength <= maxRow;
    }
    public void insertHorizontalWord(String word, int row, int col){
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            puzzle[row][col + i] = word.charAt(i);
        }
    }
    public void insertDiagonalWord(String word, int row, int col){
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            puzzle[row + i][col + i] = word.charAt(i); //ALGORITMO DIAGONALE
        }
    }
    public void insertInverseWord(String word, int row, int col){
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            puzzle[row][col - i] = word.charAt(i); //ALGORITMO INVERSO
        }
    }
    public void insertVerticalWord(String word, int row, int col){
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            puzzle[row + i][col] = word.charAt(i); //ALGORITMO VERTICALE
        }
    }
    //METODO PRINCIPALE - POSIZIONA LE PAROLE NELLA GRIGLIA
    /**
     * 
     * TODO: 
     * 1.CREARE METODI SEPARATI PER I CONTROLLI PER LA PULIZIA DEL CODICE (O,V,D,INV)
 2. CREARE METODO SEPARATO PER IL CONTROLLO DELLA LUNGHEZZA DELLA PAROLA
 3. CREARE METODO SEPARATO PER CONTROLLO SOVRAPPOSIZIONE
 3.1 IL METODO DEVE POTER ACCETTARE UNA SOLA LETTERA DI SOVRAPPOSIZIONE
 3.1.1 IL METODO NON DEVE ACCETTARE LA SOVRAPPOSIZIONE NELLA STESSA DIREZIONE
     * 
     * @param word
     * @param row
     * @param col
     * @param isHorizontal
     * @param isDiagonal
     * @param isInverse
     */

    public void setWord(
            
            //PARAMETRI PER IL METODO\\
            String word, int row, int col,
            boolean isHorizontal, boolean isDiagonal, boolean isInverse
            //PARAMETRI PER IL METODO\\
            
    ) {
        //1. Memorizzare i massimi della griglia per evitare IndexOutOfBounds
        int wordLength = word.length();
        int maxRow = puzzle.length;
        int maxCol = puzzle[0].length;
        
        //2. Controllo se la parola è orizzontale
        if (isHorizontal) {
            
            //2.1 Controllo se la parola può esistere nella griglia o è troppo lunga
            if (canBeHorizontal(word,col)) {
                
                //2.1.1 Inserisco la parola carattere per carattere
                insertHorizontalWord(word,row,col);
                
            //2.2 Se la parola è troppo lunga userà questa condizione
            } else {
                
                //2.2.1 Genera una nuova colonna casuale
                int newCol = random.nextInt(maxCol - wordLength + 1); 
                
                //2.2.2 Inserisco la parola carattere per carattere
                insertHorizontalWord(word,row,newCol);
                
            }
            
        //3. Controllo se la parola è in diagonale
        } else if (isDiagonal) {
            
            //3.1 Controllo se la parola può esistere nella griglia o è troppo lunga
            if (canBeDiagonal(word,col,row)) {
                
                //3.1.1 Inserisco la parola carattere per carattere
                insertDiagonalWord(word,row,col);
                
            //3.2 Se la parola è troppo lunga userà questa condizione
            } else {
                
                //3.2.1 Genera una nuova riga e colonna casuale
                int newRow = random.nextInt(maxRow - wordLength + 1); 
                int newCol = random.nextInt(maxCol - wordLength + 1);
                
                //3.2.2 Inserisco la parola carattere per carattere
                insertDiagonalWord(word,newRow,newCol);
                
            }
            
        //4. Controllo se la parola è al contrario
        } else if (isInverse) {
            
            //4.1 Controllo se la parola può esistere nella griglia o è troppo lunga
            if (canBeInverse(word,col)) {
                
                //4.1.1 Inserisco la parola carattere per carattere
                insertInverseWord(word,row,col);
                
            //4.2 Se la parola è troppo lunga userà questa condizione
            } else {
                
                //4.2.1 Genera una nuova colonna casuale
                int newCol = random.nextInt(maxCol - wordLength + 1);
                
                //4.2.2 Inserisco la parola carattere per carattere
                insertInverseWord(word,row,newCol);
                
            }
            
        //5. Se non è nessuna delle precedenti allora è in verticale
        } else {
            
            //5.1 Controllo se la parola può esistere nella griglia o è troppo lunga
            if (canBeVertical(word, row)) {
                
                //5.1.1 Inserisco la parola carattere per carattere
                insertVerticalWord(word,row,col);
                
            //5.2 Se la parola è troppo lunga userà questa condizione
            } else {
                
                //5.2.1 Genera una nuova riga casuale
                int newRow = random.nextInt(maxRow - wordLength + 1); 
                
                //5.2.2 Inserisco la parola carattere per carattere
                insertVerticalWord(word,newRow,col);
                
            }
        }
    }

    public static void main(String[] args) {

        //1. FARE IN MODO CHE LA PAROLA DA SETTARE SIA RANDOM TRA TUTTE LE LETTERE DEL FILE DELLE PAROLE
        
        //Inizializzo il puzzle con le righe e colonne impostate
        //In seguito sarà da fare in modo che l'utente possa scegliere la grandezza
        Puzzle p = new Puzzle(20, 20);
        //Inizializzo il random per poi inserire le parole
        Random random = new Random();

        //Parola di prova
        String word = "ENEA"; 
        //Massima lunghezza della parola
        int maxLength = Math.max(word.length(), 20); 

        //Posizioni della parola
        int row = random.nextInt(20); // Genera una riga casuale tra 0 e 19
        int col = random.nextInt(20); // Genera una colonna casuale tra 0 e 19

        //Booleano per decidere la direzione
        boolean isHorizontal = random.nextBoolean(); // Genera un valore booleano casuale
        boolean isDiagonal = random.nextBoolean(); // Genera un valore booleano casuale
        boolean isInverse = random.nextBoolean(); // Genera un valore booleano casuale

        //Setto la parola
        p.setWord(word, row, col, isHorizontal, isDiagonal, isInverse);
        //Riempo il puzzle di trattini
        p.fillPuzzle();
        //Stampo il puzzle
        p.displayPuzzle();
    }

}
