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

    private Controls controls;
    private char[][] puzzle;
    private Random random;

    public Puzzle(int rows, int columns) {
        puzzle = new char[rows][columns];
        random = new Random();
        controls = new Controls();
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

    public void insertHorizontalWord(String word, int row, int col) {
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            puzzle[row][col + i] = word.charAt(i);
        }
    }

    public void insertDiagonalWordTLBR(String word, int row, int col) {
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            puzzle[row + i][col + i] = word.charAt(i); //ALGORITMO DIAGONALE
        }
    }

    public void insertDiagonalWordTRBL(String word, int row, int col) {
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            puzzle[row - i][col + i] = word.charAt(i); //ALGORITMO DIAGONALE
        }
    }

    public void insertInverseWord(String word, int row, int col) {
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            puzzle[row][col - i] = word.charAt(i); //ALGORITMO INVERSO
        }
    }

    public void insertVerticalWord(String word, int row, int col) {
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            puzzle[row + i][col] = word.charAt(i); //ALGORITMO VERTICALE
        }
    }

    //METODO PRINCIPALE - POSIZIONA LE PAROLE NELLA GRIGLIA
    /**
     *
     * TODO: 3. CREARE METODO SEPARATO PER CONTROLLO SOVRAPPOSIZIONE --> DA FARE
     * 3.1 IL METODO DEVE POTER ACCETTARE UNA SOLA LETTERA DI SOVRAPPOSIZIONE
     * --> DA FARE 3.1.1 IL METODO NON DEVE ACCETTARE LA SOVRAPPOSIZIONE NELLA
     * STESSA DIREZIONE --> DA FARE
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
        if (controls.checkOrientation(orientation) == horizontal) {

            //2.1 Controllo se la parola può esistere nella griglia o è troppo lunga
            if (controls.isInBoundsHorizontal(word, col)) {

                //2.1.1 Inserisco la parola carattere per carattere
                insertHorizontalWord(word, row, col);

            //2.2 Se la parola è troppo lunga userà questa condizione
            } else {

                //2.2.1 Ritornare false
            }

            //3. Controllo se la parola è in diagonale
        } else if (controls.checkOrientation(orientation) == diagonalTLBR) {

            //3.1 Controllo se la parola può esistere nella griglia o è troppo lunga
            if (controls.isInBoundsDiagonalTLBR(word, col, row)) {

                //3.1.1 Inserisco la parola carattere per carattere
                insertDiagonalWordTLBR(word, row, col);

            //3.2 Se la parola è troppo lunga userà questa condizione
            } else {

                //3.2.1 Ritornare false
            }

            //4. Controllo se la parola è al contrario
        } else if (isInverse) {

            //4.1 Controllo se la parola può esistere nella griglia o è troppo lunga
            if (controls.isInBoundsInverse(word, col)) {

                //4.1.1 Inserisco la parola carattere per carattere
                insertInverseWord(word, row, col);

            //4.2 Se la parola è troppo lunga userà questa condizione
            } else {

                //4.2.1 Ritornare false
            }

            //5. Se non è nessuna delle precedenti allora è in verticale
        } else if (controls.checkOrientation(orientation) == vertical) {

            //5.1 Controllo se la parola può esistere nella griglia o è troppo lunga
            if (controls.isInBoundsVertical(word, row)) {

                //5.1.1 Inserisco la parola carattere per carattere
                insertVerticalWord(word, row, col);

            //5.2 Se la parola è troppo lunga userà questa condizione
            } else {

                //5.2.1 Ritornare false
            }
        } else if (controls.checkOrientation(orientation) == diagonalTLBR) {
            //3.1 Controllo se la parola può esistere nella griglia o è troppo lunga
            if (controls.isInBoundsDiagonalTLBR(word, col, row)) {

                //3.1.1 Inserisco la parola carattere per carattere
                insertDiagonalWordTLBR(word, row, col);

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
        String[] parole = {"CIAO", "FADDA", "JACKOPO", "ENEA", "MARCO", "RICH"};

        //Posizioni della parola
        for (String word : parole) {
            int row = random.nextInt(maxRow);
            int col = random.nextInt(maxCol);

            boolean isInverse = random.nextBoolean();
            int orientation = random.nextInt(-4, -1);

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
