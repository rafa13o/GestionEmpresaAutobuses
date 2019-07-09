/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafa
 */
public class GestoraEmpresa {

    Trabajador elTrabajador;
    Autobus elAutobus;
    Ruta laRuta;
    Cliente elCliente;
    Factura laFactura;
    Usuario elUsuario;

    //ALMACENAMIENTOS
    ArrayList<Trabajador> losTrabajadores = new ArrayList();
    ArrayList<Autobus> losAutobuses = new ArrayList();
    ArrayList<Ruta> lasRutas = new ArrayList();
    ArrayList<Cliente> losClientes = new ArrayList();
    ArrayList<Factura> lasFacturas = new ArrayList();
    ArrayList<Usuario> losUsuarios = new ArrayList();
    EnumSecciones[] lasSecciones = EnumSecciones.values();
    EnumCombustible[] losCombustibles = EnumCombustible.values();

    public GestoraEmpresa() {

        losTrabajadores.add(new Trabajador("12345678J", "TRECENIO RODRIGUEZ, RAFAEL", 2019, "CONDUCTOR"));
        losTrabajadores.add(new Trabajador("12345678Z", "TRECENIO RODRIGUEZ, RAFAEL", 2016, "DIRECCION"));
        losAutobuses.add(new Autobus("5188JSG", "IRIZAR", "I6S", "MECEDES-BENZ", "HIBRIDO", 55, 30000));
        losAutobuses.add(new Autobus("3515BVW", "IRIZAR", "I6", "RENAULT", "GASOLINA", 55, 30000));
        losAutobuses.add(new Autobus("9876JZP", "AYATS", "ATLANTIS", "SCANIA", "DIESEL", 70, 70000));
        losClientes.add(new Cliente("RAF123", "RAFAEL", "VALLADOLID", 123654789));
        losClientes.add(new Cliente("VAC123", "VACCEO CRAFT BEER S.L.", "MADRID", 917654321));
        lasRutas.add(new Ruta("VM00184", "VALLADOLID", "MADRID", 184, "12345678J", "5188JSG", "VAC123"));
        lasRutas.add(new Ruta("VP02262", "VALLADOLID", "POTSDAM", 2262, "12345678J", "9876JZP", "RAF123"));
        LocalDate fecha = LocalDate.of(2019, 07, 10);
        lasFacturas.add(new Factura(1, "RAFAEL", "VALLADOLID", 123654789, "VM00184", fecha, 36.8));
    }

    /**
     * Genera un nuevo trabajador
     *
     * @param dni
     * @param nomApe nombre y apellidos del trabajador
     * @param anio año de ingreso del trabajador
     * @param seccion sección en la que trabaja
     * @return true si se ha podido crear - false si ha ocurrido algún error
     */
    public boolean nuevoTrabajador(String dni, String nomApe, int anio, String seccion) {
        LocalDate fechaActual = LocalDate.now();
        int anioActual = fechaActual.getYear();
        ArrayList<String> losDni = new ArrayList();
        try {
            for (Trabajador unTrabajador : losTrabajadores) {
                losDni.add(unTrabajador.getDni());
            }
        } catch (NullPointerException err1) {

        }
        if (losDni.contains(dni) == false) {
            if (anio <= anioActual) {
                elTrabajador = new Trabajador(dni, nomApe, anio, seccion);
                losTrabajadores.add(elTrabajador);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "El año no puede ser posterior al actual.\n"
                        + "Por favor, revise los datos e inténtelo de nuevo", "Error - GESTIÓN DE EMPRESA ©", 1);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El DNI pertenece a un trabajador ya existente.\n"
                    + "Por favor, revise los datos e inténtelo de nuevo", "Error - GESTIÓN DE EMPRESA ©", 1);
        }
        return false;
    }

    /**
     * Genera un nuevo autobús a partir de los parámetros obtenidos de la
     * ventana
     *
     * @param matricula
     * @param fabricante
     * @param modelo
     * @param motor
     * @param combustible
     * @param plazas
     * @param precio
     * @return true si se ha podido crear - false si ha ocurrido algún error
     */
    public boolean nuevoAutobus(String matricula, String fabricante, String modelo, String motor, String combustible, int plazas, int precio) {
        ArrayList<String> lasMatriculas = new ArrayList();
        try {
            for (Autobus unAutobus : losAutobuses) {
                lasMatriculas.add(unAutobus.getMatricula());
            }
        } catch (NullPointerException err1) {

        }
        if (lasMatriculas.contains(matricula) == false) {
            elAutobus = new Autobus(matricula, fabricante, modelo, motor, combustible, plazas, precio);
            losAutobuses.add(elAutobus);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "La matrícula pertenece a un autobús ya existente.\n"
                    + "Por favor, revise los datos e inténtelo de nuevo", "Error - GESTIÓN DE EMPRESA ©", 1);
        }
        return false;
    }

    /**
     * Genera un nuevo cliente con los datos recogidos por la ventana
     *
     * @param codigo
     * @param nombre
     * @param localidad
     * @param telefono
     * @return true si se ha podido crear - false si ha ocurrido algún error
     */
    public boolean nuevoCliente(String codigo, String nombre, String localidad, int telefono) {
        ArrayList<String> losCodigosCliente = new ArrayList();
        try {
            for (Cliente unCliente : losClientes) {
                losCodigosCliente.add(unCliente.getCodCLiente());
            }
        } catch (NullPointerException err1) {

        }

        if (losCodigosCliente.contains(codigo) == false) {
            elCliente = new Cliente(codigo, nombre, localidad, telefono);
            losClientes.add(elCliente);
            return true;
        }
        return false;
    }

    /**
     * Genera una nueva ruta con los datos recogidos de la ventana
     *
     * @param codigo
     * @param inicio
     * @param destino
     * @param distancia
     * @param conductor
     * @param autobus
     * @param cliente
     * @return true si se ha podido crear - false si ha ocurrido algún error
     */
    public boolean nuevaRuta(String codigo, String inicio, String destino, int distancia, String conductor, String autobus, String cliente) {
        laRuta = new Ruta(codigo, inicio, destino, distancia, conductor, autobus, cliente);
        lasRutas.add(laRuta);
        return true;
    }

    /**
     * Genera una factura con los datos de la ventana
     *
     * @param cliente
     * @param ruta
     * @return true si se ha podido crear - false si ha ocurrido algún error
     */
    public boolean nuevaFactura(String cliente, String ruta) {
        ArrayList<Integer> numerosFacturas = new ArrayList();
        try {
            for (Factura unaFactura : lasFacturas) {
                numerosFacturas.add(unaFactura.getnFactura());
            }
        } catch (NullPointerException err1) {

        }
        int nFactura = numerosFacturas.size() + 1;
        int lugarClienteEnArray = 0;
        int lugarRutaEnArray = 0;
        String[] clientes = getLosCodClientes();
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i].equals(cliente)) {
                lugarClienteEnArray = i;
                break;
            }
        }
        String[] rutas = getLosCodRutas();
        for (int i = 0; i < rutas.length; i++) {
            if (rutas[i].equals(ruta)) {
                lugarRutaEnArray = i;
                break;
            }
        }
        Cliente clienteFactura = losClientes.get(lugarClienteEnArray);
        Ruta rutaFactura = lasRutas.get(lugarRutaEnArray);
        LocalDate fechaFactura = LocalDate.now();
        double precio = (rutaFactura.getKmRecorridos()) * 0.2;
        double precioFinal = Math.round(precio * 100) / 100d;

        laFactura = new Factura(nFactura, clienteFactura.getNombre(),
                clienteFactura.getLocalidad(), clienteFactura.getTelefono(),
                rutaFactura.getCodRuta(), fechaFactura, precioFinal);
        return true;
    }

    /**
     * Crea un array con las secciones del enum secciones para utilizarlo en el
     * ComboBox de las secciones a la hora de añadir un nuevo trabajador
     *
     * @return
     */
    public String[] getLasSecciones() {
        String[] secciones = new String[lasSecciones.length];
        for (int i = 0; i < secciones.length; i++) {
            secciones[i] = lasSecciones[i].toString();
        }
        return secciones;
    }

    /**
     * Crea un array con las secciones del enum de los combustibles para
     * utilizarlo en el ComboBox de los combustibles en la pestaña de añadir un
     * nuevo autobús
     *
     * @return
     */
    public String[] getLosCombustibles() {
        String[] combustibles = new String[losCombustibles.length];
        for (int i = 0; i < combustibles.length; i++) {
            combustibles[i] = losCombustibles[i].toString();
        }
        return combustibles;
    }

    /**
     * Devuelve los DNI de los conductores para formar el ComboBox de la ventana
     *
     * @return DNI
     */
    public String[] getLosDNI() {
        ArrayList<String> dniConductores = new ArrayList();
        try {
            for (Trabajador unTrabajador : losTrabajadores) {
                if ((unTrabajador.getSeccion()).equals("CONDUCTOR")) {
                    dniConductores.add(unTrabajador.getDni());
                }
            }
            String[] dni = new String[dniConductores.size()];
            for (int i = 0; i < dni.length; i++) {
                dni[i] = dniConductores.get(i);
            }
            return dni;
        } catch (NullPointerException err1) {

        }
        return null;
    }

    /**
     * Devuelve las matrículas de los autobuses ya registrados para utilizarlas
     * en los ComboBox de la ventana
     *
     * @return
     */
    public String[] getLasMatriculas() {
        ArrayList<String> lasMatriculas = new ArrayList();
        try {
            for (Autobus unAutobus : losAutobuses) {
                lasMatriculas.add(unAutobus.getMatricula());
            }
            String[] matricula = new String[lasMatriculas.size()];
            for (int i = 0; i < matricula.length; i++) {
                matricula[i] = lasMatriculas.get(i);
            }
            return matricula;
        } catch (NullPointerException err1) {

        }
        return null;
    }

    /**
     * Devuelve los códigos de los clientes ya registrados para utilizarlos en
     * los ComboBox de la ventana donde sean precisos
     *
     * @return
     */
    public String[] getLosCodClientes() {
        ArrayList<String> losCodClientes = new ArrayList();
        try {
            for (Cliente unCliente : losClientes) {
                losCodClientes.add(unCliente.getCodCLiente());
            }
            String[] cliente = new String[losCodClientes.size()];
            for (int i = 0; i < cliente.length; i++) {
                cliente[i] = losCodClientes.get(i);
            }
            return cliente;
        } catch (NullPointerException err1) {

        }
        return null;
    }

    /**
     * Devuelve los códigos de las rutas para utilizarlos en los ComboBox
     *
     * @return
     */
    public String[] getLosCodRutas() {
        ArrayList<String> losCodsRutas = new ArrayList();
        try {
            for (Ruta unaRuta : lasRutas) {
                losCodsRutas.add(unaRuta.getCodRuta());
            }
            String[] rutas = new String[losCodsRutas.size()];
            for (int i = 0; i < rutas.length; i++) {
                rutas[i] = losCodsRutas.get(i);
            }
            return rutas;
        } catch (NullPointerException err1) {

        }
        return null;
    }

    /**
     * Devuelve los fabricante de carrocerías de los autobuses para
     * posetriormente poder filtrar los autobuses siguiendo este criterio
     *
     * @return
     */
    public String[] getLosFabricantes() {
        ArrayList<String> losFabricantes = new ArrayList();
        try {
            for (Autobus unAutobus : losAutobuses) {
                String fCarroceria = unAutobus.getfCarroceria();
                if (losFabricantes.contains(fCarroceria) == false) {
                    losFabricantes.add(unAutobus.getfCarroceria());
                }
            }
            String[] fabricantes = new String[losFabricantes.size()];
            for (int i = 0; i < fabricantes.length; i++) {
                fabricantes[i] = losFabricantes.get(i);
            }
            return fabricantes;
        } catch (NullPointerException err1) {

        }
        return null;
    }

    //MODELOS DE TABLAS
    public Autobus[] getLosAutobuses(String fabricante) {
        ArrayList<Autobus> losBuses = new ArrayList();
        try {
            for (Autobus unAutobus : losAutobuses) {
                if (fabricante == null) {
                    losBuses.add(unAutobus);
                } else {
                    String carroceria = unAutobus.getfCarroceria();
                    if (carroceria.equals(fabricante)) {
                        losBuses.add(unAutobus);
                    }
                }
            }
            Autobus[] bus = new Autobus[losBuses.size()];
            for (int i = 0; i < bus.length; i++) {
                bus[i] = losBuses.get(i);
            }
            return bus;
        } catch (NullPointerException err1) {

        }
        return null;
    }

    public Trabajador[] getLosTrabajadores() {
        Trabajador[] trabajadores = new Trabajador[losTrabajadores.size()];
        try {
            for (int i = 0; i < trabajadores.length; i++) {
                trabajadores[i] = losTrabajadores.get(i);
            }
            return trabajadores;
        } catch (NullPointerException err1) {

        }

        return null;
    }

    public Cliente[] getLosClientes() {
        Cliente[] clientes = new Cliente[losClientes.size()];
        try {
            for (int i = 0; i < clientes.length; i++) {
                clientes[i] = losClientes.get(i);
            }
            return clientes;
        } catch (NullPointerException err1) {

        }
        return null;
    }

    public Ruta[] getLasRutas() {
        Ruta[] rutas = new Ruta[lasRutas.size()];
        try {
            for (int i = 0; i < rutas.length; i++) {
                rutas[i] = lasRutas.get(i);
            }
            return rutas;
        } catch (NullPointerException err1) {

        }
        return null;
    }

    public Factura[] getLasFacturas() {
        Factura[] facturas = new Factura[lasFacturas.size()];
        try {
            for (int i = 0; i < facturas.length; i++) {
                facturas[i] = lasFacturas.get(i);
            }
            return facturas;
        } catch (NullPointerException err1) {

        }
        return null;
    }
}
