package Game;

import static java.lang.Math.random;
import java.util.Random;


/**
 *
 * @author nicolo.fadda
 * @version 15.09.2023
 *
 */
public class Controls {   

    
    
    public int checkOrientation(int orientation){
        if(orientation == Consts.costanti.HORIZONTAL){
            return orientation;
        }else if(orientation == Consts.costanti.VERTICAL){
            return orientation;
        }else if(orientation == Consts.costanti.DIAGONAL_TLBR){
            return orientation;
        }else if(orientation == Consts.costanti.DIAGONAL_BLTR){
            return orientation;
        }else if(orientation == Consts.costanti.DIAGONAL_TRBL){
            return orientation;
        }else if(orientation == Consts.costanti.DIAGONAL_BRTL){
            return orientation;
        }else if(orientation == Consts.costanti.HORIZONTAL_INVERSE){
            return orientation;
        }else if(orientation == Consts.costanti.VERTICAL_INVERSE){
            return orientation;
        }else{
            return 0;
        }
    }

    
    //1. METODO DI CONTROLLO ORIZZONTALE
    public boolean isInBoundsHorizontal(String word, int col, Puzzle board) {  
        int maxCol = board.getColums();
        int wordLength = word.length();
        return col + wordLength <= maxCol;
    }
    //2. METODO DI CONTROLLO VERTICALE
    public boolean isInBoundsVertical(String word, int row, Puzzle board) {
        int maxRow = board.getRows();
        int wordLength = word.length();
        return row + wordLength <= maxRow;
    }
    //3. METODO DI CONTROLLO DIAGONALE BOTTOM-LEFT-TOP-RIGHT
    public boolean isInBoundsDiagonalBLTR(String word, int col, int row, Puzzle board) {
        int maxRow = board.getRows();
        int maxCol = board.getColums();
        int wordLength = word.length();
        //variabili x debug
        int r = row;
        int c = col;
        String w = word;
        int p = row+wordLength;
        int z = col-wordLength;
        //----------------
        if (col < 0 || col >= maxCol || row < 0 || row >= maxRow) {
        return false;
        }
        return col + wordLength <= maxCol && row - wordLength >= 0;
    }
     //4. METODO DI CONTROLLO DIAGONALE BOTTOM-RIGHT-TOP-LEFT 
    public boolean isInBoundsDiagonalBRTL(String word, int col, int row, Puzzle board) { //FUNZIONA
        int maxCol = board.getColums();
        int wordLength = word.length();
        return row+1 - wordLength >= 0 && col >= wordLength-1;
    }
    
     //5. METODO DI CONTROLLO DIAGONALE TOP-RIGHT-BOTTOM-LEFT
    public boolean isInBoundsDiagonalTRBL(String word, int col, int row, Puzzle board) { //FUNZIONA
        int maxRow = board.getRows();
        int maxCol = board.getColums();
        int wordLength = word.length();
        return row + wordLength <= maxRow && col+1 >= wordLength && col <= maxCol-1;
    }
    //6. METODO DI CONTROLLO DIAGONALE TOP-LEFT-BOTTOM-RIGHT
    public boolean isInBoundsDiagonalTLBR(String word, int col, int row, Puzzle board) {
        int maxRow = board.getRows();
        int maxCol = board.getColums();
        int wordLength = word.length();
        return row + wordLength <= maxRow && col + wordLength <= maxCol;
    }
    //7. METODO DI CONTROLLO AL CONTRARIO ORIZZONTALE
    public boolean isInBoundsInverseHorizontal(String word, int col) {
        
        int wordLength = word.length();
        return col - wordLength >= 0;
    }
    //8. METODO DI CONTROLLO AL CONTRARIO VERTICALE
    public boolean isInBoundsInverseVertical(String word, int row){
        int wordLength = word.length();
        return row - wordLength >= 0;
    }

    //8. METODO DI CONTROLLO OVERLAP: FALSE --> OVERLAP | TRUE --> STESSA LETTERA --> NO OVERLAP
    public boolean isOverlapping(String word, int row, int col, int orientation, Puzzle board) {
        int wordLength = word.length();
        //Controllo se la lettera alla posizione x è '-' (vuota) o esiste, se esiste 
        //  controllo se è uguale
        for (int i = 0; i < wordLength; i++) {
            //Se non è vuota
            if (board.getValue(row, col) != '-') {
                //Se non è la stessa lettera
                if (board.getValue(row, col) != word.charAt(i)) {
                    return false;
                //Se è la stessa lettera
                }else{
                    return true;
                }
            }
        }
        return true;
    }
}

