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
    
    Trabajador[] elTrabajador;
    String[] columnas = {"DNI", "NOMBRE Y APELLIDOS", "A�O DE INGRESO", "SECCI�N"};
    Class[] tipos = {String.class, String.class, Integer.class, String.class};

    public ModeloTrabajador(Trabajador[] elTrabajador) {
        this.elTrabajador = elTrabajador;
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
        return this.elTrabajador == null ? 0 : this.elTrabajador.length;
    }

    @Override
    public int getColumnCount() {
        return this.columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return elTrabajador[rowIndex].getDni();
            case 1:
                return elTrabajador[rowIndex].getNombreApellidos();
            case 2:
                return elTrabajador[rowIndex].getAnioIngreso();
            case 3:
                return elTrabajador[rowIndex].getSeccion();
        }
        return null;
    }
    
    public void setElTrabajador(Trabajador[] elTrabajador) {
        this.elTrabajador = elTrabajador;
    }
    
}
