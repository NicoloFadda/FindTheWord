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
    private char[][] puzzleData;

    public GridModel(int grandezzaCampo) {
        this.puzzleData = new char[grandezzaCampo][grandezzaCampo];
    }

    @Override
    public int getRowCount() {
        return puzzleData.length;
    }

    @Override
    public int getColumnCount() {
        return puzzleData[0].length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        return puzzleData[row][column];
    }

    @Override
    public void setValueAt(Object value, int row, int column) {
        puzzleData[row][column] = (char)value;
        fireTableCellUpdated(row, column);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
