/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloTablas;

import Principal.Cliente;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rafa
 */
public class ModeloCliente extends AbstractTableModel{

    Cliente[] losClientes;
    String[] columnas = {"CÓDIGO DE CLIENTE", "NOMBRE", "LOCALIDAD","TELÉFONO"};
    Class[] tipos = {String.class, String.class, String.class, Integer.class};

    public ModeloCliente(Cliente[] losClientes) {
        this.losClientes = losClientes;
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
        return losClientes.length;
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return losClientes[rowIndex].getCodCLiente();
            case 1:
                return losClientes[rowIndex].getNombre();
            case 2:
                return losClientes[rowIndex].getLocalidad();
            case 3:
                return losClientes[rowIndex].getTelefono();
        }
        return null;
    }
    
}
