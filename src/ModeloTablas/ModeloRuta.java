/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloTablas;

import Principal.Ruta;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rafa
 */
public class ModeloRuta extends AbstractTableModel {

    Ruta[] lasRutas;
    String[] columnas = {"CÓDIGO DE RUTA", "ORIGEN", "DESTINO", "KMS", "CONDUCTOR", "AUTOBÚS"};
    Class[] tipos = {String.class, String.class, String.class, Integer.class, String.class, String.class};

    public ModeloRuta(Ruta[] lasRutas) {
        this.lasRutas = lasRutas;
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
        return lasRutas.length;
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return lasRutas[rowIndex].getCodRuta();
            case 1:
                return lasRutas[rowIndex].getOrigen();
            case 2:
                return lasRutas[rowIndex].getDestino();
            case 3:
                return lasRutas[rowIndex].getKmRecorridos();
            case 4:
                return lasRutas[rowIndex].getConductor();
            case 5:
                return lasRutas[rowIndex].getAutobus();
        }
        return null;
    }

}
