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
public class Ruta {

    String codRuta; //Definido por 2 letras, las iniciales de las ciudades origen y destino, y 5 números
    String origen; //Ciudad en la que empieza la ruta
    String destino; //Ciudad en la que termina la ruta
    int kmRecorridos; //Kilómetros entre el origen y el destino
    String conductor; //DNI del conductor que realiza la ruta
    String autobus; //Matrícula del autobús que se utiliza para la ruta

    public Ruta(String codRuta, String origen, String destino, int kmRecorridos, String conductor, String autobus) {
        this.codRuta = codRuta;
        this.origen = origen;
        this.destino = destino;
        this.kmRecorridos = kmRecorridos;
        this.conductor = conductor;
        this.autobus = autobus;
    }

    public String getCodRuta() {
        return codRuta;
    }

    public void setCodRuta(String codRuta) {
        this.codRuta = codRuta;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getKmRecorridos() {
        return kmRecorridos;
    }

    public void setKmRecorridos(int kmRecorridos) {
        this.kmRecorridos = kmRecorridos;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getAutobus() {
        return autobus;
    }

    public void setAutobus(String autobus) {
        this.autobus = autobus;
    }

    @Override
    public String toString() {
        return codRuta + ";" + origen + ";" + destino + ";" + kmRecorridos + ";" + conductor + ";" + autobus + "\n";
    }

}
