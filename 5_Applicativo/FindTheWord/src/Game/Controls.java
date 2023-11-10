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

    //Metodo da fare unico per orientation
    public int checkFinalOrientation(){
        return 0;
    }
    
    //NON VIENE MAI USATO
    public int checkOrientation(int orientation) {
        return switch (orientation) {
            case Consts.costanti.HORIZONTAL ->
                orientation;
            case Consts.costanti.VERTICAL ->
                orientation;
            case Consts.costanti.DIAGONAL_TLBR ->
                orientation;
            case Consts.costanti.DIAGONAL_BLTR ->
                orientation;
            case Consts.costanti.DIAGONAL_TRBL ->
                orientation;
            case Consts.costanti.DIAGONAL_BRTL ->
                orientation;
            case Consts.costanti.HORIZONTAL_INVERSE ->
                orientation;
            case Consts.costanti.VERTICAL_INVERSE ->
                orientation;
            default ->
                0;
        };
    }
    //Metodo da fare unico per isInBounds
    public boolean isInBounds(String word, int row, int col, int orientation, Puzzle board) { 
                
        if(checkOrientation(orientation) == orientation){
            return switch (orientation) {
            case Consts.costanti.HORIZONTAL ->
                isInBoundsHorizontal(word, col, board);
            case Consts.costanti.VERTICAL ->
                isInBoundsVertical(word, row, board);
            case Consts.costanti.DIAGONAL_TLBR ->
                isInBoundsDiagonalTLBR(word, col, row, board);
            case Consts.costanti.DIAGONAL_BLTR ->
                isInBoundsDiagonalBLTR(word, col, row, board);
            case Consts.costanti.DIAGONAL_TRBL ->
                isInBoundsDiagonalTRBL(word, col, row, board);
            case Consts.costanti.DIAGONAL_BRTL ->
                isInBoundsDiagonalBRTL(word, col, row, board);
            case Consts.costanti.HORIZONTAL_INVERSE ->
                isInBoundsInverseHorizontal(word, col);
            case Consts.costanti.VERTICAL_INVERSE ->
                isInBoundsInverseVertical(word, col);
            default ->
                false;
            };
        }else{
            return false;
        }
    }
    
    //1. METODO DI CONTROLLO ORIZZONTALE
    public boolean isInBoundsHorizontal(String word, int col, Puzzle board) {
        int maxCol = board.getColums();
        int wordLength = word.length();
        if(col + wordLength <= maxCol){
            return true;
        }else{
            return false;
        }
    }

    //2. METODO DI CONTROLLO VERTICALE
    public boolean isInBoundsVertical(String word, int row, Puzzle board) {
        int maxRow = board.getRows();
        int wordLength = word.length();
        if(row + wordLength <= maxRow){
            return true;
        }else{
            return false;
        }
    };

    //3. METODO DI CONTROLLO DIAGONALE BOTTOM-LEFT-TOP-RIGHT
    public boolean isInBoundsDiagonalBLTR(String word, int col, int row, Puzzle board) {
        int maxRow = board.getRows();
        int maxCol = board.getColums();
        int wordLength = word.length();
        
        if (col < 0 || col >= maxCol || row < 0 || row >= maxRow) {
            return false;
        }else if(col + wordLength <= maxCol && row - wordLength >= 0){
            return true;
        }else{
            return false;
        }
    }
    //4. METODO DI CONTROLLO DIAGONALE BOTTOM-RIGHT-TOP-LEFT 

    public boolean isInBoundsDiagonalBRTL(String word, int col, int row, Puzzle board) { //FUNZIONA
        int maxCol = board.getColums();
        int wordLength = word.length();
        if(row + 1 - wordLength >= 0 && col >= wordLength - 1){
            return true;
        }else{
            return false;
        }
    }

    //5. METODO DI CONTROLLO DIAGONALE TOP-RIGHT-BOTTOM-LEFT
    public boolean isInBoundsDiagonalTRBL(String word, int col, int row, Puzzle board) { //FUNZIONA
        int maxRow = board.getRows();
        int maxCol = board.getColums();
        int wordLength = word.length();
        if(row + wordLength <= maxRow && col + 1 >= wordLength && col <= maxCol - 1){
            return true;
        }else{
            return false;
        }
    }

    //6. METODO DI CONTROLLO DIAGONALE TOP-LEFT-BOTTOM-RIGHT
    public boolean isInBoundsDiagonalTLBR(String word, int col, int row, Puzzle board) {
        int maxRow = board.getRows();
        int maxCol = board.getColums();
        int wordLength = word.length();
        if(row + wordLength <= maxRow && col + wordLength <= maxCol){
            return true;
        }else{
            return false;
        }
    }

    //7. METODO DI CONTROLLO AL CONTRARIO ORIZZONTALE
    public boolean isInBoundsInverseHorizontal(String word, int col) {
        int wordLength = word.length();
        if(col - wordLength >= 0){
            return true;
        }else{
            return false;
        }
    }

    //8. METODO DI CONTROLLO AL CONTRARIO VERTICALE
    public boolean isInBoundsInverseVertical(String word, int row) {
        int wordLength = word.length();
        if(row - wordLength >= 0){
            return true;
        }else{
            return false;
        }
    }


    //8. METODO DI CONTROLLO OVERLAP: FALSE --> OVERLAP | TRUE --> STESSA LETTERA --> NO OVERLAP
    public boolean isValidOverlapping(String word, int row, int col, int orientation, Puzzle board) {
        int wordLength = word.length();
        int originalRow = row;
        int originalCol = col;
        for (int i = 0; i < wordLength; i++) {
            //Se non è un trattino (quindi non vuota)

            char wordChar = word.charAt(i);
            char boardChar = board.getValue(row, col);
            //if (board.getValue(row, col) == '-' || board.getValue(row, col) == word.charAt(i)) {
            if (boardChar == '-' || boardChar == wordChar) {
                //all good
            } else {
                System.out.println("La parola " + word.toUpperCase() + " @("+originalRow+";"+originalCol+")" + " orient " + orientation + " charIndex "+ i +" conflitto con " + boardChar + "@("+row+";"+col+")");
                return false;
            }

            if (orientation == Consts.costanti.HORIZONTAL) {
                col++;
            }
            if (orientation == Consts.costanti.HORIZONTAL_INVERSE) {
                col--;
            }
            if (orientation == Consts.costanti.VERTICAL) {
                row++;
            }
            if (orientation == Consts.costanti.VERTICAL_INVERSE) {
                row--;
            }
            if (orientation == Consts.costanti.DIAGONAL_BLTR) {
                row--;
                col++;
            }
            if (orientation == Consts.costanti.DIAGONAL_BRTL) {
                row--;
                col--;
            }
            if (orientation == Consts.costanti.DIAGONAL_TLBR) {
                row++;
                col++;
            }
            if (orientation == Consts.costanti.DIAGONAL_TRBL) {
                row++;
                col--;
            }

        }
        return true;
    }
    
}
