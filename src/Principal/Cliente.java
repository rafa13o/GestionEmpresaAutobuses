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
public class Cliente {
    String codCLiente; //3 primeras letras de su nombre + 3 números aleatorios
    String nombre; //Nombre del cliente (particular o empresa)
    String localidad; //Localidad del cliente/empresa
    int telefono; //Número de telefono del cliente

    public Cliente(String codCLiente, String nombre, String localidad, int telefono) {
        this.codCLiente = codCLiente;
        this.nombre = nombre;
        this.localidad = localidad;
        this.telefono = telefono;
    }

    public String getCodCLiente() {
        return codCLiente;
    }

    public void setCodCLiente(String codCLiente) {
        this.codCLiente = codCLiente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return codCLiente + ";" + nombre + ";" + localidad + ";" + telefono+"\n";
    }
    
    
}
