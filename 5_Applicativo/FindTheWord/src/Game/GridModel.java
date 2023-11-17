/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author nicolo.fadda
 */
public class GridModel extends AbstractTableModel {

    char[][] matrix;

    GridModel(int grandezza) {
        matrix = new char[grandezza][grandezza];
    }

    
    public void insertGrid(char carattere, int row, int col){
        matrix[row][col] = carattere;
    }
    @Override
    public int getRowCount() {
        return matrix[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }
}
