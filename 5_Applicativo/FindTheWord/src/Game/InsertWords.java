package Game;

/**
 *
 * @author nicolo.fadda
 * @version 06.10.2023
 *
 */
public class InsertWords {  
    // <editor-fold defaultstate="collapsed" desc="Metodi Insert Direzioni">  
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
    //6. ALGORITMO DIAGONALE BOTTOM-LEFT-TOP-RIGHT //DA ERRORI OUTOFBOUNDS
    public void insertDiagonalWordBLTR(String word, int row, int col, char[][] board) {
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            board[row - i][col + i] = word.charAt(i); 
        }
    }
    //7. ALGORITMO INVERSO ORIZZONTALE
    public void insertInverseWordHorizontal(String word, int row, int col, char[][] board) {
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            board[row][col - i] = word.charAt(i); 
        }
    }
    //7. ALGORITMO INVERSO VERTICALE
    public void insertInverseWordVertical(String word, int row, int col, char[][] board) {
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            //System.out.println("inserting char "+word.charAt(i) +" of "+ word+" at ("+row+";"+col+")  at row " + (row-i));
            board[row - i][col] = word.charAt(i);
        }
    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Metodo Insert Generale">  
    public void insertWord(String word, int row, int col, int orientation, char[][] board){
        switch(orientation){
            case Consts.costanti.HORIZONTAL:
                insertHorizontalWord(word, row, col, board);
                break;
            case Consts.costanti.VERTICAL:
                insertVerticalWord(word, row, col, board);
                break;
            case Consts.costanti.DIAGONAL_BRTL:
                insertDiagonalWordBRTL(word, row, col, board);
                break;
            case Consts.costanti.DIAGONAL_TRBL:
                insertDiagonalWordTRBL(word, row, col, board);
                break;
            case Consts.costanti.DIAGONAL_TLBR:
                insertDiagonalWordTLBR(word, row, col, board);
                break;
            case Consts.costanti.DIAGONAL_BLTR:
                insertDiagonalWordBLTR(word, row, col, board);
                break;
            case Consts.costanti.HORIZONTAL_INVERSE:
                insertInverseWordHorizontal(word, row, col, board);
                break;
            case Consts.costanti.VERTICAL_INVERSE:
                insertInverseWordVertical(word, row, col, board);
                break;
        }
    }
    // </editor-fold>
}
