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
public class Autobus {
    String matricula; //Matrícula española (4 números y 3 letras)
    String fCarroceria; //Nombre del fabricante de la carrocería
    String modelo; //Modelo del autobús
    String fMotor; //nombre del fabricante del motor
    String combustible; //Combusitble que utiliza el autobús
    int pax; //Número de pasajeros (10<pax<70)
    int precioCompra; //Precio por el que se compró el autobús

    public Autobus(String matricula, String fCarroceria, String modelo, String fMotor, String combustible, int pax, int precioCompra) {
        this.matricula = matricula;
        this.fCarroceria = fCarroceria;
        this.modelo = modelo;
        this.fMotor = fMotor;
        this.combustible = combustible;
        this.pax = pax;
        this.precioCompra = precioCompra;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getfCarroceria() {
        return fCarroceria;
    }

    public void setfCarroceria(String fCarroceria) {
        this.fCarroceria = fCarroceria;
    }

    public String getfMotor() {
        return fMotor;
    }

    public void setfMotor(String fMotor) {
        this.fMotor = fMotor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPax() {
        return pax;
    }

    public void setPax(int pax) {
        this.pax = pax;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    @Override
    public String toString() {
        return matricula + ";" + fCarroceria + ";" + modelo + ";" + fMotor + ";" + combustible + ";" + pax + ";" + precioCompra+"\n";
    }
    
    
}
