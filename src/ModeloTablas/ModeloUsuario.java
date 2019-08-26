/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloTablas;

import Principal.Usuario;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rafa
 */
public class ModeloUsuario extends AbstractTableModel {

    Usuario[] elUsuario;
    String[] columnas = {"USUARIO",  "CLAVE"};
    Class[] tipos = {String.class, String.class};

    public ModeloUsuario(Usuario[] elUsuario) {
        this.elUsuario = elUsuario;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public int getRowCount() {
        return this.elUsuario == null ? 0 : this.elUsuario.length;
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return elUsuario[rowIndex].getDniAccesoUsuario();
            case 1:
                return elUsuario[rowIndex].getClave();
        }
        return null;
    }
}
