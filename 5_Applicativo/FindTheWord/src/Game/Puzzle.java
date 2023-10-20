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
    public void setWord(String word, int row, int col, int orientation) {

        //ORIZZONTALE
        if (controls.checkOrientation(orientation) == Consts.costanti.HORIZONTAL) { //FUNZIONA
            if (controls.isInBoundsHorizontal(word, col, this)) {

                //Inserisco la parola carattere per carattere
                while(!controls.isOverlapping(word, row, col, orientation, this)){
                    insertWord.insertHorizontalWord(word, row, col, puzzle);
                }
            } else {
                //Rigenerare la parola
                System.out.println("La parola orizzontale " + word.toUpperCase() + " non viene generata" + " " + row + " " + col);
                
            }
        //VERTICALE
        } else if (controls.checkOrientation(orientation) == Consts.costanti.VERTICAL) { //FUNZIONA
            if (controls.isInBoundsVertical(word, row,this)) {

                //Inserisco la parola carattere per carattere
                while(!controls.isOverlapping(word, row, col, orientation, this)){
                    insertWord.insertVerticalWord(word, row, col, puzzle);
                }
            } else {
                //Rigenerare la parola
                System.out.println("La parola verticale " + word.toUpperCase() + " non viene generata" + " " + row + " " + col);
            }
        //DIAGONALE ALTO-SINISTRA-BASSO-DESTRA
        } else if (controls.checkOrientation(orientation) == Consts.costanti.DIAGONAL_TLBR) { //FUNZIONA
            if (controls.isInBoundsDiagonalTLBR(word, col, row,this)) {

                //3.1.1 Inserisco la parola carattere per carattere
                while(!controls.isOverlapping(word, row, col, orientation, this)){
                    insertWord.insertDiagonalWordTLBR(word, row, col, puzzle);
                }
            } else {
                //Rigenerare la parola
                System.out.println("La parola TLBR " + word.toUpperCase() + " non viene generata" + " " + row + " " + col);
            }
        //DIAGONALE BASSO-SINISTRA-ALTO-DESTRA
        } else if (controls.checkOrientation(orientation) == Consts.costanti.DIAGONAL_BLTR) { //FUNZIONA
            if (controls.isInBoundsDiagonalBLTR(word, col, row,this)) {

                //Inserisco la parola carattere per carattere
                while(!controls.isOverlapping(word, row, col, orientation, this)){
                    insertWord.insertDiagonalWordBLTR(word, row, col, puzzle);
                }
            } else {
                //Rigenerare la parola
                System.out.println("La parola BLTR " + word.toUpperCase() + " non viene generata" + " " + row + " " + col);
                
            }
            
        //DIAGONALE ALTO-DESTRA-BASSO-SINISTRA
        } else if (controls.checkOrientation(orientation) == Consts.costanti.DIAGONAL_TRBL) { //FUNZIONA
            if (controls.isInBoundsDiagonalTRBL(word, col, row,this)) {
                //Inserisco la parola carattere per carattere
                while(!controls.isOverlapping(word, row, col, orientation, this)){
                    insertWord.insertDiagonalWordTRBL(word, row, col, puzzle);
                }
                
            }else{
                //Rigenerare la parola
                System.out.println("La parola TRBL " + word.toUpperCase() + " non viene generata" + " " + row + " " + col);
            }
        //DIAGONALE BASSO-DESTRA-ALTO-SINISTRA
        } else if(controls.checkOrientation(orientation) == Consts.costanti.DIAGONAL_BRTL){ //FUNZIONA
            if(controls.isInBoundsDiagonalBRTL(word, col, row,this)){
                //Inserisco la parola carattere per carattere
                while(!controls.isOverlapping(word, row, col, orientation, this)){
                    insertWord.insertDiagonalWordBRTL(word, row, col, puzzle);
                }
                
            }else{
                //Rigenerare la parola
                System.out.println("La parola BRTL " + word.toUpperCase() + " non viene generata" + " " + row + " " + col);
            }
        //INVERSO ORIZZONTALE
        }else if(controls.checkOrientation(orientation) == Consts.costanti.HORIZONTAL_INVERSE){
            if(controls.isInBoundsInverseHorizontal(word,col)){
                //Inserisco la parola carattere per carattere
                while(!controls.isOverlapping(word, row, col, orientation, this)){
                    insertWord.insertInverseWordHorizontal(word, row, col, puzzle);
                }
            }
        }else if(controls.checkOrientation(orientation) == Consts.costanti.VERTICAL_INVERSE){
            if(controls.isInBoundsInverseVertical(word, row)){
                while(!controls.isOverlapping(word, row, col, orientation, this)){
                    //Inserisco la parola carattere per carattere
                    insertWord.insertInverseWordVertical(word, row, col, puzzle);
                }
            }
        }else{
            //Rigenerare la parola
            System.out.println("La parola invertita " + word.toUpperCase() + ", " + orientation + " non viene generata"  + " " + row + " " + col);
        }
    }
}
//1. FARE IN MODO CHE LA PAROLA DA SETTARE SIA RANDOM TRA TUTTE LE LETTERE DEL FILE DELLE PAROLE$
//1.1 FARE IN MODO CHE DA UN ARRAY STAMPA LE PAROLE
//In seguito sarà da fare in modo che l'utente possa scegliere la grandezza

//FATTI:
//1. ORIZZONTALE
//2. VERTICALE
//3. INVERSO
//4. ALTO-SINISTRA-BASSO-DESTRA
//5. BASSO-SINISTRA-ALTO-DESTRA
//1. BASSO-DESTRA-ALTO-SINISTRA
//2. ALTO-DESTRA-BASSO-SINISTRA
