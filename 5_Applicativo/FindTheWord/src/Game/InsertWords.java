package Game;

/**
 *
 * @author nicolo.fadda
 * @version 06.10.2023
 *
 */
public class InsertWords {
    //1. ALGORITMO ORIZZONTALE
    public void insertHorizontalWord(String word, int row, int col, char[][] board) {
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            board[row][col + i] = word.charAt(i); 
        }
    }
    //2. ALGORITMO VERTICALE
    public void insertVerticalWord(String word, int row, int col, char[][] board) {
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            board[row + i][col] = word.charAt(i); 
        }
    }
    //3. ALGORITMO DIAGONALE BOTTOM-RIGHT-TOP-LEFT
    public void insertDiagonalWordBRTL(String word, int row, int col, char[][] board) {
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            board[row - i][col - i] = word.charAt(i); 
        }
    }
    //4. ALGORITMO DIAGONALE TOP-RIGHT-BOTTOM-LEFT
    public void insertDiagonalWordTRBL(String word, int row, int col, char[][] board) {
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            board[row + i][col - i] = word.charAt(i); 
        }
    }
    //5. ALGORITMO DIAGONALE TOP-LEFT-BOTTOM-RIGHT
    public void insertDiagonalWordTLBR(String word, int row, int col, char[][] board) {
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            board[row + i][col + i] = word.charAt(i); 
        }
    }
    //6. ALGORITMO DIAGONALE BOTTOM-LEFT-TOP-RIGHT
    public void insertDiagonalWordBLTR(String word, int row, int col, char[][] board) {
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            board[row - i][col + i] = word.charAt(i); 
        }
    }
    //7. ALGORITMO INVERSO
    public void insertInverseWord(String word, int row, int col, char[][] board) {
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            board[row][col - i] = word.charAt(i); 
        }
    }
}
