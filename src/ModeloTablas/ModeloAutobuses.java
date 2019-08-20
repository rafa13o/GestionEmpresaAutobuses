/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Principal.Autobus;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rafa
 */
public class ModeloAutobuses extends AbstractTableModel {

    Autobus[] elAutobus;
    String[] columnas = {"MATRÍCULA", "FABRICANTE", "MODELO", "MOTOR", "COMBUSTIBLE", "PLAZAS", "PRECIO"};
    Class[] tipos = {String.class, String.class, String.class, String.class, String.class, Integer.class, Integer.class};

    public ModeloAutobuses(Autobus[] elAutobus) {
        this.elAutobus = elAutobus;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return tipos[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return this.elAutobus[row].getMatricula();
            case 1:
                return this.elAutobus[row].getfCarroceria();
            case 2:
                return this.elAutobus[row].getModelo();
            case 3:
                return this.elAutobus[row].getfMotor();
            case 4:
                return this.elAutobus[row].getCombustible();
            case 5:
                return this.elAutobus[row].getPax();
            case 6:
                return this.elAutobus[row].getPrecioCompra();
        }
        return null;
    }

    @Override
    public int getRowCount() {
        return this.elAutobus == null ? 0 : this.elAutobus.length;
    }

    @Override
    public int getColumnCount() {
        return this.columnas.length;
    }
    
    public void setElAutobus(Autobus[] elAutobus) {
        this.elAutobus = elAutobus;
    }

}
