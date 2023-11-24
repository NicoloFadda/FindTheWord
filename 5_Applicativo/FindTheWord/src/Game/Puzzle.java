package Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author nicolo.fadda
 * @version 15.09.2023
 *
 */
public class Puzzle {

    // <editor-fold defaultstate="collapsed" desc="Variabili">    
    private Controls controls;
    private char[][] puzzle;
    private Random random;
    private InsertWords insertWord;
    private int rows;
    private int cols;
    private int remainingCellCounter;
    private int secretWordLength;
    private String secretWord;
    private ArrayList<String> arWords = new ArrayList<String>();
    private ArrayList<String> dictionary = new ArrayList();
    int maxRow = 10;
    int maxCol = 10;
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Costruttore">     
    public Puzzle(int rows, int columns) {
        this.cols = columns;
        this.rows = rows;
        this.puzzle = new char[rows][columns];
        random = new Random();
        controls = new Controls();
        insertWord = new InsertWords();
        remainingCellCounter = rows * columns;
        //Fare in modo che sia in base alla parola max del dizionario 
        secretWordLength = 6;
    }
// </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Metodi di display e aiuto">     
    public void fillPuzzle() {
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                if (puzzle[i][j] == '\u0000') {//Controllo se la cella sia vuota
                    puzzle[i][j] = '-';
                }
            }
        }
    }
    //togliere arrayList e usarlo direttamente in Puzzle
    public void displayPuzzle() throws FileNotFoundException{
        fillPuzzle();

        readArList();

        Collections.shuffle(this.dictionary);

        setWordsWhileYouCan();
        
        findSecretWordInFile();
        
        insertSecretWord(getSecretWord());
        
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                System.out.print(puzzle[i][j] + " ");
            }
            System.out.println();
        }
    }
    //17.11
    //FARE METODO CHE CICLA TUTTA LA GRIGLIA ALLA FINE E TROVA "-"
    //QUANDO TROVATO --> SOSTITUIRLI CON CARATTERI PAROLA SEGRETA
    public void insertSecretWord(String secretWord) {
        int indexWord = 0;
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                if (puzzle[i][j] == '-') {

                    //Se è un trattino inserisco un carattere della parola segreta
                    puzzle[i][j] = secretWord.charAt(indexWord);
                    indexWord++;
                }
            }
        }
    }

    public void findSecretWordInFile() {
        for (String word : this.dictionary) {
            //Cerco una parola all'interno del dizionario che abbia la stessa
            //lunghezza della parola segreta
            if (word.length() == getRemainingCells()) {
                //return parola segreta
                setSecretWord(word);
                break;
            }
        }
    }

    public void readArList() throws FileNotFoundException {
        File dizionario = new File("src/Assets/dizionario.txt");
        Scanner scanner = new Scanner(dizionario);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            line = line.toUpperCase();
            this.dictionary.add(line);
        }
    }

    public void showWords() {
        System.out.println(arWords.toString());
    }  
// </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Getter & Setter"> 
    public char getValue(int row, int col) {
        return this.puzzle[row][col];
    }

    public int getRows() {
        return this.rows;
    }

    public int getColums() {
        return this.cols;
    }

    public int getRemainingCells() {
        return this.remainingCellCounter;
    }

    public int getSecretWordLength() {
        return this.secretWordLength;
    }
    
    public void setPuzzle(char[][] puzzle) {
        this.puzzle = puzzle;
    }
    public String getArWords() {
        return this.arWords.toString();
    }

    public int getArWordsSize() {
        return this.arWords.size();
    }

    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public ArrayList<String> getDictionary() {
        return dictionary;
    }

    public char[][] getPuzzle() {
        return puzzle;
    }

    public int getMaxRow() {
        return maxRow;
    }

    public int getMaxCol() {
        return maxCol;
    }
    
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Metodi setWord">   
    public void setWord(String word, int row, int col, int orientation) {

        boolean inBounds = controls.isInBounds(word, row, col, orientation, this);

        //System.out.println("checking " + word + " at (" + row + ";" + col + ") -> " + orientation + " len " + word.length() + " inBounds " + inBounds);

        if (inBounds) {
            if (controls.isValidOverlapping(word, row, col, orientation, this)) {
                insertWord.insertWord(word, row, col, orientation, puzzle);
                remainingCellCounter -= controls.getActualWordLength();
                arWords.add(word);
            }
        }
    }
    public void setWordsWhileYouCan() {
        while (getRemainingCells() > getSecretWordLength()) {
            int randomIndex = random.nextInt(this.dictionary.size());

            // Restituisce la parola corrispondente all'indice casuale
            String word = this.dictionary.get(randomIndex);
            int row = random.nextInt(maxRow);
            int col = random.nextInt(maxCol);

            int orientation = random.nextInt(8) - 8;
            if (word.length() > Consts.costanti.MIN_WORD_LENGTH) {
                if (!word.isBlank() || !word.isEmpty()) {
                    setWord(word, row, col, orientation);
                }
            }
        }
    }
    // </editor-fold> 
    




}
