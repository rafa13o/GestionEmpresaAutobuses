/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

/**
 *
 * @author Rafa
 */
public class Usuario {

    String dniAccesoUsuario; //Nombre de dniAccesoUsuario para el acceso
    String clave; //Clave de acceso

    public Usuario( String usuario, String clave) {
        this.dniAccesoUsuario = usuario;
        this.clave = clave;
    }

    public String getDniAccesoUsuario() {
        return dniAccesoUsuario;
    }

    public void setDniAccesoUsuario(String dniAccesoUsuario) {
        this.dniAccesoUsuario = dniAccesoUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return dniAccesoUsuario + ";" + clave +"\n";
    }

}
