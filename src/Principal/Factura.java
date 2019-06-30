/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.util.Date;


/**
 *
 * @author Rafa
 */
public class Factura {
    int nFactura;
    String cliente; //Nombre del cliente
    String localidad; //Localidad del cliente
    int telefono; //Teléfono del cliente
    String ruta; //codRuta solicitada
    Date fechaFactura; //Fecha en la que se ha creado la factura
    int precio; //precio = kms * 0.20

    public Factura(int nFactura, String cliente, String localidad, int telefono, String ruta, Date fechaFactura, int precio) {
        this.nFactura = nFactura;
        this.cliente = cliente;
        this.localidad = localidad;
        this.telefono = telefono;
        this.ruta = ruta;
        this.fechaFactura = fechaFactura;
        this.precio = precio;
    }

    public int getnFactura() {
        return nFactura;
    }

    public void setnFactura(int nFactura) {
        this.nFactura = nFactura;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
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

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
}
