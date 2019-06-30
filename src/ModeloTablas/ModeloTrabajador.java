/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloTablas;

import Principal.Trabajador;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rafa
 */
public class ModeloTrabajador extends AbstractTableModel{
    
    Trabajador[] elTrabajor;
    String[] columnas = {"DNI", "NOMBRE Y APELLIDOS", "AÑO DE INGRESO", "SECCIÓN"};
    Class[] tipos = {String.class, String.class, Integer.class, String.class};

    public ModeloTrabajador(Trabajador[] elTrabajor) {
        this.elTrabajor = elTrabajor;
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
    public int getRowCount() {
        return this.elTrabajor == null ? 0 : this.elTrabajor.length;
    }

    @Override
    public int getColumnCount() {
        return this.columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return elTrabajor[rowIndex].getDni();
            case 1:
                return elTrabajor[rowIndex].getNombreApellidos();
            case 2:
                return elTrabajor[rowIndex].getAnioIngreso();
            case 3:
                return elTrabajor[rowIndex].getSeccion();
        }
        return null;
    }
    
}
