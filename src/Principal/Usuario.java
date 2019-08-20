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

    String nombre; //Nombre del usuario que puede utilizar el servicio
    String usuario; //Nombre de usuario para el acceso
    String clave; //Clave de acceso
    boolean privilegios; //Privilegios para crear o borrar usuarios

    public Usuario(String nombre, String usuario, String clave, boolean privilegios) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.clave = clave;
        this.privilegios = privilegios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(boolean privilegios) {
        this.privilegios = privilegios;
    }

    @Override
    public String toString() {
        return usuario + ";" + nombre + ";" + clave + ";" + privilegios+"\n";
    }

}
