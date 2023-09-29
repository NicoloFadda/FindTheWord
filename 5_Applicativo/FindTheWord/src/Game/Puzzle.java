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

//TODO 
//definire tutte le direzioni --> FATTO
//rinominare canBe.. in isInBounds generica, non solo H o D o V --> FATTO
//se insert parola fallisce (per vari motivi) uscire con return NON riprovare a caso dentro la funzione
//non usare parole random, cominciare con un set controllato con coordinate controllate
//metodo diagonaleTRBL
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
    public boolean isInBoundsHorizontal(String word, int col) {  
        int maxCol = puzzle[0].length;
        int wordLength = word.length();
        return col + wordLength <= maxCol;
    }
    //2. METODO DI CONTROLLO DIAGONALE TOP-LEFT-BOTTOM-RIGHT
    public boolean isInBoundsDiagonalTLBR(String word, int col, int row) {
        int maxRow = puzzle.length;
        int maxCol = puzzle[0].length;
        int wordLength = word.length();
        return row + wordLength <= maxRow && col + wordLength <= maxCol;
    }
    //3. METODO DI CONTROLLO AL CONTRARIO
    public boolean isInBoundsInverse(String word, int col) {
        
        int wordLength = word.length();
        return col - wordLength >= 0;
    }
    //4. METODO DI CONTROLLO VERTICALE
    public boolean isInBoundsVertical(String word, int row) {
        int maxRow = puzzle.length;
        int wordLength = word.length();
        return row + wordLength <= maxRow;
    }
    //5. METODO DI CONTROLLO DIAGONALE TOP-RIGHT-BOTTOM-LEFT
    public boolean isInBoundsDiagonalTRBL(String word, int col, int row) {
        int maxRow = puzzle.length;
        int maxCol = puzzle[0].length;
        int wordLength = word.length();
        return row + wordLength <= maxRow && col - wordLength >= maxCol;
    }
    public boolean isOverlapping(){
        
        return false;
    }
    public void insertHorizontalWord(String word, int row, int col){
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            puzzle[row][col + i] = word.charAt(i);
        }
    }
    public void insertDiagonalWordTLBR(String word, int row, int col){
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            puzzle[row + i][col + i] = word.charAt(i); //ALGORITMO DIAGONALE
        }
    }
    public void insertDiagonalWordTRBL(String word, int row, int col){
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            puzzle[row - i][col + i] = word.charAt(i); //ALGORITMO DIAGONALE
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
    public int checkOrientation(int orientation){
        int orRan = random.nextInt(-4,-1);
        return orRan;
    }
    //METODO PRINCIPALE - POSIZIONA LE PAROLE NELLA GRIGLIA
    /**
     * 
     * TODO: 
     * 1.CREARE METODI SEPARATI PER I CONTROLLI PER LA PULIZIA DEL CODICE (O,V,D,INV) --> FATTO
 2. CREARE METODO SEPARATO PER IL CONTROLLO DELLA LUNGHEZZA DELLA PAROLA --> FATTO
 3. CREARE METODO SEPARATO PER CONTROLLO SOVRAPPOSIZIONE --> DA FARE
 3.1 IL METODO DEVE POTER ACCETTARE UNA SOLA LETTERA DI SOVRAPPOSIZIONE --> DA FARE
 3.1.1 IL METODO NON DEVE ACCETTARE LA SOVRAPPOSIZIONE NELLA STESSA DIREZIONE --> DA FARE
     * 
     * @param word
     * @param row
     * @param col
     * @param orientation
     * @param isInverse
     */

    public void setWord(String word, int row, int col, int orientation, boolean isInverse) {
        
        //1. Memorizzo le variabili utili
        int horizontal = -1;
        int vertical = -2;
        int diagonalTLBR = -3;
        int diagonalTRBL = -4;
        
        //2. Controllo se la parola è orizzontale
        if (checkOrientation(orientation) == horizontal) {
            
            //2.1 Controllo se la parola può esistere nella griglia o è troppo lunga
            if (isInBoundsHorizontal(word,col)) {
                
                //2.1.1 Inserisco la parola carattere per carattere
                insertHorizontalWord(word,row,col);
                
            //2.2 Se la parola è troppo lunga userà questa condizione
            } else {
                
                //2.2.1 Ritornare false
                
            }
            
        //3. Controllo se la parola è in diagonale
        } else if (checkOrientation(orientation) == diagonalTLBR){
            
            //3.1 Controllo se la parola può esistere nella griglia o è troppo lunga
            if (isInBoundsDiagonalTLBR(word,col,row)) {
                
                //3.1.1 Inserisco la parola carattere per carattere
                insertDiagonalWordTLBR(word,row,col);
                
            //3.2 Se la parola è troppo lunga userà questa condizione
            } else {
                
                //3.2.1 Ritornare false
                
            }
            
        //4. Controllo se la parola è al contrario
        } else if (isInverse) {
            
            //4.1 Controllo se la parola può esistere nella griglia o è troppo lunga
            if (isInBoundsInverse(word,col)) {
                
                //4.1.1 Inserisco la parola carattere per carattere
                insertInverseWord(word,row,col);
                
            //4.2 Se la parola è troppo lunga userà questa condizione
            } else {
                
                //4.2.1 Ritornare false

            }
            
        //5. Se non è nessuna delle precedenti allora è in verticale
        } else if(checkOrientation(orientation) == vertical){
            
            //5.1 Controllo se la parola può esistere nella griglia o è troppo lunga
            if (isInBoundsVertical(word, row)) {
                
                //5.1.1 Inserisco la parola carattere per carattere
                insertVerticalWord(word,row,col);
                
            //5.2 Se la parola è troppo lunga userà questa condizione
            } else {
                
                //5.2.1 Ritornare false
                
            }
        }else if(checkOrientation(orientation) == diagonalTLBR){
            //3.1 Controllo se la parola può esistere nella griglia o è troppo lunga
            if (isInBoundsDiagonalTLBR(word,col,row)) {
                
                //3.1.1 Inserisco la parola carattere per carattere
                insertDiagonalWordTLBR(word,row,col);
                
            //3.2 Se la parola è troppo lunga userà questa condizione
            } else {
                
                //3.2.1 Ritornare false
                
            }
        }
    }

    public static void main(String[] args) {

        //1. FARE IN MODO CHE LA PAROLA DA SETTARE SIA RANDOM TRA TUTTE LE LETTERE DEL FILE DELLE PAROLE$
        //1.1 FARE IN MODO CHE DA UN ARRAY STAMPA LE PAROLE
        
        //Inizializzo il puzzle con le righe e colonne impostate
        //In seguito sarà da fare in modo che l'utente possa scegliere la grandezza
        int maxRow = 15;
        int maxCol = 15;
        Puzzle p = new Puzzle(maxRow, maxCol);
        //Inizializzo il random per poi inserire le parole
        Random random = new Random();
        //Parole di prova (dovrà essere sostituita dalle parole del file)
        String[] parole = {"CIAO","FADDA","JACKOPO","ENEA","MARCO","RICH"};

        //Posizioni della parola
        for (String word : parole) {
            int row = random.nextInt(maxRow);
            int col = random.nextInt(maxCol);

            boolean isInverse = random.nextBoolean();
            int orientation = random.nextInt(-4,-1);
            

            p.setWord(word, row, col, orientation, isInverse);
        }
        
        
        
        //Massima lunghezza della parola
        /*int maxLength = Math.max(word.length(), 20); */
        //Setto la parola
        
        
        //Riempo il puzzle di trattini
        p.fillPuzzle();
        //Stampo il puzzle
        p.displayPuzzle();
    }

}
