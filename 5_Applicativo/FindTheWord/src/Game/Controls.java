/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import static java.lang.Math.random;
import java.util.Random;

/**
 *
 * @author nicolo.fadda
 */
public class Controls {
    int maxRow = 10;
    int maxCol = 10;
    Random random = new Random();
    Puzzle[][] puzzle = new Puzzle[maxRow][maxCol];
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
        //Controllare se la cella non è libera
        //Se non è libera ma il char della parola è uguale al char della parola già nella cella
        //--> continua la parola
        //Se non è libera --> cambia posizione della parola
        //Continuare a farlo finchè non trova x celle per n caratteri
        
        return false;
    }
    
    public int checkOrientation(int orientation){
        if(orientation == -1){
            return orientation;
        }else if(orientation == -2){
            return orientation;
        }else if(orientation == -3){
            return orientation;
        }else{
            return -4;
        }
    }
    
}

