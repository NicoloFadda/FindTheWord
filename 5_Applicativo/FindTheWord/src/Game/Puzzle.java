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
//metodo diagonaleBLTR
public class Puzzle {

    private Controls controls;
    private char[][] puzzle;
    private Random random;
    private InsertWords insertWord;

    public Puzzle(int rows, int columns) {
        puzzle = new char[rows][columns];
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

    //METODO PRINCIPALE - POSIZIONA LE PAROLE NELLA GRIGLIA
    /**
     *
     * TODO: 3. CREARE METODO SEPARATO PER CONTROLLO SOVRAPPOSIZIONE --> DA FARE
     * 3.1 IL METODO DEVE POTER ACCETTARE UNA SOLA LETTERA DI SOVRAPPOSIZIONE
     * --> DA FARE 3.1.1 IL METODO NON DEVE ACCETTARE LA SOVRAPPOSIZIONE NELLA
     * STESSA DIREZIONE --> DA FARE CONTROLLARE PRIMA DELL'INSERT SE SI
     * SOVRAPPONGONO LE PAROLE!!!!!!!!!!!!!
     *
     * @param word
     * @param row
     * @param col
     * @param orientation
     * @param isInverse
     */
    public void setWord(String word, int row, int col, int orientation, boolean isInverse) {

        //ORIZZONTALE
        if (controls.checkOrientation(orientation) == Consts.costanti.HORIZONTAL) { //FUNZIONA
            if (controls.isInBoundsHorizontal(word, col)) {

                //Inserisco la parola carattere per carattere
                insertWord.insertHorizontalWord(word, row, col, puzzle);
            } else {
                //Ritornare false
            }
        //VERTICALE
        } else if (controls.checkOrientation(orientation) == Consts.costanti.VERTICAL) { //FUNZIONA
            if (controls.isInBoundsVertical(word, row)) {

                //Inserisco la parola carattere per carattere
                insertWord.insertVerticalWord(word, row, col, puzzle);
            } else {
                //Ritornare false
            }
        //DIAGONALE ALTO-SINISTRA-BASSO-DESTRA
        } else if (controls.checkOrientation(orientation) == Consts.costanti.DIAGONAL_TLBR) { //FUNZIONA
            if (controls.isInBoundsDiagonalTLBR(word, col, row)) {

                //3.1.1 Inserisco la parola carattere per carattere
                insertWord.insertDiagonalWordTLBR(word, row, col, puzzle);
            } else {
                //Ritornare false
            }
        //DIAGONALE BASSO-SINISTRA-ALTO-DESTRA
        } else if (controls.checkOrientation(orientation) == Consts.costanti.DIAGONAL_BLTR) { //FUNZIONA
            if (controls.isInBoundsDiagonalBLTR(word, col, row)) {

                //Inserisco la parola carattere per carattere
                insertWord.insertDiagonalWordBLTR(word, row, col, puzzle);
            } else {
                //Ritornare false
            }
        //DIAGONALE ALTO-DESTRA-BASSO-SINISTRA
        } else if (controls.checkOrientation(orientation) == Consts.costanti.DIAGONAL_TRBL) {
            if (controls.isInBoundsDiagonalTRBL(word, col, row)) {
                //Inserisco la parola carattere per carattere
                insertWord.insertDiagonalWordTRBL(word, row, col, puzzle);
            }else{
                //Ritornare false
            }
        //DIAGONALE BASSO-DESTRA-ALTO-SINISTRA
        } else if(controls.checkOrientation(orientation) == Consts.costanti.DIAGONAL_BRTL){
            if(controls.isInBoundsDiagonalBRTL(word, col, row)){
                //Inserisco la parola carattere per carattere
                insertWord.insertDiagonalWordBRTL(word, row, col, puzzle);
            }else{
                //Ritornare false
            }
        //INVERSO
        }else if(isInverse){
            if(controls.isInBoundsInverse(word,col)){
                //Inserisco la parola carattere per carattere
                insertWord.insertInverseWord(word, row, col, puzzle);
            }
        }else{
            //Ritornare false
        }
    }
}
//1. FARE IN MODO CHE LA PAROLA DA SETTARE SIA RANDOM TRA TUTTE LE LETTERE DEL FILE DELLE PAROLE$
//1.1 FARE IN MODO CHE DA UN ARRAY STAMPA LE PAROLE
//Inizializzo il puzzle con le righe e colonne impostate
//In seguito sarà da fare in modo che l'utente possa scegliere la grandezza

//FATTI:
//1. ORIZZONTALE
//2. VERTICALE
//3. INVERSO
//4. ALTO-SINISTRA-BASSO-DESTRA
//5. BASSO-SINISTRA-ALTO-DESTRA
//DA FARE:
//1. BASSO-DESTRA-ALTO-SINISTRA
//2. ALTO-DESTRA-BASSO-SINISTRA
