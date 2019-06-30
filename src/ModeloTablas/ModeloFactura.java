/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloTablas;

import Principal.Factura;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rafa
 */
public class ModeloFactura extends AbstractTableModel{

    Factura[] lasFacturas;
    String[] columnas = {"Nº FACTURA", "CLIENTE", "LOCALIDAD", "TELÉFONO", "RUTA", "FECHA DE FACTURA", "PRECIO"};
    Class[] tipos={Integer.class, String.class, String.class, Integer.class, String.class, Date.class, Integer.class};

    public ModeloFactura(Factura[] lasFacturas) {
        this.lasFacturas = lasFacturas;
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
        return lasFacturas.length;
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return lasFacturas[rowIndex].getnFactura();
            case 1:
                return lasFacturas[rowIndex].getCliente();
            case 2:
                return lasFacturas[rowIndex].getLocalidad();
            case 3:
                return lasFacturas[rowIndex].getTelefono();
            case 4:
                return lasFacturas[rowIndex].getRuta();
            case 5:
                return lasFacturas[rowIndex].getFechaFactura();
            case 6:
                return lasFacturas[rowIndex].getPrecio();
        }
        return null;
    }
    
}
