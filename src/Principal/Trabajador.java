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
public class Trabajador {

    String dni; //DNI del trabajador (longitud 9)
    String nombreApellidos; //Nombre y Apellidos del trabajador
    int anioIngreso; //Año de ingreso (no superior al año actual)
    String seccion; //Sección en la que trabaja la persona

    public Trabajador(String dni, String nombreApellidos, int anioIngreso, String seccion) {
        this.dni = dni;
        this.nombreApellidos = nombreApellidos;
        this.anioIngreso = anioIngreso;
        this.seccion = seccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreApellidos() {
        return nombreApellidos;
    }

    public void setNombreApellidos(String nombreApellidos) {
        this.nombreApellidos = nombreApellidos;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnioIngreso(int anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    @Override
    public String toString() {
        return dni + ";" + nombreApellidos + ";" + anioIngreso + ";" + seccion+"\n";
    }

}
