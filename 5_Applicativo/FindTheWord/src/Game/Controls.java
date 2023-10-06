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
        
    int maxRow = 10;
    int maxCol = 10;
    Puzzle[][] puzzle = new Puzzle[maxRow][maxCol];
    
    
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
        }else{
            return 0;
        }
    }

    
    //1. METODO DI CONTROLLO ORIZZONTALE
    public boolean isInBoundsHorizontal(String word, int col) {  
        int maxCol = puzzle[0].length;
        int wordLength = word.length();
        return col + wordLength <= maxCol;
    }
    //2. METODO DI CONTROLLO VERTICALE
    public boolean isInBoundsVertical(String word, int row) {
        int maxRow = puzzle.length;
        int wordLength = word.length();
        return row + wordLength <= maxRow;
    }
    //3. METODO DI CONTROLLO DIAGONALE TOP-RIGHT-BOTTOM-LEFT
    public boolean isInBoundsDiagonalBLTR(String word, int col, int row) {
        int maxRow = puzzle.length;
        int maxCol = puzzle[0].length;
        int wordLength = word.length();
        return row + wordLength <= maxRow && col - wordLength <= maxCol;
    }
     //4. METODO DI CONTROLLO DIAGONALE BOTTOM-RIGHT-TOP-LEFT
    public boolean isInBoundsDiagonalBRTL(String word, int col, int row) {
        int maxRow = puzzle.length;
        int maxCol = puzzle[0].length;
        int wordLength = word.length();
        return row - wordLength >= 0 && col + wordLength <= maxCol;
    }
     //5. METODO DI CONTROLLO DIAGONALE TOP-RIGHT-BOTTOM-LEFT
    public boolean isInBoundsDiagonalTRBL(String word, int col, int row) {
        int maxRow = puzzle.length;
        int maxCol = puzzle[0].length;
        int wordLength = word.length();
        return row + wordLength <= maxRow && col + wordLength <= maxCol;
    }
    //6. METODO DI CONTROLLO DIAGONALE TOP-LEFT-BOTTOM-RIGHT
    public boolean isInBoundsDiagonalTLBR(String word, int col, int row) {
        int maxRow = puzzle.length;
        int maxCol = puzzle[0].length;
        int wordLength = word.length();
        return row + wordLength <= maxRow && col + wordLength <= maxCol;
    }
    //7. METODO DI CONTROLLO AL CONTRARIO
    public boolean isInBoundsInverse(String word, int col) {
        
        int wordLength = word.length();
        return col - wordLength >= 0;
    }
    
    public boolean isOverlapping(){
        //Controllare se la cella non è libera
        //Se non è libera ma il char della parola è uguale al char della parola già nella cella
        //--> continua la parola
        //Se non è libera --> cambia posizione della parola
        //Continuare a farlo finchè non trova x celle per n caratteri
        
        return false;
    }
    
    
    
}

