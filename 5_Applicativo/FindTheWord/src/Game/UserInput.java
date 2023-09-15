package Game;

import java.awt.Font;
import java.io.File;

/**
 * 
 * @author nicolo.fadda
 * @version 15.09.2023
 * 
 */
public class UserInput {
    protected File dictionary;
    protected Boolean difficulty;
    protected byte printFormat;
    protected Font font;
    protected int[][] matrix;

    public File getDictionary() {
        return dictionary;
    }

    public void setDictionary(File dictionary) {
        this.dictionary = dictionary;
    }

    public Boolean getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Boolean difficulty) {
        this.difficulty = difficulty;
    }

    public byte getPrintFormat() {
        return printFormat;
    }

    public void setPrintFormat(byte printFormat) {
        this.printFormat = printFormat;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    
    
}
